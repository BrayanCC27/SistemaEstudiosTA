package Utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LectorTxt {

    public static String leerArchivoComoString(String rutaArchivo) throws IOException {
        return Files.readString(Paths.get(rutaArchivo), StandardCharsets.UTF_8);
    }
    

}
