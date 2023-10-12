import files.Payload;
import headers.HeadersProject;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import org.testng.annotations.Test;
import org.hamcrest.Matchers.*;
import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MainTest
{
    @Test
    public void Test()
    {
        File body = new File("D:\\Java\\Json\\body.json");

        RestAssured.baseURI = "https://petstore.swagger.io";
        given().log().all()
                .header("accept", "application/json")
                .header("Content-Type","application/json")
                .headers(HeadersProject.AddPet())
                .body(body)
        .when().post("v2/pet")
        .then().assertThat().statusCode(200).body("status", equalTo("available"));
    }
}
