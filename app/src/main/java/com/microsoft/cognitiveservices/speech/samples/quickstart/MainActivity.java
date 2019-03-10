package com.microsoft.cognitiveservices.speech.samples.quickstart;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private static final int SIGN_IN_REQUEST_CODE = 100;
    // Replace below with your own subscription key
    private static String speechSubscriptionKey = Key.key;
    // Replace below with your own service region (e.g., "westus").
    private static String serviceRegion = "northeurope";

    // Firebase instance variables
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;

    private Button doctorButton;
    private Button hairdresserButton;
    private Button restaurantsButton;
    private Button friendsButton;
    private String mUsername;
    private String mPhotoUrl;

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

        // Initialize Firebase Auth
        if(FirebaseAuth.getInstance().getCurrentUser() == null) {
            // Start sign in/sign up activity
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .build(),
                    SIGN_IN_REQUEST_CODE
            );
        } else {
            // User is already signed in. Therefore, display
            // a welcome Toast
            Toast.makeText(this,
                    "Welcome " + FirebaseAuth.getInstance()
                            .getCurrentUser()
                            .getDisplayName(),
                    Toast.LENGTH_LONG)
                    .show();
        }

        // Note: we need to request the permissions
//        int requestCode = 5; // unique code for the permission request
//        ActivityCompat.requestPermissions(MainActivity.this, new String[]{RECORD_AUDIO, INTERNET}, requestCode)
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SIGN_IN_REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                Toast.makeText(this,
                        "Successfully signed in. Welcome!",
                        Toast.LENGTH_LONG)
                        .show();
            } else {
                Toast.makeText(this,
                        "We couldn't sign you in. Please try again later.",
                        Toast.LENGTH_LONG)
                        .show();

                // Close the app
                finish();
            }
        }
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