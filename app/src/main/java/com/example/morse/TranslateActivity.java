package com.example.morse;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

public class TranslateActivity extends AppCompatActivity {
    private TextView output;
    private TextView english;


    public void engToMorse(String[] morseAlphabet, String a, char[] engAlphabet)
    {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < engAlphabet.length; j++) {
                if (a.charAt(i) == engAlphabet[j]) {
                    str.append(morseAlphabet[j]).append(" ");
                    break;
                }
            }
        }
        output.setText(str.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        english = findViewById(R.id.engText);
        output = findViewById(R.id.morseText);

        char[] engAlphabet = { 'a', 'à', 'b', 'c', 'd', 'e', 'è', 'é',
                'f', 'g', 'h', 'i', 'ì', 'j', 'k', 'l',
                'm', 'n', 'o', 'ò', 'p', 'q', 'r', 's',
                't', 'u', 'ù', 'v', 'w', 'x', 'y', 'z',
                '1', '2', '3', '4', '5', '6', '7', '8',
                '9', '0', ' ', '(', '-', '¿', '&', ',',
                '?', '\'', ')', ':', '!', '$', ';', '.',
                '@', '\"', '/', '¡', '=', '_', '+'};

        String[] morseAlphabet = { ".-", ".--.-", "-...", "-.-.", "-..", ".", ".-..-", "..-..",
                "..-.", "--.", "....", "..", ".---.", ".---", "-.-", ".-..",
                "--", "-.", "---", "---.", ".--.", "--.-", ".-.", "...",
                "-", "..-", "..--", "...-", ".--", "-..-", "-.--", "--..",
                ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..",
                "----.", "-----", "/", "-.--.", "-....-", "..-.-", ".-...", "--..--",
                "..--..", ".----.", "-.--.-", "---...", "-.-.--", "...-..-", "-.-.-.", ".-.-.-",
                ".--.-.", ".-..-.", "-..-.", "--...-", "-...-", "..--.-", ".-.-."};

        /*
        translateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(english.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please enter some English text", Toast.LENGTH_SHORT).show();
                }
                else{
                    engToMorse(morseAlphabet, english.getText().toString().toLowerCase(), engAlphabet);
                }
            }
        });
    */

        english.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                engToMorse(morseAlphabet, english.getText().toString().toLowerCase(), engAlphabet);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}