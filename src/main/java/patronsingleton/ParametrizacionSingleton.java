package patronsingleton;

import java.util.Properties;
import utilidades.UtilidadesAcceso;

public class ParametrizacionSingleton {
    private static ParametrizacionSingleton singleton;

    private static final String CONFIGURATION_PROP = "propiedades/ConfiguracionPropiedades.properties";

    private static final String NOMBRE_APLICACION_PROP = "nombreAplicacion";
    private static final String NUMERO_VERSION_PROP = "numeroVersion";

    private String nombreAplicacion;
    private String numeroVersion;

    private ParametrizacionSingleton() {
        Properties prop = UtilidadesAcceso.loadProperty(CONFIGURATION_PROP);
        this.nombreAplicacion = prop.getProperty(NOMBRE_APLICACION_PROP);
        this.numeroVersion = prop.getProperty(NUMERO_VERSION_PROP);
    }

    private static synchronized void createInstance(){
        if(singleton == null){
            singleton = new ParametrizacionSingleton();
        }
    }

    public static ParametrizacionSingleton getInstance() {
        if(singleton == null) {
            createInstance();
        }
        return singleton;
    }

    // Métodos sincronizados para evitar condiciones de carrera
    public synchronized void setNombreAplicacion(String nombreAplicacion) {
        this.nombreAplicacion = nombreAplicacion;
    }

    public synchronized void setNumeroVersion(String numeroVersion) {
        this.numeroVersion = numeroVersion;
    }

    public synchronized String getNombreAplicacion() {
        return nombreAplicacion;
    }

    public synchronized String getNumeroVersion() {
        return numeroVersion;
    }

    @Override
    public synchronized String toString() {
        return "ParametrizacionSingleton{" + "nombreAplicacion=" + nombreAplicacion + ", numeroVersion=" + numeroVersion + '}';
    }
}
