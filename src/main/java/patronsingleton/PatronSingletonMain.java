package patronsingleton;

public class PatronSingletonMain {

    public static void main(String[] args) {
        // Creando tres hilos que modificarán las propiedades del Singleton
        Thread hilo1 = new Thread(new ConfiguracionHilo("App Hilo 1", "1.1"));
        Thread hilo2 = new Thread(new ConfiguracionHilo("App Hilo 2", "1.2"));
        Thread hilo3 = new Thread(new ConfiguracionHilo("App Hilo 3", "1.3"));

        // Iniciando los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();

        // Esperar a que todos los hilos terminen
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verificar el estado final del Singleton
        ParametrizacionSingleton singletonFinal = ParametrizacionSingleton.getInstance();
        System.out.println("Estado final del Singleton: " + singletonFinal);
    }
}
