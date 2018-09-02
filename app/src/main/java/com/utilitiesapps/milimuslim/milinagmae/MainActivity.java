package com.utilitiesapps.milimuslim.milinagmae;

import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class MainActivity extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView;
    int count;
    int activity;
    InterstitialAd mInterstitialAd;
    String[] pathabout = {
            "hqid3w5R_ok", "ogha37XL6KU", "saZU7W48iqk", "G17Rbk_Hdgg"
    };


    String[] pathindia = {
            "sZKO4ozOybM", "smljZYztS7s", "tez_C_CQQY0"
    };


    String[] pathinter = {
            "PTWpryj9Q1g", "ikKmIlrtnJk", "jdltF8DC0Nk"
    };

    static YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInterstitialAd = new InterstitialAd(this);
        BannerAdmob();
        mInterstitialAd.setAdUnitId("ca-app-pub-3444255945927869/1477833247");
        requestNewInterstitial();
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
            }
        });

        activity = Main4Activity.activity;
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);

        if (activity == 1) {
            onInitializedListener = new YouTubePlayer.OnInitializedListener() {

                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                    count = about.count;
                    count--;
                    youTubePlayer.loadVideo(pathabout[count]);

                    youTubePlayer.play();
                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                }
            };
            youTubePlayerView.initialize(DeveloperKey.DEVELOPER_KEY, onInitializedListener);
        } else if (activity == 2) {
            onInitializedListener = new YouTubePlayer.OnInitializedListener() {

                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                    count = pakmedia.count;
                    count--;
                    youTubePlayer.loadVideo(pathindia[count]);

                    youTubePlayer.play();
                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                }
            };
            youTubePlayerView.initialize(DeveloperKey.DEVELOPER_KEY, onInitializedListener);
        } else if (activity == 3) {
            onInitializedListener = new YouTubePlayer.OnInitializedListener() {

                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                    count = international.count;
                    count--;
                    youTubePlayer.loadVideo(pathinter[count]);

                    youTubePlayer.play();
                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                }
            };
            youTubePlayerView.initialize(DeveloperKey.DEVELOPER_KEY, onInitializedListener);
        }


    }


    private void requestNewInterstitial() {
        // TODO Auto-generated method stub
        AdRequest adRequest = new AdRequest.Builder().build();

        mInterstitialAd.loadAd(adRequest);
    }

    private void BannerAdmob() {
        // TODO Auto-generated method stub
        AdView adView = (AdView) findViewById(R.id.adView6);
        AdView adView1 = (AdView) findViewById(R.id.adView7);

        adView.loadAd(new AdRequest.Builder().build());
        adView1.loadAd(new AdRequest.Builder().build());

    }

    @Override
    public void onBackPressed() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
        super.onBackPressed();
    }
}