package controller;

import org.json.JSONObject;
import serviceBase.GeneralApiController;
import serviceBase.QueryParam;
import serviceBase.ReadableResponse;

import java.util.ArrayList;
import java.util.List;

import static base.Keywords.*;

public class PlaylistsController extends GeneralApiController {

    public PlaylistsController() {
        super(BASE_URL);
        getSpec().header(AUTHORIZATION,"Bearer " + token);
    }

    public ReadableResponse postPlayList(String userId, JSONObject body) {
        return postRequest(body,"/users" + userId + "/playlists");
    }

    public ReadableResponse addTrackToList(String trackUri, String playlistId) {
        List<QueryParam> queryParams = new ArrayList<>();
        queryParams.add(new QueryParam("uris", trackUri));

        return postRequest(queryParams, "/" + playlistId+ "/tracks");
    }
}
