package utils;

import aquality.selenium.browser.AqualityServices;
import com.google.gson.Gson;
import lombok.experimental.UtilityClass;

import java.io.FileNotFoundException;
import java.io.FileReader;

@UtilityClass
public class JsonUtils {
    private final String JSON_DESERIALIZE_ERROR_MSG = "Could not deserialize JSON file at '%s'. Cause: %s";
    private final Gson GSON = new Gson();

    public <T> T deserializeJson(String filePath, Class<T> tClass) {
        try {
            return GSON.fromJson(new FileReader(filePath), tClass);
        } catch (FileNotFoundException e) {
            AqualityServices.getLogger().error(JSON_DESERIALIZE_ERROR_MSG.formatted(filePath, e));
            throw new RuntimeException(JSON_DESERIALIZE_ERROR_MSG.formatted(filePath, e));
        }
    }
}
