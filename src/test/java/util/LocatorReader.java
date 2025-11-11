package util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LocatorReader {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Map<String, By> map = new HashMap<>();
    private static final String path = "src/test/resources/elements/";

    public static By get(String pageName, String elementName) {
        String key = pageName + "." + elementName;
        if (map.containsKey(key)) return map.get(key);

        try {
            File file = new File(path + pageName + ".json");
            JsonNode root = mapper.readTree(file);
            JsonNode node = root.path(elementName);
            if (node.isMissingNode())
                throw new IllegalArgumentException("Element '" + elementName + "' not found in " + pageName + ".json");

            String type = node.path("type").asText();
            String value = node.path("value").asText();

            By locator = switch (type.toUpperCase()) {
                case "ID" -> By.id(value);
                case "NAME" -> By.name(value);
                case "CLASS" -> By.className(value);
                case "LINKTEXT" -> By.linkText(value);
                case "CSS" -> By.cssSelector(value);
                case "XPATH" -> By.xpath(value);
                default -> throw new IllegalArgumentException("Unsupported locator type: " + type);
            };

            map.put(key, locator);
            return locator;

        } catch (IOException e) {
            throw new RuntimeException("Failed to read locator from " + pageName + ".json", e);
        }
    }
}
