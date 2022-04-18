package controller.controllerHelper;

import controller.SearchController;
import controller.controllerRequestData.SearchControllerData;
import serviceBase.QueryParam;
import serviceBase.ReadableResponse;

import java.util.List;

import static matchers.BaseMatchers.shouldStatusCodeSameAs;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchControllerHelper {
    SearchController searchController = new SearchController();
    SearchControllerData searchControllerData = new SearchControllerData();

    public String getFirstTrackUriFromSearchResult(String trackName) {
        List<QueryParam> queryParams = searchControllerData.prepareSearchData(trackName, "track", "1");
        ReadableResponse response = searchController.getSearchResult(queryParams);

        assertThat("When a user tries to search something, ", response, shouldStatusCodeSameAs(SC_OK));

        return response.getBodyMessage("tracks.items.uri");
    }
}
