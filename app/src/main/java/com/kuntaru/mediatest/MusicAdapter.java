package com.kuntaru.mediatest;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter  {


    public MusicAdapter(Activity context, ArrayList<Music> musics) {

        super(context, 0, musics);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false);
        }

        Music currentMusic = (Music) getItem(position);
        TextView musicTextView = (TextView) listItemView.findViewById(R.id.music_text_view);
        musicTextView.setText(currentMusic.getAya());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentMusic.getSura());
        return listItemView;
    }
}


