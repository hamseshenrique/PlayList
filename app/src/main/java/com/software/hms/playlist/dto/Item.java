package com.software.hms.playlist.dto;

/**
 * Created by hms on 04/03/17.
 */
public class Item {

    private String id;
    private SnippetDto snippetDto;
    private String channelTitle;
    private Localized localized;

    public Item(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SnippetDto getSnippetDto() {
        return snippetDto;
    }

    public void setSnippetDto(SnippetDto snippetDto) {
        this.snippetDto = snippetDto;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public Localized getLocalized() {
        return localized;
    }

    public void setLocalized(Localized localized) {
        this.localized = localized;
    }
}