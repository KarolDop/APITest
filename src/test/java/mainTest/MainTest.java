package mainTest;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.restassured.RestAssured;

public class MainTest
{
    @BeforeAll
    public static  void setUp()
    {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @BeforeStep
    public static void newStepPrint(int stepNo)
    {
        System.out.printf("Step %d:\n", stepNo);
    }
}