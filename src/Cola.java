public class Cola {
	
	//Creamos las variables
    private int valor;
    private boolean estaDisponible = false;

    //Metodo para sincronizar el valor disponible en la cola
    public synchronized int obtener() {
        //Este bucle nos sirve para ver si hay un valor disponible
    	while (!estaDisponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupción");
            }
        }

    	//Cambiamos el valor a disponible y avisamos a los hilos
        estaDisponible = false;
        notifyAll();
        return valor;
    }

    //Este metodo sincroniza y agrega un valor a la cola
    public synchronized void agregar(int valor) {
    	//Este bucle es para ver si la cola ya tiene un valor o no
        while (estaDisponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupción");
            }
        }

        //Actualizamos el valor de la cola y cambiamos el valor a dispoible y luego avisamos
        this.valor = valor;
        estaDisponible = true;
        notifyAll();
    }
}
