package CommonComponents;

import org.junit.Test;

import java.io.FileInputStream;
import static io.restassured.RestAssured.given;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main extends TestConfig{

    @Test
    //API headers
    public void apiCredentials()
    {
        req = given().headers("Accept", responseFormat)
                .and().headers("app_id", id)
                .and().headers("app_key", key);
    }

    //@Test
    //request specification with search word
    public void requestSpec()
    {
        apiCredentials();
        res = req.when().get(baseUrl + "/" + language.toLowerCase() + "/" + keyword.toLowerCase());
    }

    //@Test
    //Get the Response status code
    public void getResponscode()
    {
        requestSpec();
        int code = res.getStatusCode();
        System.out.println("The response code is: " + code + "\n");
    }

    //@Test
    //Get the Response status line
    public void getStatusLine()
    {
        requestSpec();
        String statusline = res.getStatusLine().toString();
        System.out.println("The response status is: " + statusline + "\n");
    }

    //@Test
    //print the Response Content
    public void getResponseContent()
    {
        requestSpec();
        String responseContent = res.asString();
        System.out.println("The API response content is: " + "\n\n" + responseContent + "\n");
    }

    //@Test
    //Static search for a valid word
    public void validateValidKeywordResponses()
    {
        apiCredentials();
        req.when().get("https://od-api.oxforddictionaries.com/api/v1/entries/en/god")
                .then().statusCode(200).log().all();
    }

    //@Test
    //Static search for a Invalid word
    public void validateInvalidKeywordResponses()
    {
        apiCredentials();
        req.when().get("https://od-api.oxforddictionaries.com/api/v1/entries/123/qwe")
                .then().statusCode(404).log().all();
    }

    //Search words
    public void validateRandomWordSearchResponses()
    {
        apiCredentials();
        try
        {
            FileInputStream ip = new FileInputStream(testDataPath);
            XSSFWorkbook wb = new XSSFWorkbook(ip);
            XSSFSheet sheet = wb.getSheet("apiTestsData");

            int startRow = sheet.getFirstRowNum();
            int endRow = sheet.getLastRowNum();

            for (int i = startRow+2 ; i <=endRow; i++)
            {
                keyword = sheet.getRow(i).getCell(1).getStringCellValue();
                res = req.when().get(baseUrl + "/" + language.toLowerCase() + "/" + keyword.toLowerCase());

                String status = res.getStatusLine().toString();

                if (status.contains("200"))
                {
                    System.out.println("You are searching word is: " + keyword + ", 200: It's a valid word search" + "\n");

                    System.out.printf("Complete details below:" + "\n");
                    res.then().log().all();
                }
                else
                    System.out.println("You are searching word is: " + keyword + ", 404: It's not a valid word search" + "\n\n");
            }
            wb.close();
            ip.close();
        }

        catch(Exception e)
        {
            System.out.println("The exceptions: " + e);
        }
    }

}
