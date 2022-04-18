package controller;

import serviceBase.GeneralApiController;
import serviceBase.QueryParam;
import serviceBase.ReadableResponse;

import java.util.List;

import static base.Keywords.*;

public class SearchController extends GeneralApiController {
    public SearchController() {
        super(BASE_URL);
        getSpec().header(AUTHORIZATION,"Bearer " + token);
    }

    public ReadableResponse getSearchResult(List<QueryParam> queryParams) {
        return getRequest(queryParams,"/search");
    }


      /*  public Search() {
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
*/
}
