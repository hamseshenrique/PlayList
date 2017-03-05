package com.software.hms.playlist.dto;

import java.util.List;

/**
 * Created by hms on 04/03/17.
 */
public class PlayListDto {

    private String nextPageToken;
    private List<Item> items;

    public PlayListDto(){}


    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
