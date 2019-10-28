package com.kuntaru.mediatest;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static android.R.layout.simple_expandable_list_item_1;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    ArrayAdapter mArrayAdapter;
    ListView listView;
    ArrayList<String> mArrayList;
    //    ArrayList<Integer> playlist;
    private int length;
    private int position = 0;
//


    private ImageButton btnPlay, btnNext, btnPrevieous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btn_play);
        listView = findViewById(R.id.list);
        mArrayList = new ArrayList<String>();

        final Field[] fields = R.raw.class.getFields();
        for (int j = 0; j < fields.length; j++) {
            final int finalI = j;
            btnPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (player == null) {
                        int resId = getResources().getIdentifier(mArrayList.get(finalI), "raw", getPackageName());
                        player = MediaPlayer.create(MainActivity.this, resId);
                        player.start();

                        btnPlay.setImageResource(R.drawable.ic_pause_black_24dp);
                    }
                    else {
                        btnPlay.setImageResource(R.drawable.ic_play_arrow_black_24dp);

                    length = player.getCurrentPosition();
                    if (player != null && player.isPlaying()) {
                        player.start();
                        player.seekTo(length);
                        player.pause();

                    } else {
                        assert player != null;
                        player.start();
                        btnPlay.setImageResource(R.drawable.ic_pause_black_24dp);
                    }
                    }
                }

            });

            mArrayList.add(fields[j].getName());



        mArrayAdapter = new ArrayAdapter(this, simple_expandable_list_item_1, mArrayList);
        listView.setAdapter(mArrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (player != null) {
                    player.release();
                }

                int resId = getResources().getIdentifier(mArrayList.get(i), "raw", getPackageName());
                player = MediaPlayer.create(MainActivity.this, resId);
                player.start();
            }

        });
        btnNext = findViewById(R.id.next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player != null) {
                    player.release();
                }

                int resId = getResources().getIdentifier(mArrayList.get(position++), "raw", getPackageName());
                player = MediaPlayer.create(MainActivity.this, resId);
                player.start();
                btnPlay.setImageResource(R.drawable.ic_pause_black_24dp);

                if (position == mArrayList.size() - 1) {
                    position = 0;
                }
            }

        });

        btnPrevieous = findViewById(R.id.previous);

        btnPrevieous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position > 0) {
                    if (player != null) {
                        player.reset();
                    }
                    position = position - 1;
                    int resId = getResources().getIdentifier(mArrayList.get(position), "raw", getPackageName());
                    player = MediaPlayer.create(MainActivity.this, resId);
                    player.start();
                    btnPlay.setImageResource(R.drawable.ic_pause_black_24dp);

                } else {
//                    position = mArrayList.size() - 1;
                }

            }


        });

//
//        final ImageButton btnPlayer = findViewById(R.id.btn_play);
//        playlist = new ArrayList<>();
//        btnPlayer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (player == null) {
//                    playlist.add(R.raw.song);
//                    playlist.add(R.raw.baqarah_12);
//                    playlist.add(R.raw.baqarah_13);
//                    playlist.add(R.raw.baqarah_14);
//                    playlist.add(R.raw.baqarah_15);
//                    playlist.add(R.raw.baqarah_16);
//                    playlist.add(R.raw.baqarah_17);
//                    player = MediaPlayer.create(MainActivity.this, playlist.get(0));
//                    player.start();
//
//
//                    btnPlayer.setImageResource(R.drawable.ic_pause_black_24dp);
//
//                } else {
//                    btnPlayer.setImageResource(R.drawable.ic_play_arrow_black_24dp);
//
//                    length = player.getCurrentPosition();
//                    if (player != null && player.isPlaying()) {
//                        player.start();
//                        player.seekTo(length);
//                        player.pause();
//
//                    } else {
//                        player.start();
//                        btnPlayer.setImageResource(R.drawable.ic_pause_black_24dp);
//                    }
//
//
//                }
//            }
//
//
//        });
//        final ImageButton btnNext = findViewById(R.id.next);
//
//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (player == null) {
//                    playlist.add(R.raw.song);
//                    playlist.add(R.raw.baqarah_12);
//                    playlist.add(R.raw.baqarah_13);
//                    playlist.add(R.raw.baqarah_14);
//                    playlist.add(R.raw.baqarah_15);
//                    playlist.add(R.raw.baqarah_16);
//                    playlist.add(R.raw.baqarah_17);
//                    player = MediaPlayer.create(MainActivity.this, playlist.get(0));
//                    player.start();
//
//                }
//                btnPlayer.setImageResource(R.drawable.ic_pause_black_24dp);
//                player.reset();
//                if (player.isPlaying()) {
//                    btnPlayer.setImageResource(R.drawable.ic_pause_black_24dp);
//
//                }
//                player = MediaPlayer.create(MainActivity.this, playlist.get(++i));
//                player.start();
//                if (i == playlist.size() - 1) {
//                    i = -1;
//                }
//                btnPlayer.setImageResource(R.drawable.ic_pause_black_24dp);
//
//
//            }
//
//
//        });
//
//
//        ImageButton btnPrev = findViewById(R.id.previous);
//        btnPrev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (i > 0) {
//                    player.reset();
//                    player = MediaPlayer.create(MainActivity.this, playlist.get(--i));
//                    player.start();
//                    btnPlayer.setImageResource(R.drawable.ic_pause_black_24dp);
//                }
//                else {
//
//                        Toast.makeText(MainActivity.this, "end of the list", Toast.LENGTH_SHORT).show();
//                    }
//
//
//
//            }
//        });
    }


}

}