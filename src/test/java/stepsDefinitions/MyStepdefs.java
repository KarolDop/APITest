package stepsDefinitions;

import headers.HeadersProject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import mainTest.ComplexJsonParse;
import mainTest.MainTest;
import org.example.Pet;
import files.AddPetJson;
import org.testng.Assert;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

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

        Assert.assertEquals(idGetPet, idAddPet);
    }

    @And("Mock response content count should be {int}")
    public void mockResponseContentCountShouldBe(int arg)
    {
        Assert.assertEquals(ComplexJsonParse.count, arg);
    }

    @And("Mocked resp purch amount should be {int}")
    public void mockedRespPurchAmountShouldBe(int arg)
    {
        Assert.assertEquals(ComplexJsonParse.totalAmount, arg);
    }

    @And("First content name should be {word}")
    public void firstContentNameShouldBeRed(String arg)
    {
        Assert.assertEquals(ComplexJsonParse.firstName ,arg);
    }
}