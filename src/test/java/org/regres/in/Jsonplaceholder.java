package org.regres.in;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class Jsonplaceholder {
    @Before
    public void listener()
    {
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/"; 
    }

    @Test
    public void post()
    {
        Response resp1= given().when().get("\n" +
                "/posts");
        resp1.prettyPrint();
        Response resp2=given().when().get("\t/posts/1");
        resp2.prettyPrint();
        Response resp3=given().when().get("/posts/1/comments") ;
        resp3.prettyPrint();
        Response resp4=given().when().get("\t/comments?postId=1");
        resp4.prettyPrint();
        Response resp5=given().when().get("\t/posts?userId=1");
        resp5.prettyPrint();
        
    }
}
