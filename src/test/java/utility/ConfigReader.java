package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try {
            // Load configuration
            String path = "src/test/resources/config/config.properties";
            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);
            fis.close();
            System.out.println("Configuration loaded from: " + path);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    // Generic getter
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Specific convenience getters
    public static String getBaseUrl() {
        return getProperty("base.url");
    }

    public static String getEnvironment() {
        return getProperty("environment");
    }

    public static int getTimeout() {
        return Integer.parseInt(getProperty("timeout"));
    }
}
