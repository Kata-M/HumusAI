package com.microsoft.cognitiveservices.speech.samples.quickstart;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.microsoft.cognitiveservices.speech.ResultReason;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.SpeechRecognitionResult;
import com.microsoft.cognitiveservices.speech.SpeechRecognizer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import static android.Manifest.permission.*;

public class MainActivity extends Activity {

    // Replace below with your own subscription key
    private static String speechSubscriptionKey = Key.key;
    // Replace below with your own service region (e.g., "westus").
    private static String serviceRegion = "northeurope";

    private Button doctorButton;
    private Button hairdresserButton;
    private Button restaurantsButton;
    private Button friendsButton;

    private List<Button> buttonsList = new ArrayList<Button>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Call4All");

        doctorButton = (Button) findViewById(R.id.doctorButton);
        hairdresserButton = (Button) findViewById(R.id.hairdresserButton);
        restaurantsButton = (Button) findViewById(R.id.restaurantsButton);
        friendsButton = (Button) findViewById(R.id.friendsButton);

        buttonsList.add(doctorButton);
        buttonsList.add(hairdresserButton);
        buttonsList.add(restaurantsButton);
        buttonsList.add(friendsButton);

        for(Button actionButton : buttonsList) {
            actionButton.setOnClickListener((v) -> {

                String buttonPressed = actionButton.getText().toString();
                Context context = MainActivity.this;
                Class formDetailsActivity = FormDetailsActivity.class;

                Intent intentForm = new Intent(context, formDetailsActivity);
                intentForm.putExtra(Intent.EXTRA_TEXT, buttonPressed);

                startActivity(intentForm);
            });
        }

        // Note: we need to request the permissions
//        int requestCode = 5; // unique code for the permission request
//        ActivityCompat.requestPermissions(MainActivity.this, new String[]{RECORD_AUDIO, INTERNET}, requestCode)
    }

//    public void onSpeechButtonClicked(View v) {
//        TextView txt = (TextView) this.findViewById(R.id.hello); // 'hello' is the ID of your text view
//
//        try {
//            SpeechConfig config = SpeechConfig.fromSubscription(speechSubscriptionKey, serviceRegion);
//            assert(config != null);
//
//            SpeechRecognizer reco = new SpeechRecognizer(config);
//            assert(reco != null);
//
//            Future<SpeechRecognitionResult> task = reco.recognizeOnceAsync();
//            assert(task != null);
//
//            // Note: this will block the UI thread, so eventually, you want to
//            //        register for the event (see full samples)
//            SpeechRecognitionResult result = task.get();
//            assert(result != null);
//
//            if (result.getReason() == ResultReason.RecognizedSpeech) {
//                txt.setText(result.toString());
//            }
//            else {
//                txt.setText("Error recognizing. Did you update the subscription info?" + System.lineSeparator() + result.toString());
//            }
//
//            reco.close();
//        } catch (Exception ex) {
//            Log.e("SpeechSDKDemo", "unexpected " + ex.getMessage());
//            assert(false);
//        }
//    }
}
//package com.microsoft.cognitiveservices.speech.samples.quickstart;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.speech.tts.TextToSpeech;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import java.util.Locale;
//import android.widget.Toast;
//
//public class MainActivity extends Activity {
//    TextToSpeech t1;
//    EditText ed1;
//    Button b1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ed1=(EditText)findViewById(R.id.editText);
//        b1=(Button)findViewById(R.id.button);

//        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int status) {
//                if(status != TextToSpeech.ERROR) {
//                    t1.setLanguage(Locale.UK);
//                }
//            }
//        });

//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String toSpeak = ed1.getText().toString();
//                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
//                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
//            }
//        });
//    }
//
//    public void onPause(){
//        if(t1 !=null){
//            t1.stop();
//            t1.shutdown();
//        }
//        super.onPause();
//    }
//}