package CommonComponents;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;

public class TestConfig {

    RequestSpecification req;
    Response res;

    static String homePage = "https://developer.oxforddictionaries.com/documentation#!/Dictionary32entries/get_entries_source_lang_word_id";
    static String baseUrl = "https://od-api.oxforddictionaries.com/api/v1/entries";

    static String id = "79c029a8";
    static String key = "93fab3f3cbaae7c2216ea63b2ff1e087";

    String responseFormat = "application/json";
    String language = "en";
    String keyword = "God";

    File testDataPath = new File("apiTestsData.xlsx");

}
