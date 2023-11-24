package mainTest;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse
{
    static JsonPath js = new JsonPath(files.AddPetJson.price());

    public static int count = js.getInt("contents.size()");
    public static int totalAmount = js.getInt("dashboard.purchaseAmount");
    public static String firstName = js.get("contents[0].name");
}