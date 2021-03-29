package services;

import io.restassured.response.Response;
import specs.RequestSpec;
import specs.ResponseSpec;

import static io.restassured.RestAssured.*;

public class User extends RequestSpec {

    public User() {
        super("/v1/me");
    }

    public String getUserId(int statusCode){

        Response response =
        given()
                .spec(super.getRequestSpecification())
                .get()
        .then()
                .spec(ResponseSpec.checkStatusCode(statusCode))
                .extract()
                .response();

        String userId  = response.jsonPath().getString("id");
        System.out.println("Oluşturulan user ID : " +userId);
        return userId;

    }

}
