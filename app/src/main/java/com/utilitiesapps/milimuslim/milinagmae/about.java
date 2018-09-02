package com.utilitiesapps.milimuslim.milinagmae;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;

public class about extends AppCompatActivity implements View.OnClickListener {
    ImageView btn1, btn2, btn3, btn4;
    static int count = 0;
    Intent i;
    InterstitialAd mInterstitialAd;

    private static String LOG_TAG = "EXAMPLE";
    VideoController mVideoController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mInterstitialAd = new InterstitialAd(this);
        BannerAdmob();
        nativeBanner();
        mInterstitialAd.setAdUnitId("ca-app-pub-3444255945927869/1477833247");
        requestNewInterstitial();
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
            }
        });
        i = new Intent(about.this, MainActivity.class);

        btn1 = (ImageView) findViewById(R.id.button1);
        btn2 = (ImageView) findViewById(R.id.button2);
        btn3 = (ImageView) findViewById(R.id.button3);
        btn4 = (ImageView) findViewById(R.id.button4);



        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

    }
    public static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
    private void requestNewInterstitial() {
        // TODO Auto-generated method stub
        AdRequest adRequest = new AdRequest.Builder().build();

        mInterstitialAd.loadAd(adRequest);
    }

    @Override
    public void onBackPressed() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
        super.onBackPressed();
    }

    private void BannerAdmob() {
        // TODO Auto-generated method stub
        AdView adView = (AdView) findViewById(R.id.adView);
        adView.loadAd(new AdRequest.Builder().build());

    }
    public void nativeBanner() {
        NativeExpressAdView mAdView = (NativeExpressAdView) findViewById(R.id.adViewnative1);
        nativAdview(mAdView);

    }

    public void nativAdview(NativeExpressAdView mAdView) {

        mAdView.setVideoOptions(new VideoOptions.Builder()
                .setStartMuted(true)
                .build());

        mVideoController = mAdView.getVideoController();
        mVideoController.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
            @Override
            public void onVideoEnd() {
                Log.d(LOG_TAG, "Video playback is finished.");
                super.onVideoEnd();
            }
        });

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                if (mVideoController.hasVideoContent()) {
                    Log.d(LOG_TAG, "Received an ad that contains a video asset.");
                } else {
                    Log.d(LOG_TAG, "Received an ad that does not contain a video asset.");
                }
            }
        });

        mAdView.loadAd(new AdRequest.Builder().build());

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                count = 1;
                startActivity(i);
                break;
            case R.id.button2:
                count = 2;
                startActivity(i);
                break;
            case R.id.button3:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                count = 3;
                startActivity(i);
                break;
            case R.id.button4:
                count = 4;
                startActivity(i);
                break;
        }

    }
}
