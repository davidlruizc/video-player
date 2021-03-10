package com.example.videoplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.VideoView;
import android.widget.MediaController;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

public class FullVideo extends Activity {
    private VideoView videoView;
    private int position = 0;
    private MediaController mediaController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_video);

        this.videoView = (VideoView) findViewById(R.id.videoView);

        // Set the media controller buttons
        if (this.mediaController == null) {
            this.mediaController = new MediaController(FullVideo.this);

            // Set the videoView that acts as the anchor for the MediaController.
            this.mediaController.setAnchorView(videoView);

            // Set MediaController for VideoView
            this.videoView.setMediaController(mediaController);
        }

        // When the video file ready for playback.
        this.videoView.setOnPreparedListener(new OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {

                videoView.seekTo(position);
                if (position == 0) {
                    videoView.start();
                }

                // When video Screen change size.
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

                        // Re-Set the videoView that acts as the anchor for the MediaController
                        mediaController.setAnchorView(videoView);
                    }
                });
            }
        });

        // Play Vieo from URL
        String videoURL = VideoViewUtils.URL_VIDEO_SAMPLE;
        VideoViewUtils.playURLVideo(FullVideo.this, videoView, videoURL);

        // Get intent data
        //Intent i = getIntent();
        // Get Selected Image Id
        //int position = i.getExtras().getInt("id");
        //ImageAdapter imageAdapter = new ImageAdapter(this);
        //ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
        //imageView.setImageResource(imageAdapter.thumbImages[position]);
    }
}
