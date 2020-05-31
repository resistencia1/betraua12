package com.example.betraua12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.commonsware.cwac.provider.StreamProvider;

import Adaptadores.GaleriaImagenesAdapter;

public class MainActivity extends AppCompatActivity {
    GridView gridViewImagenes;

    MediaPlayer mPlayer,mPlayer2,mPlayer3,mPlayer4,mPlayer5,mPlayer6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridViewImagenes=findViewById(R.id.grid_view_imagenes);
        gridViewImagenes.setAdapter(new GaleriaImagenesAdapter(this));

        mPlayer=MediaPlayer.create(MainActivity.this,R.raw.our);
        mPlayer2=MediaPlayer.create(MainActivity.this,R.raw.over);
        mPlayer3=MediaPlayer.create(MainActivity.this,R.raw.morethan);
        mPlayer4=MediaPlayer.create(MainActivity.this,R.raw.stronger);
        mPlayer5=MediaPlayer.create(MainActivity.this,R.raw.faster);
        mPlayer6=MediaPlayer.create(MainActivity.this,R.raw.workit);

        gridViewImagenes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        mPlayer.start();
                    break;
                    case 1:
                        mPlayer2.start();
                        break;
                    case 2:
                        mPlayer3.start();
                        break;
                    case 3:
                        mPlayer4.start();
                        break;
                    case 4:
                        mPlayer5.start();
                        break;
                    case 5:
                        mPlayer6.start();
                        break;
                }
            }
        });

        gridViewImagenes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:

                        String COMMON_AUTHORITY = "com.yourpackage.AssetProvider";
                        Uri uri = Uri.parse("content://" + COMMON_AUTHORITY)
                                .buildUpon()
                                .appendPath(StreamProvider.getUriPrefix(COMMON_AUTHORITY))
                                .appendPath("our") //the name attribute
                                .appendPath("our.mp3") //the path attribute, + extension
                                .build();

                        Intent share = new Intent(Intent.ACTION_SEND);
                        share.setType("audio/mp3");
                        share.putExtra(Intent.EXTRA_STREAM, uri);
                        startActivity(Intent.createChooser(share, "Share Audio File"));



                        //break;

                }
                return false;
            }
        });

    }



}
