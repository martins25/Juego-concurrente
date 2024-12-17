import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class Principal {
	
	//Creamos las variables
	private static final CyclicBarrier ba = new CyclicBarrier(6);
	static Arbitro arbitro;
	
	
	public static void main(String[] args) {
		//Creamos un objeto de la clase cola
		Cola c = new Cola();
		
		//Incialiazamos la lista de los jugadores y le pasamos la barrera
		List<Jugador> jugadas = inicializarJugadores(c, ba);
		
		//Invocamos a los metodos
		iniciarArbitro(c, jugadas);
		iniciarJugadores(jugadas);
	}

	//Este metodo nos sirve para inicaarliazar a los jugadores 
	private static List<Jugador> inicializarJugadores(Cola c, CyclicBarrier ba) {
		List<Jugador> jugadas = new ArrayList<Jugador>();
		for (int i = 1; 5 >= i; i++) {
			jugadas.add(new Jugador(c, ba, i));
		}
		return jugadas;
	}

	//Este metodo nos inicia los arbitros
	private static void iniciarArbitro(Cola c, List<Jugador> jugadas) {
		arbitro = new Arbitro(c, jugadas, ba);
		arbitro.start();
	}

	//Este metodo nos incia los jugadores
	private static void iniciarJugadores(List<Jugador> jugadas) {
		for (Jugador jugadores : jugadas) {
			jugadores.start();
		}
	}
}
