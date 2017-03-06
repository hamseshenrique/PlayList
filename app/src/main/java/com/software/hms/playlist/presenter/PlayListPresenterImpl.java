package com.software.hms.playlist.presenter;

import com.software.hms.playlist.dto.PlayListDto;
import com.software.hms.playlist.enums.GoogleApiEnum;
import com.software.hms.playlist.interfaces.GoogleApi;
import com.software.hms.playlist.interfaces.PlayListAction;
import com.software.hms.playlist.interfaces.PlayListPresenter;
import com.software.hms.playlist.server.PlayListService;
import com.software.hms.playlist.server.PlayListServiceImpl;

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
        final Observable<PlayListDto> observable = googleApi.playlist(GoogleApiEnum.PART.getValue(),
                GoogleApiEnum.CHANELID.getValue(),GoogleApiEnum.KEY.getValue());
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(throwable -> {
                    return Observable.empty();
                })
                .subscribe(playListsDto -> {
                    playListAction.atualizar(playListsDto.getItems());
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throw new OnErrorFailedException(throwable);
                    }
                });
    }

    @Override
    public void findByIdPlayList(String playListId) {
        final GoogleApi googleApi = playListService.create();
        final Observable<PlayListDto> observable = googleApi.playlistItems(GoogleApiEnum.PART.getValue(),
                playListId,GoogleApiEnum.KEY.getValue());
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(throwable -> {
                    return Observable.empty();
                })
                .subscribe(playListsDto -> {
                    playListAction.atualizar(playListsDto.getItems());
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throw new OnErrorFailedException(throwable);
                    }
                });
    }

    @Override
    public void infoPlayList(String id) {
        final GoogleApi googleApi = playListService.create();
        final Observable<PlayListDto> observable = googleApi.videos(
                id,
                GoogleApiEnum.PART.getValue(),
                GoogleApiEnum.KEY.getValue());
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(throwable -> {
                    return Observable.empty();
                })
                .subscribe(playListsDto -> {
                    playListAction.atualizar(playListsDto.getItems());
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
