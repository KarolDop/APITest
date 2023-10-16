package StepsDefinitions;

import io.cucumber.java.en.Given;
import org.example.Pet;

public class PetSteps
{
    @Given("I have a new pet from category pet with name azor that i want add to shop db")
    public void petWithNameAndCategory(String petCategory, String petName)
    {
        Pet dog = new Pet(petName, petCategory);
    }
}
