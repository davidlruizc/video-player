package com.example.videoplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.MediaController;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

public class FullVideo extends Activity {
    private VideoView videoView;
    private int position = 0;
    private MediaController mediaController;
    private Button buttonGoBack;
    private TextView artist;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_video);

        this.videoView = (VideoView) findViewById(R.id.videoView);
        this.buttonGoBack = (Button) findViewById(R.id.button_goBack);
        this.artist = (TextView) findViewById(R.id.titleArtist);

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

        // Get intent data
        Intent i = getIntent();

        int positionItent = i.getExtras().getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);
        // Play Video from raw
        VideoViewUtils.playRawVideo(FullVideo.this, videoView, imageAdapter.videoPath[positionItent]);
        this.artist.setText(imageAdapter.artistNames[positionItent]);

        this.buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
