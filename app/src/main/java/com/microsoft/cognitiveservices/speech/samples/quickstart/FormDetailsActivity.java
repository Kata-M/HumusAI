package com.microsoft.cognitiveservices.speech.samples.quickstart;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class FormDetailsActivity extends Activity {

    private EditText phoneNumber;
    private EditText appointmentReason;
    private EditText socialNumber;
    private EditText preferredTime;
    private ImageButton callButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_details);

        TextView text = (TextView) findViewById(R.id.formDetails);
        EditText phoneNumberField = (EditText) findViewById(R.id.phoneNumber);

        Intent formIntent = getIntent();
        if(formIntent.hasExtra(Intent.EXTRA_TEXT)) {
            String buttonPressed = formIntent.getStringExtra(Intent.EXTRA_TEXT);
            text.setText(buttonPressed);
            phoneNumberField.setHint(buttonPressed + "'s Number e.g. +02299911310");
        }

        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        appointmentReason = (EditText) findViewById(R.id.reason);
        socialNumber = (EditText) findViewById(R.id.socialSecurity);
        preferredTime = (EditText) findViewById(R.id.preferredTime);
        callButton = (ImageButton) findViewById(R.id.callButton);

        callButton.setOnClickListener((v) -> {

            Context context = FormDetailsActivity.this;
            Class chatActivity = ChatActivity.class;

            Intent intentChat = new Intent(context, chatActivity);
            intentChat.putExtra("phone", phoneNumber.getText().toString());
            intentChat.putExtra("reason", appointmentReason.getText().toString());
            intentChat.putExtra("socialNumber", socialNumber.getText().toString());
            intentChat.putExtra("time", preferredTime.getText().toString());

            startActivity(intentChat);
        });

    }
}
