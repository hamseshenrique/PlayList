package com.software.hms.playlist.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.software.hms.playlist.R;

/**
 * Created by hms on 05/03/17.
 */

public class PlayListItemHolder extends RecyclerView.ViewHolder{

    private ImageView imageView;
    private TextView textView;

    public PlayListItemHolder(View itemView) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.img);
        textView = (TextView) itemView.findViewById(R.id.channelTitle);
    }


    public ImageView getImageView() {
        return imageView;
    }
    public TextView getTextView() {
        return textView;
    }

}
