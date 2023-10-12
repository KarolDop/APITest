package headers;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.util.ArrayList;
import java.util.List;

public class HeadersProject
{
    public static Headers AddPet()
    {
        Header first = new Header("accept", "application/json");
        Header second = new Header("Content-Type","application/json");

        List<Header> list = new ArrayList<Header>();
        list.add(first);
        list.add(second);

        return new Headers(list);
    }
}
