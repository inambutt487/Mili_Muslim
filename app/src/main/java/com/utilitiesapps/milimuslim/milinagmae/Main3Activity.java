package com.utilitiesapps.milimuslim.milinagmae;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.StartAppSDK;
import com.startapp.android.publish.splash.SplashConfig;


public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
    private StartAppAd startapp = new StartAppAd(this);
    ImageView btn1,btn2,btn3,btn4;
    Intent i;
    int PERMISSION_ALL = 1;
    String[] PERMISSIONS = {android.Manifest.permission.INTERNET, android.Manifest.permission.ACCESS_NETWORK_STATE,
          android.Manifest.permission.ACCESS_WIFI_STATE };
    InterstitialAd mInterstitialAd;
    public static int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (count == 0) {
            //               Developer ID    App ID
            StartAppSDK.init(this,"168784222", "207039976", false);
            StartAppAd.showSplash(this, savedInstanceState, new SplashConfig()
                    .setTheme(SplashConfig.Theme.GLOOMY).setLogo(R.drawable.icon)
                    .setAppName("Milli Muslim League: Political Party ملی مسلم لیگ"));
            count++;
        }
        setContentView(R.layout.activity_main3);
        if (!hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }
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


        i=new Intent(Main3Activity.this,Main4Activity.class);
        btn1= (ImageView) findViewById(R.id.mili);
        btn2= (ImageView) findViewById(R.id.share);
        btn3= (ImageView) findViewById(R.id.rate);
        btn4= (ImageView) findViewById(R.id.more);
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
    private void BannerAdmob() {
        // TODO Auto-generated method stub
        AdView adView = (AdView) findViewById(R.id.adView8);
        adView.loadAd(new AdRequest.Builder().build());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.mili:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                startActivity(i);
                break;
            case R.id.share:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                share.putExtra(Intent.EXTRA_SUBJECT, "Milli Muslim League: Political Party ملی مسلم لیگ");
                share.putExtra(
                        Intent.EXTRA_TEXT,
                        "https://play.google.com/store/apps/details?id="
                                + getPackageName()).toString();
                startActivity(Intent.createChooser(share, "Milli Muslim League: Political Party ملی مسلم لیگ"));
                break;
            case R.id.rate:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?id="
                                + "com.utitlitiesapps.milli.muslim.league")));
                break;
            case R.id.more:
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://search?q=freeappscorner&c=apps&hl=en")));

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
