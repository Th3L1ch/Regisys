package com.example.conorkiernan.regisys;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import java.io.File;
import java.util.Calendar;

public class SendTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_tweet);
        String rString = getIntent().getExtras().getString("register");
        double longitude = getIntent().getExtras().getDouble("Longitude");
        double latitude = getIntent().getExtras().getDouble("Latitude");
        sendTweet(rString,latitude,longitude);
    }

    private void sendTweet(String rString,double latitude, double longitude) {


        Calendar c = Calendar.getInstance();
        String date = c.get(Calendar.DAY_OF_MONTH) + "-"
                + c.get(Calendar.MONTH) + "-"
                + c.get(Calendar.YEAR);
        String time = c.get(Calendar.HOUR_OF_DAY) + ":"
                + c.get(Calendar.MINUTE);

        String lastTwo = null;
        if (time != null && time.length() >= 2) {
            lastTwo = time.substring(time.length() - 2,time.length());
        }
        String timetwo;
        System.out.println(lastTwo);
        if(lastTwo.charAt(0)==':')
        {
            if(time.charAt(1)==':')
            {
                timetwo = time.substring(0,2)+"0"+time.substring(time.length()-1,time.length());
                System.out.println("Timeval: "+timetwo);
            }
            else
            {
                timetwo = time.substring(0,3)+"0"+time.substring(time.length()-1,time.length());
                System.out.println("Timeval: "+timetwo);
            }
        }
        else
        {
            timetwo = time;
        }

        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("Car Registration:"+rString+" \nLatitude: "+latitude+"\nLongitude: "+longitude+"\nDate: "+date+"\nTime: "+timetwo+"\nSent Via #RegISys");
        builder.show();
        super.finish();
    }
}
