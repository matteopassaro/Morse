package com.example.morse;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button translateButton = (Button)findViewById(R.id.translateButton);
        translateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTranslateActivity();
            }
        });
    }

    public void openTranslateActivity() {
        Intent intent = new Intent(this, TranslateActivity.class);
        startActivity(intent);
    }
}