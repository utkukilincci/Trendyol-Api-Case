import org.junit.Assert;
import org.junit.Test;
import services.CreatePlaylist;
import services.Playlists;
import services.Search;
import services.User;

import java.util.ArrayList;
import java.util.List;

public class SpotifyPlaylistApiTest {

    @Test
    public void playlistJourney(){
        User user = new User();
        String userId = user.getUserId(200);
        CreatePlaylist createPlaylist = new CreatePlaylist();
        String playlistId = createPlaylist.createPlayList(userId,201);
        System.out.println(playlistId);
        Playlists playlists = new Playlists();
        Assert.assertTrue(playlists.isPlaylistNull(playlistId, 200));
        Search search = new Search();
        List<String> trackList = new ArrayList<>();
        trackList.add(search.findTrack("Deli",200));
        trackList.add(search.findTrack("Beni Benimle Bırak",200));
        trackList.add(search.findTrack("Dünyanın Sonuna Doğmuşum",200));
        playlists.addTracks(trackList,playlistId,201);
        Assert.assertFalse(playlists.isPlaylistNull(playlistId, 200));
        playlists.deleteTrack(trackList.get(2),playlistId,200);
        Assert.assertFalse(playlists.isPlaylistNull(playlistId, 200));
    }
}
