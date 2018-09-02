package com.utilitiesapps.milimuslim.milinagmae;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.StartAppSDK;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {
    ImageView btn1,btn2,btn3;
    private StartAppAd startapp = new StartAppAd(this);
    Intent i,j,h;
    public static int activity;
    InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartAppSDK.init(this,"168784222", "207039976", false);
        setContentView(R.layout.activity_main4);
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
        i=new Intent(Main4Activity.this,about.class);
        j=new Intent(Main4Activity.this,pakmedia.class);
        h=new Intent(Main4Activity.this,international.class);

        btn1= (ImageView) findViewById(R.id.about);
        btn2= (ImageView) findViewById(R.id.pak);
        btn3= (ImageView) findViewById(R.id.inter);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

    }
    private void requestNewInterstitial() {
        // TODO Auto-generated method stub
        AdRequest adRequest = new AdRequest.Builder().build();

        mInterstitialAd.loadAd(adRequest);
    }



    private void BannerAdmob() {
        // TODO Auto-generated method stub
        AdView adView = (AdView) findViewById(R.id.adView11);
        adView.loadAd(new AdRequest.Builder().build());

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.about:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                activity=1;
                startActivity(i);
                break;
            case R.id.pak:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                activity=2;
                startActivity(j);
                break;
            case R.id.inter:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                activity=3;
                startActivity(h);
                break;

        }
    }
    public void onshowAd()
    {
        startapp.showAd();
        startapp.loadAd();
    }
    @Override
    public void onBackPressed() {
        startapp.onBackPressed();
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        startapp.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startapp.onResume();
    }
}
