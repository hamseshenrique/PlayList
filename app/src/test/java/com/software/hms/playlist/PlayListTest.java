package com.software.hms.playlist;

import com.software.hms.playlist.dto.PlayListsDto;
import com.software.hms.playlist.interfaces.GoogleApi;
import com.software.hms.playlist.presenter.PlayListPresenterImpl;
import com.software.hms.playlist.util.PlayListService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import rx.Observable;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.functions.Func1;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class PlayListTest {

    @Mock
    private PlayListActivity playListActivity;
    @Mock
    private PlayListService  playListService;
    @Mock
    private GoogleApi googleApi;
    private PlayListPresenterImpl playListPresenter;
    private static final String SERVER = "http://www.googleapis.com";

    @Before
    public void setUp() throws Exception {
        RxJavaHooks.setOnIOScheduler(new Func1<Scheduler, Scheduler>() {
            @Override
            public Scheduler call(Scheduler scheduler) {
                return Schedulers.immediate();
            }
        });

        RxJavaHooks.setOnComputationScheduler(new Func1<Scheduler, Scheduler>() {
            @Override
            public Scheduler call(Scheduler scheduler) {
                return Schedulers.immediate();
            }
        });

        RxJavaHooks.setOnNewThreadScheduler(new Func1<Scheduler, Scheduler>() {
            @Override
            public Scheduler call(Scheduler scheduler) {
                return Schedulers.immediate();
            }
        });

        // Override RxAndroid schedulers
        final RxAndroidPlugins rxAndroidPlugins = RxAndroidPlugins.getInstance();
        rxAndroidPlugins.registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });

        playListPresenter = new PlayListPresenterImpl(playListActivity);
        playListPresenter.setPlayListService(playListService);
    }

    @After
    public void tearDown() throws Exception {
        RxJavaHooks.reset();
        RxAndroidPlugins.getInstance().reset();
    }

    @Test
    public void findPlayList() throws Exception {
        when(playListService.create()).thenReturn(googleApi);
        when(googleApi.playlist("","","")).thenReturn(Observable.just(new PlayListsDto()));
        playListPresenter.findPlayList();

        verify(playListActivity,times(1)).atualizar(anyString());

    }
}