package com.moderncreation.mediasliderlibrary.Youtube;


import android.support.v4.app.Fragment;
import android.util.Log;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class YouTubePlayerSupportCustomFragment extends YouTubePlayerSupportFragment {
    private String url = null;
    private String key = null;
    private YouTubePlayer player;
    private YouTubePlayerSupportFragment realYouTubeFragment;
    private boolean isLoading = false;

    public boolean isLoading() {
        return isLoading;
    }


    public void setURL(String url) {
        url = url;
    }

    public YouTubePlayerSupportCustomFragment(){

        realYouTubeFragment = newInstance();
    }

    public void setYoutubePlayer(YouTubePlayer player) {
        this.player = player;

    }

    public YouTubePlayerSupportFragment getRealYoutubeFragment(String key) {
        this.key = key;
        return realYouTubeFragment;
    }

    public String getVideoId() {
        return url;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    public void onRelease() {
        if(null != url) {
            player.release();
            isLoading = false;
            Log.e(getClass().getSimpleName(), url);
        }

    }

    public void onLoad() {

        initialize(key, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                setYoutubePlayer(youTubePlayer);

                youTubePlayer.cueVideo(url);
                isLoading = true;
                Log.e( "onLoad", ""+ url);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.e( "Fail", ""+ url);
            }
        });

    }
}
