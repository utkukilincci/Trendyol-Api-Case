package controller.controllerRequestData;

import models.PlayList;
import org.json.JSONObject;
import serviceBase.QueryParam;

import java.util.ArrayList;
import java.util.List;

public class SearchControllerData {
    public List<QueryParam> prepareSearchData(String searchKey, String type, String limit) {
        List<QueryParam> queryParams = new ArrayList<>();
        queryParams.add(new QueryParam("q", searchKey));
        queryParams.add(new QueryParam("type", type));
        queryParams.add(new QueryParam("limit",limit));

        return queryParams;
    }
}
