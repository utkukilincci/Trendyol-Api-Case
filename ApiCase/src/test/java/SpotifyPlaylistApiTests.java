import org.testng.Assert;
import org.testng.annotations.Test;

import static helpers.Data.*;


public class SpotifyPlaylistApiTests extends BaseTest{

    @Test(priority=1)
    public void createPlaylistTest(){
        userId = user.getUserId(200);
        playlistId = createPlaylist.createPlayList(userId,201,"playlistBody");
        Assert.assertEquals( 0,playlists.getPlaylistSize(playlistId, 200));
    }

    @Test(priority=2)
    public void addTrackToListTest(){
        trackList.add(search.findTrack("Deli",200));
        trackList.add(search.findTrack("Beni Benimle Bırak",200));
        trackList.add(search.findTrack("Dünyanın Sonuna Doğmuşum",200));
        playlists.addTracks(trackList,playlistId,201);
        Assert.assertTrue( playlists.getPlaylistSize(playlistId, 200) == 3);
    }

    @Test(priority=3)
    public void deleteTrackFromListTest(){
        playlists.deleteTrack(trackList.get(2),playlistId,200);
        Assert.assertTrue(playlists.getPlaylistSize(playlistId, 200) == 2);
    }

}
