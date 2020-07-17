package cl.prezdev.util.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Json {
    public static String toJsonString(Object object) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
    
    public static void toJsonFile(File jsonFile, Object object) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, object);
    }
    
    public static <T> T toObject(String json, Class<T> _class) throws IOException {
        return new ObjectMapper().readValue(json, _class);
    }
    
    public static <T> T toObject(File jsonFile, Class<T> _class) throws IOException {
        return new ObjectMapper().readValue(jsonFile, _class);
    }
}
