package com.software.hms.playlist.interfaces;

import com.software.hms.playlist.dto.PlayListDto;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hms on 05/03/17.
 */
public interface GoogleApi {

    @GET("/youtube/v3/playlists")
    Observable<PlayListDto> playlist(@Query("part") String part, @Query("channelId") String chanelId,
                                     @Query("key") String key);

    @GET("/youtube/v3/playlistItems")
    Observable<PlayListDto> playlistItems(@Query("part") String part, @Query("playlistId") String chanelId,
                                          @Query("key") String key);
}