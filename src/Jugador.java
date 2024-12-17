import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Jugador extends Thread {
	
	//Creamos las variables
	int nJugador;
	private static CyclicBarrier ba = null;
	Cola c;

	//Creamos un constructor, ahora solo podemos crear objetos de esta clase de la siguiente forma
	public Jugador(Cola c, CyclicBarrier ba, int nJugador) {
		this.c = c;
		this.nJugador = nJugador;
		this.ba = ba;
	}

	//Este metodo nos crea un numero random a partir de los numero pasados
	public static int random(int maximo, int minimo) {
		Random rand = new Random();
		return rand.nextInt((maximo - minimo) + 1) + minimo;
	}

	//Creamos una lista statica para que sea igual para todos los objetos
	static List<Integer> listanumeros = new ArrayList<>();

	
	//Sobreescribimos el metodo run
	@Override
	public void run() {
		
		//Creamos un bucle infinito controlado
		while (!Arbitro.acertado) {
			
			//Esperamos en la barrera hasta que los jugadores esten listos
			try {
				ba.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
			
			//Comprobamos que sea el turno del jugador
			if (Arbitro.turno == nJugador) {
				
				int jugada;
				
				//Genereamos un numero aleatorio y vemos que no haya salido ya 
				do {
					jugada = random(50, 1);
				} while (listanumeros.contains(jugada));
				
				//Agregamos la jugada a la lista e imprimimos por pantalla el mensaje
				listanumeros.add(jugada);
				System.out.println("\tNº jugador " + nJugador + " apuesta al número " + jugada);
				c.agregar(jugada);
				
			}else {
				//Si no es el turno del jugador lo imprimimos tambien
				System.out.println("\tNº jugador " + nJugador + " No es su turno");
	
			}
			
			//Esperamos en la barrera hasta el siguiente turno
			try {
				ba.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
