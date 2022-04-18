package controller.controllerHelper;

import controller.PlaylistsController;
import controller.controllerRequestData.PlaylistsControllerData;
import models.PlayList;
import org.json.JSONObject;
import serviceBase.ReadableResponse;

import static matchers.BaseMatchers.shouldStatusCodeSameAs;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlaylistsControllerHelper {
    PlaylistsController playlistsController = new PlaylistsController();
    UserProfileControllerHelper userProfileControllerHelper = new UserProfileControllerHelper();
    PlaylistsControllerData playlistsControllerData = new PlaylistsControllerData();


    public String createPublicPlayList(String name) {
        String userId = userProfileControllerHelper.getUserId();
        PlayList playList = PlayList.createPlayList(name, "Description", true);

        JSONObject requestBody = playlistsControllerData.prepareCreatePlaylistData(playList);
        ReadableResponse response = playlistsController.postPlayList(userId, requestBody);

        assertThat("When a user tries to create a playlist, status code should be '201' ", response, shouldStatusCodeSameAs(SC_CREATED));

        return response.getBodyMessage("id");
    }
}
