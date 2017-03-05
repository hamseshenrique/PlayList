package com.software.hms.playlist.interfaces;

import com.software.hms.playlist.dto.PlayListsDto;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hms on 05/03/17.
 */

public interface GoogleApi {

    @GET("/youtube/v3/playlists")
    Observable<PlayListsDto> playlist(@Query("part") String part, @Query("channelId") String chanelId,
                                      @Query("key") String key);

}
