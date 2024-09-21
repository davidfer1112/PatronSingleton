# Documentación del Repositorio PatronSingleton

## Descripción

Este repositorio contiene una implementación del patrón de diseño Singleton en Java. El patrón Singleton garantiza que una clase tenga una única instancia y proporciona un punto de acceso global a esainstancia. Este ejemplo específico demuestra cómo el patrón Singleton puede ser utilizado para configurar propiedades de una aplicación de manera segura en un entorno multihilo.

## Estructura del Repositorio

El repositorio se organiza de la siguiente manera:

- `.idea/`: Contiene archivos de configuración específicos del IDE IntelliJ IDEA.
  - [`misc.xml`](https://github.com/davidfer1112/patronsingleton/tree/main/.idea/misc.xml): Configuraciones misceláneas del proyecto.
  - [`vcs.xml`](https://github.com/davidfer1112/patronsingleton/tree/main/.idea/vcs.xml): Configuraciones del sistema de control de versiones.
  - [`encodings.xml`](https://github.com/davidfer1112/patronsingleton/tree/main/.idea/encodings.xml): Configuraciones de codificación de caracteres.
- `src/main/java/patronsingleton/`: Contiene el código fuente de la implementación del patrón Singleton.
  - [`PatronSingletonMain.java`](https://github.com/davidfer1112/patronsingleton/tree/main/src/main/java/patronsingleton/PatronSingletonMain.java): Clase principal que ejecuta la demostración del patrón Singleton.
  - [`ParametrizacionSingleton.java`](https://github.com/davidfer1112/patronsingleton/tree/main/src/main/java/patronsingleton/ParametrizacionSingleton.java): Clase Singleton que mantiene la configuración de la aplicación.
  - [`ConfiguracionHilo.java`](https://github.com/davidfer1112/patronsingleton/tree/main/src/main/java/patronsingleton/ConfiguracionHilo.java): Implementa la interfaz `Runnable` para modificar la configuración del Singleton en un entorno multihilo.
- `src/main/java/utilidades/`: Contiene clases de utilidad.
  - [`UtilidadesAcceso.java`](https://github.com/davidfer1112/patronsingleton/tree/main/src/main/java/utilidades/UtilidadesAcceso.java): Clase de utilidad para cargar propiedades.
- [`pom.xml`](https://github.com/davidfer1112/patronsingleton/tree/main/pom.xml): Archivo de configuración de Maven para la gestión de dependencias y construcción del proyecto.

## Cómo Funciona

El programa crea tres hilos que intentan modificar las propiedades de la única instancia del Singleton `ParametrizacionSingleton`. Cada hilo se inicia con diferentes valores para las propiedades `nombreAplicacion` y `numeroVersion`. La sincronización dentro del método `run` de la clase `ConfiguracionHilo` asegura que los cambios se realicen de manera segura en un entorno multihilo.

```java
public static void main(String[] args) {
    Thread hilo1 = new Thread(new ConfiguracionHilo("App Hilo 1", "1.1"));
    Thread hilo2 = new Thread(new ConfiguracionHilo("App Hilo 2", "1.2"));
    Thread hilo3 = new Thread(new ConfiguracionHilo("App Hilo 3", "1.3"));

    hilo1.start();
    hilo2.start();
    hilo3.start();

    try {
        hilo1.join();
        hilo2.join();
        hilo3.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    ParametrizacionSingleton singletonFinal = ParametrizacionSingleton.getInstance();
    System.out.println("Estado final del Singleton: " + singletonFinal);
}

```

# Requisitos

Para ejecutar este proyecto, necesitarás:

- JDK 17 o superior.
- Maven para gestionar dependencias y construir el proyecto.

## Compilación y Ejecución

Para compilar y ejecutar el proyecto, sigue estos pasos:

1. Clona el repositorio.
2. Navega al directorio raíz del proyecto.
3. Ejecuta `mvn clean install` para construir el proyecto.
4. Ejecuta `java -cp target/NombreDelJar.jar patronsingleton.PatronSingletonMain` para iniciar la aplicación.
