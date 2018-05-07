package com.example.kevin.streaming;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Musica extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String API_KEY = "889819198946-d4hnhl4nv8uqtdjs80j79a0tf3fr9nns.apps.googleusercontent.com";
    public static final String VIDEO_ID = "oUExWNtesDQ";

    YouTubePlayer player;
    Button fullScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);

        fullScreen = (Button)findViewById(R.id.button3);

        fullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.setFullscreen(true);
            }
        });

        /** Initializing YouTube Player View **/
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(API_KEY, this);
        /////////////////////////////////////////////////
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "No se puede iniciar!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        this.player = player;

        /** Start buffering **/
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }
    }
}
