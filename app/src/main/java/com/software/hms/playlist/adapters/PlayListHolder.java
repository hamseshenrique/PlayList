package com.software.hms.playlist.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.software.hms.playlist.R;

/**
 * Created by hms on 05/03/17.
 */

public class PlayListHolder extends RecyclerView.ViewHolder{

    private ImageView imageView;
    private TextView channelTitle;
    private TextView title;

    public PlayListHolder(View itemView) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.img);
        channelTitle = (TextView) itemView.findViewById(R.id.channelTitle);
        title = (TextView) itemView.findViewById(R.id.title);
    }


    public ImageView getImageView() {
        return imageView;
    }

    public TextView getChannelTitle() {
        return channelTitle;
    }

    public TextView getTitle() {
        return title;
    }
}
