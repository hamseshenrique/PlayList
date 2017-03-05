package com.software.hms.playlist.dto;

import java.util.List;

/**
 * Created by hms on 04/03/17.
 */

public class PlayListsDto {

    private List<PlayListDto> listPlayList;

    public PlayListsDto(){}


    public List<PlayListDto> getListPlayList() {
        return listPlayList;
    }

    public void setListPlayList(List<PlayListDto> listPlayList) {
        this.listPlayList = listPlayList;
    }
}
