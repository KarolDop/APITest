package stepsDefinitions;

import headers.HeadersProject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import mainTest.MainTest;
import org.example.Pet;
import files.AddPetJson;

import java.math.BigInteger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MyStepdefs {
    Pet newPet;
    BigInteger idAddPet;

    @Given("I have a new pet from category {word} with name {word} that i want add to shop db")
    public void iHaveANewPetFromCategoryPetWithNameAzorThatIWantAddToShopDb(String categoryName, String petName)
    {
        MainTest.setUp();
        newPet = new Pet(petName, categoryName);
    }

    @When("I add this pet")
    public void iAddThisPet()
    {
        Response addPetResponse = given()
                .headers(HeadersProject.headersAddPet())
                .body(AddPetJson.AddPet(newPet))
                .when().post("pet");

        JsonPath js = addPetResponse.jsonPath();
        idAddPet = new BigInteger(js.getString("id"));
    }

    @Then("Pet from category dog and name azor should be added")
    public void petFromCategoryDogAndNameAzorShouldBeAdded()
    {
        Response getPet = given()
                .headers(HeadersProject.headersAddPet())
                .get("pet/{0}",idAddPet);

        JsonPath js = getPet.jsonPath();
        BigInteger idGetPet = new BigInteger(js.getString("id"));
        String getName = js.getString("name");

        if (idGetPet.equals(idAddPet))
        {
            System.out.println("Pass");

        }
        else
        {
            System.out.println("Fail");
        }

        if(getName.equals(newPet.getPetName()))
        {
            System.out.println("Pass");
        }
        else
        {
            System.out.println("Fail");
        }

    }
}