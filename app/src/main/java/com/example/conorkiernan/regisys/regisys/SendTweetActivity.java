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
        String filepath = getIntent().getExtras().getString("filepath");
        sendTweet(filepath);
    }

    private void sendTweet(String filePath) {
        File myImageFile = new File(filePath);
        Uri myImageUri = Uri.fromFile(myImageFile);

        Calendar c = Calendar.getInstance();
        String date = c.get(Calendar.DAY_OF_MONTH) + "-"
                + c.get(Calendar.MONTH) + "-"
                + c.get(Calendar.YEAR);
        String time = c.get(Calendar.HOUR_OF_DAY) + ":"
                + c.get(Calendar.MINUTE);

        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("Sample Twitter data for RegISys.\nLocation: XXXXXX .\nDate: "+date+".\nTime:"+time+".\nSent Via #RegISys")
                .image(myImageUri);
        builder.show();
        super.finish();
    }
}
