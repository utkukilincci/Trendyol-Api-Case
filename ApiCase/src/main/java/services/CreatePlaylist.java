package services;

import io.restassured.response.Response;
import specs.RequestSpec;
import specs.ResponseSpec;

import static io.restassured.RestAssured.given;

public class CreatePlaylist extends RequestSpec {

    private String playlistBody = "{\n" +
            "  \"name\": \"Utku's Playlist\",\n" +
            "  \"description\": \"Utku Kilincci\",\n" +
            "  \"public\": true\n" +
            "}";

    public CreatePlaylist() {
        super("/v1/users");
    }

    public String createPlayList(String userId, int statusCode){
        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .body(playlistBody)
                        .post("/{userId}/playlists",userId)
                .then()
                        .spec(ResponseSpec.checkStatusCode(statusCode))
                        .extract()
                        .response();



        return response.jsonPath().getString("id");
    }

}
