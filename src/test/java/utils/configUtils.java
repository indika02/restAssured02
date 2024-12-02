package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class configUtils {

    private static Map<String, Object> config;

    static {
        ObjectMapper mapper = new ObjectMapper();
        try {
            config = mapper.readValue(new File("config/config.json"), Map.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read config.json", e);
        }
    }

    public static String getBaseUri(String uri) {
        return ((Map<String, String>) config.get("api")).get(uri);
    }
}


