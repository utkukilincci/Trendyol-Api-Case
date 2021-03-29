import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpotifyPlaylistApiTest extends BaseTest{

    @Test
    public void playlistJourney(){
        String userId = user.getUserId(200);
        String playlistId = createPlaylist.createPlayList(userId,201,"playlistBody");
        Assert.assertEquals( 0,playlists.getPlaylistSize(playlistId, 200));
        List<String> trackList = new ArrayList<>();
        trackList.add(search.findTrack("Deli",200));
        trackList.add(search.findTrack("Beni Benimle Bırak",200));
        trackList.add(search.findTrack("Dünyanın Sonuna Doğmuşum",200));
        playlists.addTracks(trackList,playlistId,201);
        Assert.assertTrue( playlists.getPlaylistSize(playlistId, 200) == 3);
        playlists.deleteTrack(trackList.get(2),playlistId,200);
        Assert.assertTrue(playlists.getPlaylistSize(playlistId, 200) == 2);
    }
}
