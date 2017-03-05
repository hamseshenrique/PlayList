package com.software.hms.playlist.dto;

/**
 * Created by hms on 04/03/17.
 */
public class Item {

    private String id;
    private SnippetDto snippet;

    public Item(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SnippetDto getSnippet() {
        return snippet;
    }

    public void setSnippetDto(SnippetDto snippet) {
        this.snippet = snippet;
    }
}