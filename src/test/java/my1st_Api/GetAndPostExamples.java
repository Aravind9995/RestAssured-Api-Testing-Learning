package my1st_Api;

import io.restassured.http.ContentType;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAndPostExamples {
   @Test
    public void tesGet(){
       baseURI = "https://reqres.in/api";
       given().
            get("/users?page=2").then().
            body("data[2].first_name", equalTo("Tobias")).
            body("data.first_name", hasItems("Byron","George"));

    }

    @Test
    public  void postExample(){
//       Map<String,Object> map = new HashMap<String, Object>();
//       map.put("Name", "Aravind");
//       map.put("job", "jobless");
//
//        System.out.println(map);

        JSONObject requests = new JSONObject();
        requests.put("Name", "Aravind");
        requests.put("job", "jobless");

        System.out.println(requests.toJSONString());

        baseURI = "https://reqres.in/api";

        given().
            header("Content-Type", "application/json").
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body(requests.toJSONString()).
        when().
            post("/users").
        then().
            statusCode(201).
            log().all();
    }
}
