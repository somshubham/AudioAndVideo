package com.som.android.audioandvideo;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    ProgressDialog pDialog;
    VideoView videoview;
    String VideoURL ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //VideoURL="android.resource://" + getPackageName()+ "/"+ R.raw.ecd;
       VideoURL="http://i.imgur.com/l2GfCGB.mp4";

        //http://i.imgur.com/l2GfCGB.gifv
       // VideoURL="http://www.androidbegin.com/tutorial/AndroidCommercial.3gp";
        //https://i.imgur.com/ecdSJ0d.gifv



        videoview = (VideoView) findViewById(R.id.VideoView);


        pDialog = new ProgressDialog(MainActivity.this);

        pDialog.setTitle("Streaming please hold on !");

        pDialog.setMessage("Buffering...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);

        pDialog.show();

        try {
            // Start the MediaController
            MediaController mediacontroller = new MediaController(
                    MainActivity.this);
            mediacontroller.setAnchorView(videoview);
            // Get the URL from String VideoURL
            Uri video = Uri.parse(VideoURL);
            videoview.setMediaController(mediacontroller);
            videoview.setVideoURI(video);

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        videoview.requestFocus();
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            // Close the progress bar and play the video
            public void onPrepared(MediaPlayer mp) {
                pDialog.dismiss();
                videoview.start();
            }
        });








    }




}
