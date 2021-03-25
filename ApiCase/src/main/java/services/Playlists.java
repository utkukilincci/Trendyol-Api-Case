package services;

import io.restassured.response.Response;
import org.json.JSONObject;
import specs.RequestSpec;
import specs.ResponseSpec;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Playlists extends RequestSpec {

    public Playlists() {
        super("/v1/playlists");
    }


    public boolean isPlaylistNull(String playlistId,int statusCode){
        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .get("/{playlist_id}/tracks",playlistId)
                .then()
                        .spec(ResponseSpec.checkStatusCode(statusCode))
                        .extract()
                        .response();
        List<Object> trackList =  response.jsonPath().getList("items");
        System.out.println(trackList.size());
        if(trackList.size() == 0) return true;
        return false;
    }

    public void addTracks(List<String> tracks, String playlistId, int statusCode){

        for(String track : tracks){

            given()
                    .spec(super.getRequestSpecification())
                    .queryParam("uris",track)
                    .post("/{playlist_id}/tracks",playlistId)
                    .then()
                    .spec(ResponseSpec.checkStatusCode(statusCode));
        }

    }

    public void deleteTrack(String trackUri, String playlistId, int statusCode){
        String deleteBody ="{\n" +
                "  \"tracks\": [\n" +
                "    {\n" +
                "      \"uri\": " +
                trackUri +
                ",\n" +
                "      \"positions\": [\n" +
                "        2\n" +
                "      ]\n" +
                "    }]\n" +
                "}";

        given()
                .spec(super.getRequestSpecification())
                .body(deleteBody)
                .delete("/{playlist_id}/tracks",playlistId)
                .then()
                .spec(ResponseSpec.checkStatusCode(statusCode));
    }
}
