package models;

import lombok.Data;

@Data
public class PlayList {
    private String name;
    private String description;
    private Boolean isPublic;

    public static PlayList createPlayList(String name, String desc, Boolean isPublic) {
        PlayList playList = new PlayList();

        playList.setName(name);
        playList.setDescription(desc);
        playList.setIsPublic(isPublic);

        return playList;
    }
}
