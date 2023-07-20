package com.example.morse;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView lastletter;
    Button translateButton;

    private HandlerThread blinkerThread = new HandlerThread("blinkerThread");
    private Handler blinkerHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        translateButton = (Button)findViewById(R.id.translateButton);
        lastletter = (TextView) findViewById(R.id.lastletter);
        blinkerThread.start();
        blinkerHandler = new Handler(blinkerThread.getLooper());

        // Translate Button onClicklìListener
        translateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTranslateActivity();
            }
        });


    }
    public void blink(View view){
        blinkerHandler.post(new blinkerRunnable());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        blinkerThread.quit();
    }

    public void openTranslateActivity() {
        Intent intent = new Intent(this, TranslateActivity.class);
        startActivity(intent);
    }

     class blinkerRunnable implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                lastletter.setVisibility(View.VISIBLE);
                SystemClock.sleep(1000);
                lastletter.setVisibility(View.INVISIBLE);
                SystemClock.sleep(1000);
            }
        }
    }
}