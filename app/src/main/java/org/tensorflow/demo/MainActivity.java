package org.tensorflow.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import org.tensorflow.demo.R;
import org.tensorflow.demo.env.ImageUtils;


public class MainActivity extends Activity implements View.OnClickListener {
    private static MainActivity INSTANCE=null;
    private Button learningBtn;
    private Button dialogicBtn;
    private TTS tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        INSTANCE = this;
        setContentView(R.layout.activity_main);
        learningBtn = (Button) findViewById(R.id.btn_learning);
        dialogicBtn = findViewById(R.id.btn_dialogic);
        learningBtn.setOnClickListener(this);
        dialogicBtn.setOnClickListener(this);
        tts = new TTS(getApplicationContext());
        ImageUtils.initializeDirectory();
    }

    private void startLearning(){
        //tts.speak("You have selected self learning");
        Intent intent = new Intent(getApplicationContext(), ClassifierActivity.class);
        startActivity(intent);
    }

    private void startDialogic(){
        ///tts.speak("You have selected dialogic reading");
    }

    public static MainActivity getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_learning:
                startLearning();
                break;
            case R.id.btn_dialogic:
                startDialogic();
                break;
                default:
                    break;
        }
    }
}
