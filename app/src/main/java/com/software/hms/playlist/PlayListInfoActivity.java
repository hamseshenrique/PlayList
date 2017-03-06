package com.software.hms.playlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.software.hms.playlist.dto.Item;
import com.software.hms.playlist.interfaces.PlayListAction;
import com.software.hms.playlist.interfaces.PlayListPresenter;
import com.software.hms.playlist.presenter.PlayListPresenterImpl;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlayListInfoActivity extends AppCompatActivity implements PlayListAction {


    private PlayListPresenter playListPresenter;
    private ImageView imageView;
    private TextView title;
    private TextView descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list_info);

        playListPresenter = new PlayListPresenterImpl(this);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){

            final String videoId = (String) bundle.getString("videoId");
            imageView = (ImageView) findViewById(R.id.imgItem);
            title = (TextView) findViewById(R.id.title);
            descricao = (TextView) findViewById(R.id.descricao);
            playListPresenter.infoPlayList(videoId);
        }
    }

    @Override
    public void atualizar(List<Item> items) {
        if(items != null && !items.isEmpty()){
            final Item item = items.get(0);

            Picasso.with(this).load(item.getSnippet().getThumbnails().getHigh().getUrl())
                    .into(imageView);
            title.setText(item.getSnippet().getTitle());
            descricao.setText(item.getSnippet().getDescription());
        }
    }
}
