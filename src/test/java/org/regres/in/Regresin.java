package org.regres.in;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;


public class Regresin {
    @Before
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in/";

    }

    @Test
    public void listeners() {
        Response resp = given().when().get("/api/users?page=2");
        resp.prettyPrint();
        resp.then().body("page", equalTo(2))
                .body("data.first_name", hasItems("Michael", "Lindsay", "Tobias"))
                .statusCode(200).body("total", equalTo(12))
                .body("data.id", hasItems(7, 8, 9, 10, 11, 12));
        // resp.then().body("data.")
        Response resp2 = given().when().get("/api/users/2");
        resp2.prettyPrint();
        resp2.then().body("data.id", equalTo(2))
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .body("ad.url", equalTo("http://statuscode.org/"));
        Response resp3 = given().when().get("/api/users/23");
        resp3.prettyPrint();
        resp3.then().statusCode(404);
        Response resp4 = given().when().get("/api/unknown");
        resp4.prettyPrint();
        resp4.then().body("page", equalTo(1))
                .body("per_page", equalTo(6))
                .body("total", equalTo(12))
                .body("total_pages", equalTo(2))
                .body("data.id", hasItems(1, 2, 3, 4, 5, 6))
                .body("data.name", hasItems("cerulean", "fuchsia rose", "true red", "aqua sky", "tigerlily", "blue turquoise"))
                .body("ad.company", equalTo("StatusCode Weekly"))
                .body("ad.url", equalTo("http://statuscode.org/"))
                .body("ad.text", equalTo("A weekly newsletter focusing on software development, infrastructure, the server, performance, and the stack end of things."));
        Response resp5 = given().when().get("/api/users?delay=3\n" +
                "\n");
        resp5.prettyPrint();
        resp5.then().body("page", equalTo(1))
                .body("per_page", equalTo(6))
                .body("total", equalTo(12))
                .body("total_pages", equalTo(2))
                .body("data.email", hasItems("george.bluth@reqres.in", "janet.weaver@reqres.in", "emma.wong@reqres.in", "eve.holt@reqres.in", "charles.morris@reqres.in", "tracey.ramos@reqres.in"));

         Response resp6=given().when().get("/api/users?delay=3");
         resp6.prettyPrint();
         resp6.then().statusCode(200);
         //resp6.then().body("")

    }

    @Test
    public void createuser() {

        Response resp1 = given().contentType("application/json").when().body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}").post("/api/users");
        resp1.prettyPrint();
        resp1.then().body("name",is(equalTo("morpheus"))).statusCode(201);
       // resp1.then().assertThat().statusCode(201);
                    //.body("id", equalTo(11));
        Response resp2=given().contentType("application/json").when().body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}").put("/api/users/2");
        resp2.prettyPrint();
        resp2.then().body("name",equalTo("morpheus")).statusCode(200)
                    .body("job",equalTo("zion resident"));
        Response resp3=given().contentType("application/json") .when().body("{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}") .post("/api/register");
        resp3.prettyPrint();
        resp3.then().statusCode(200);
        Response resp4=given().contentType("application/json").when().body("{\n" +
                "    \"email\": \"sydney@fife\"\n" +
                "}").post("/api/register");
        resp4.prettyPrint();
        resp4.then().statusCode(400);
        Response resp5=given().contentType("application/json").when().body("{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}").post("/api/login");
        resp5.prettyPrint();
        resp5.then().statusCode(200);
        Response resp6=given().contentType("application/json").when().body("{\n" +
                "    \"email\": \"peter@klaven\"\n" +
                "}").post("/api/login");
        resp6.then().statusCode(400);

    }
    @Test
    public void deleteuser()
    {
        Response resp3=given().when().delete("/api/users/2");
        resp3.then().statusCode(204);
    }
    
}

   

