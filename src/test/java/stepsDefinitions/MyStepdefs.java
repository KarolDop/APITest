package stepsDefinitions;

import headers.HeadersProject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.example.Pet;
import files.AddPetJson;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MyStepdefs {
    Pet newPet;

    @Given("I have a new pet from category {word} with name {word} that i want add to shop db")
    public void iHaveANewPetFromCategoryPetWithNameAzorThatIWantAddToShopDb(String categoryName, String petName)
    {
        newPet = new Pet(petName, categoryName);
    }

    @When("I add this pet")
    public void iAddThisPet()
    {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given().log().all()
                .headers(HeadersProject.headersAddPet())
                //.body(body)
                .body(AddPetJson.AddPet(newPet))
                .when().post("pet")
                .then().assertThat().statusCode(500);//.body("status", equalTo("available"));
    }
}