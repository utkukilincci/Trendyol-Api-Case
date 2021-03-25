package services;

import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import specs.RequestSpec;
import specs.ResponseSpec;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Search extends RequestSpec {

    public Search() {
        super("/v1/search");
    }


    public String findTrack(String trackName ,int statusCode){

        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .queryParam("q",trackName)
                        .queryParam("type","track")
                        .queryParam("limit","1")
                        .get()
                        .then()
                        .spec(ResponseSpec.checkStatusCode(statusCode))
                        .extract()
                        .response();


        List<String> a  = ((RestAssuredResponseImpl) response).response().path("tracks.items.uri");
         return a.get(0);
    }

}
