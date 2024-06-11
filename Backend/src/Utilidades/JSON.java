package Utilidades;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class JSON {
    public static <T> List<T> importarJson(String filePath, Class<T> clase) throws Exception {
        // Convertir JSON a una lista de objetos Java de la clase especificada
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath),
                objectMapper.getTypeFactory().constructCollectionType(List.class, clase));
    }

    public static <T> void guardarJson(String filePath, List<T> objetos) throws Exception {
        // Escribir la lista de objetos de vuelta al archivo JSON
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(filePath), objetos);
    }
}
