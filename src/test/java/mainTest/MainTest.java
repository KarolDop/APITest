package mainTest;

import files.AddPetJson;
import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class MainTest
{
    @BeforeAll
    public static  void setUp()
    {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }


    static JsonPath js = new JsonPath(AddPetJson.price());


}
