package utils;

import models.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestDataReader {
    public final String TEST_DATA_PATH = JsonUtils.RESOURCES_PATH + "testdata/";
    private final String DATA_TABLE_FILE_PATH = TEST_DATA_PATH + "dataTableData.json";
    private final String FILE_DATA_PATH = TEST_DATA_PATH + "fileData.json";
    private final String USER_DATA_FILE_PATH = TEST_DATA_PATH + "userData.json";

    public UserData getUserData() {
        return JsonUtils.deserializeJson(USER_DATA_FILE_PATH, UserData.class);
    }

    public DataTableData getDataTableData() {
        return JsonUtils.deserializeJson(DATA_TABLE_FILE_PATH, DataTableData.class);
    }

    // Since FileData model is not yet present in BDD, we comment this out for now
    // public FileData getFileData() {
    //     return JsonUtils.deserializeJson(FILE_DATA_PATH, FileData.class);
    // }
}
