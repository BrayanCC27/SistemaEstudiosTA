package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {
    private static final String CONFIG_FILE = "config.properties";
    private static Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("No se pudo cargar la configuración, usando valores por defecto.");
        }
    }

    public static String getVista() {
        return properties.getProperty("vista");
    }
}
