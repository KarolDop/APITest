package headers;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.util.ArrayList;
import java.util.List;

public class HeadersProject
{
    public static Headers headersAddPet()
    {
        Header accept = new Header("accept", "application/json");
        Header contentType = new Header("Content-Type","application/json");

        List<Header> list = new ArrayList<Header>();
        list.add(accept);
        list.add(contentType);

        return new Headers(list);
    }
}