// src/main/java/utils/ConfigLoader.java
package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Не удалось найти config.properties");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при загрузке config.properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}