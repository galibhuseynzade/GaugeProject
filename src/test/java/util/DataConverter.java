package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.restassured.response.Response;

import java.util.List;

public class DataConverter {
    private static final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    public static <T> List<T> convertToList(Response response, Class<T> clazz) {
        try {
            return mapper.readValue(
                    response.getBody().asString(),
                    mapper.getTypeFactory().constructCollectionType(List.class, clazz)
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert response to list: " + e.getMessage(), e);
        }
    }

    public static <T> T convertToObject(Response response, Class<T> clazz) {
        try {
            return mapper.readValue(response.getBody().asString(), clazz);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert response to object: " + e.getMessage(), e);
        }
    }

    public static <T> T convertFromJson(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert JSON to object: " + e.getMessage(), e);
        }
    }
}
