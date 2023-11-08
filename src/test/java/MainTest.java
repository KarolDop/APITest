import files.AddPetJson;
import headers.HeadersProject;
import io.restassured.RestAssured;
import org.example.Pet;
import org.testng.annotations.Test;

import java.io.File;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MainTest
{
    @Test
    public void Test()
    {
        File body = new File("D:\\Java\\Json\\body.json");
        Pet newPet = new Pet("Azor", "Pies");

        RestAssured.baseURI = "https://petstore.swagger.io";
        given().log().all()
                .headers(HeadersProject.headersAddPet())
                .body(AddPetJson.AddPet(newPet))
                //.body(AddPetJson())
        .when().post("v2/pet")
        .then().assertThat().statusCode(200).body("status", equalTo("available"));
    }
}
