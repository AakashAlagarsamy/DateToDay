package com.aakash.datetoday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;



import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText date, month, year;
    int dd,mm,yy;
    String dayvalue,d,m,y;
    TextView text;
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.calc);
        date = (EditText)findViewById(R.id.datevalue);
        month = (EditText)findViewById(R.id.monthvalue);
        year = (EditText)findViewById(R.id.yearvalue);
        text = (TextView)findViewById(R.id.day);

        MobileAds.initialize(this, "ca-app-pub-9372606222251441~3038383696");

        adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-9372606222251441/4870340119");


        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                d = date.getText().toString();
                m = month.getText().toString();
                y = year.getText().toString();
                dd = Integer.parseInt(d);
                mm = Integer.parseInt(m);
                yy = Integer.parseInt(y);
                dayvalue = Getdate(dd,mm,yy);
                text.setText("Day is "+dayvalue);

            }
        });
    }

    public String Getdate(int dd, int mm, int yy) {
        int m[]={0,3,3,6,1,4,6,2,5,0,3,5};
        int a=0,b,c=0,e,t,z;
        if(yy>=2000&&yy<2100)
        {
            a=6;
            c=yy-2000;
        }
        else if(yy>=1900&&yy<2000)
        {
            a=0;
            c=yy-1900;
        }
        else if(yy>=1800&&yy<1900)
        {
            a=2;
            c=yy-1800;
        }
        else if(yy>=1700&&yy<1800)
        {
            a=4;
            c=yy-1700;
        }
        else if(yy>=1600&&yy<1700)
        {
            a=6;
            c=yy-1600;
        }
        else if(yy>=2100&&yy<2200)
        {
            a=4;
            c=yy-2100;
        }
        else if(yy>=2200&&yy<2300)
        {
            a=2;
            c=yy-2200;
        }
        else if(yy>=2300&&yy<2400)
        {
            a=0;
            c=yy-2300;
        }
        b=m[mm-1];
        e=c/4;
        t=dd+a+b+c+e;
        z=t%7;
        switch(z)
        {
            case 1  :   return"Monday";
            case 2  :   return"Tuesday";
            case 3  :   return"Wednesday";
            case 4  :   return"Thursday";
            case 5  :   return"Friday";
            case 6  :   return"Saturday";
            default :   return "Sunday";
        }
    }


}
