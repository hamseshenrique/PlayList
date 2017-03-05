package com.software.hms.playlist.presenter;

import com.software.hms.playlist.dto.PlayListsDto;
import com.software.hms.playlist.interfaces.GoogleApi;
import com.software.hms.playlist.interfaces.PlayListAction;
import com.software.hms.playlist.interfaces.PlayListPresenter;
import com.software.hms.playlist.util.PlayListService;
import com.software.hms.playlist.util.PlayListServiceImpl;

import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


/**
 * Created by hms on 04/03/17.
 */
public class PlayListPresenterImpl implements PlayListPresenter{

    private PlayListAction playListAction;
    private PlayListService playListService;

    public PlayListPresenterImpl(final PlayListAction playListAction){
        this.playListAction = playListAction;
        setPlayListService(new PlayListServiceImpl());
    }

    @Override
    public void findPlayList() {
        final GoogleApi googleApi = playListService.create();
        final Observable<PlayListsDto> observable = googleApi.playlist("","","");
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(throwable -> {
                    return Observable.empty();
                })
                .subscribe(playListsDto -> {
                    playListAction.atualizar(playListsDto.getListPlayList());
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throw new OnErrorFailedException(throwable);
                    }
                });

    }


    public void setPlayListService(PlayListService playListService) {
        this.playListService = playListService;
    }
}
