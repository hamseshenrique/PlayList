package com.software.hms.playlist.dto;

/**
 * Created by hms on 04/03/17.
 */
public class SnippetDto {

    private String channelId;
    private String title;
    private String description;
    private ThumbnailsDto thumbnailsDto;

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

    public ThumbnailsDto getThumbnailsDto() {
        return thumbnailsDto;
    }

    public void setThumbnailsDto(ThumbnailsDto thumbnailsDto) {
        this.thumbnailsDto = thumbnailsDto;
    }
}
