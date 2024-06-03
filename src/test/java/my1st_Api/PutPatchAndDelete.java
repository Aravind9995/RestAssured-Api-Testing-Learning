package my1st_Api;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class PutPatchAndDelete {
    @Test
    public  void putExample(){
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
            put("/users/2").
        then().
            statusCode(200).
            log().all();
    }

    @Test
    public  void patchExample(){
        JSONObject requests = new JSONObject();
        requests.put("Name", "Aravind");
        requests.put("job", "jobless");

        System.out.println(requests.toJSONString());

        baseURI = "https://reqres.in";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(requests.toJSONString()).
                when().
                patch("/api/users/2").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public  void deleteExample(){

        baseURI = "https://reqres.in";

        when().
           delete("/api/users/2").
        then().
           statusCode(204).
           log().all();
    }
}
