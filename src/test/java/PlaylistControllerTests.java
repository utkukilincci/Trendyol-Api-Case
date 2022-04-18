import base.BaseTest;
import controller.PlaylistsController;
import controller.controllerHelper.PlaylistsControllerHelper;
import controller.controllerHelper.SearchControllerHelper;
import controller.controllerHelper.UserProfileControllerHelper;
import controller.controllerRequestData.PlaylistsControllerData;
import models.PlayList;
import org.json.JSONObject;
import org.testng.annotations.Test;
import serviceBase.ReadableResponse;

import static matchers.BaseMatchers.shouldStatusCodeSameAs;
import static matchers.UsersEndpointMatchers.shouldCreatedPlaylist;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlaylistControllerTests extends BaseTest {
    PlaylistsController playlistsController = new PlaylistsController();
    PlaylistsControllerData playlistsControllerData = new PlaylistsControllerData();
    PlaylistsControllerHelper playlistsControllerHelper = new PlaylistsControllerHelper();

    SearchControllerHelper searchControllerHelper = new SearchControllerHelper();

    UserProfileControllerHelper userProfileControllerHelper = new UserProfileControllerHelper();

    @Test
    public void shouldCreatePlaylistTest(){
        String userId = userProfileControllerHelper.getUserId();
        PlayList playList = PlayList.createPlayList("Utku", "Description", true);

        JSONObject requestBody = playlistsControllerData.prepareCreatePlaylistData(playList);
        ReadableResponse response = playlistsController.postPlayList(userId, requestBody);

        assertThat("When a user tries to create a playlist, status code should be '201' ", response, shouldStatusCodeSameAs(SC_CREATED));
        assertThat("When a user tries to create a playlist, should be able to see created playlist ", response, shouldCreatedPlaylist(playList));
    }

    @Test
    public void shouldAddItemToPlaylistTest(){
        String playListId = playlistsControllerHelper.createPublicPlayList("Utku");
        String trackUri = searchControllerHelper.getFirstTrackUriFromSearchResult("beni benimle bırak");

        ReadableResponse response = playlistsController.addTrackToList(trackUri, playListId);

        assertThat("When a user tries to add a track to playlist, status code should be '201' ", response, shouldStatusCodeSameAs(SC_CREATED));
    }
}
