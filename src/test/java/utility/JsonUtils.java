package utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtils {

    /**
     * Reads a JSON file from the test resources folder
     * @param fileName name of the JSON file (e.g., "post_request.json")
     * @return JSON content as a String
     */
    public static String readJson(String fileName) {
        try {
            // Use cross-platform safe path builder
            String path = Paths.get("src", "test", "resources", "testData", fileName).toString();
            return Files.readString(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file: " + fileName, e);
        }
    }
}
