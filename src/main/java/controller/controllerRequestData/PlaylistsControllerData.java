package controller.controllerRequestData;

import models.PlayList;
import org.json.JSONObject;

public class PlaylistsControllerData {
    public JSONObject prepareCreatePlaylistData(PlayList playList) {
        return new JSONObject()
                .put("name", playList.getName())
                .put("description", playList.getDescription())
                .put("public", playList.getIsPublic());
    }
}
