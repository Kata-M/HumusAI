package com.microsoft.cognitiveservices.speech.samples.quickstart;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChatActivity extends Activity {

    private TextView chatInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatInformation = (TextView) findViewById(R.id.chatInformation);

        Intent chatIntent = getIntent();
        if(chatIntent.hasExtra(Intent.EXTRA_TEXT)) {
            String phone = chatIntent.getStringExtra("phone");
            chatInformation.setText(phone);
        }
    }
}
