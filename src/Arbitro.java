import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Arbitro extends Thread {
	
	//Creamos las variables
	private final Cola cola;
	private final int numAleatorio = new Random().nextInt(50) + 1;
	private int ronda = 1;
	public static int turno = 0;
	public static boolean acertado = false;

	private static CyclicBarrier barrera = null;
	private List<Jugador> jugadores;

	//Creamos el constructor para que los objetos de la clase solo se puedan construtir asi
	public Arbitro(Cola cola, List<Jugador> jugadores, CyclicBarrier barrera) {
		this.cola = cola;
		this.jugadores = jugadores;
		this.barrera = barrera;
	}

	//Sobreescrbibimos el metodo run
	@Override
	public void run() {
		
		//Imprimimos el numero ganador
		System.out.println("EL ARBITRO A ESCOGIDO EL Nº " + numAleatorio);

		//Este bucle se ejecuta hasta que el jugador acierta
		while (!acertado) {
			System.out.println("\nRONDA " + ronda + " - TURNO " + ++turno);
			System.out.println("-------");

			//Vemos si es el final de la ronda o no
			if (turno == 5) {
				ronda += 1;
				turno = 1;
			}

			//Esperamos en la barrera hasta que los jugadores esten listos
			try {
				barrera.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}

			int jugada = cola.obtener();

			//Comprobamos si el numero del jugador es el ganador o no
			if (jugada == numAleatorio) {
				acertado = true;
				System.out.println("GANADOR!!! el jugador " + turno);
			}
			
			//Esperamos en la barrera y esperamos al siguiente turno
			try {
				barrera.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
			
		}
	}
}