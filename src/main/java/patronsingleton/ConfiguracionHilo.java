package patronsingleton;

public class ConfiguracionHilo implements Runnable {

    private String nombreAplicacion;
    private String numeroVersion;

    public ConfiguracionHilo(String nombreAplicacion, String numeroVersion) {
        this.nombreAplicacion = nombreAplicacion;
        this.numeroVersion = numeroVersion;
    }

    @Override
    public void run() {
        // Obtener la instancia del Singleton
        ParametrizacionSingleton singleton = ParametrizacionSingleton.getInstance();

        // Sincronizar el bloque de modificación para evitar condiciones de carrera
        synchronized (singleton) {
            // Modificar las propiedades del Singleton
            singleton.setNombreAplicacion(nombreAplicacion);
            singleton.setNumeroVersion(numeroVersion);

            // Imprimir el estado actual del Singleton
            System.out.println(Thread.currentThread().getName() + " => " + singleton);
        }
    }
}
