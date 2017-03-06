package com.software.hms.playlist.dto;

import java.io.Serializable;

/**
 * Created by hms on 04/03/17.
 */
public class SnippetDto implements Serializable{

    private String channelId;
    private String title;
    private String description;
    private ThumbnailsDto thumbnails;
    private String channelTitle;
    private LocalizedDto localizedDto;

    public SnippetDto(){}

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ThumbnailsDto getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(ThumbnailsDto thumbnails) {
        this.thumbnails = thumbnails;
    }


    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public LocalizedDto getLocalizedDto() {
        return localizedDto;
    }

    public void setLocalizedDto(LocalizedDto localizedDto) {
        this.localizedDto = localizedDto;
    }
}
