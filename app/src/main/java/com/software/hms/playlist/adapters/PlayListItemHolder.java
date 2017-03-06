package com.software.hms.playlist.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.software.hms.playlist.PlayListInfoActivity;
import com.software.hms.playlist.R;
import com.software.hms.playlist.dto.Item;

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

    public void onClickItem(final Item item){
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(view.getContext(), PlayListInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("videoId",item.getSnippet().getResourceId().getVideoId());
                intent.putExtras(bundle);

                view.getContext().startActivity(intent);
            }
        });
    }



    public ImageView getImageView() {
        return imageView;
    }
    public TextView getTextView() {
        return textView;
    }

}
