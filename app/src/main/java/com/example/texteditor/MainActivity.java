package com.example.texteditor;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button copyButton;
    Button bubbleButton;
    Button strikeButton;
    Button updownmirButton;
    Button boldButton;
    TextView textView;

    TextTransformer textTransformer = new TextTransformer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.editText_input);
        copyButton = findViewById(R.id.copyButton);
        bubbleButton = findViewById(R.id.bubbleButton);
        strikeButton = findViewById(R.id.strikeButton);
        updownmirButton = findViewById(R.id.updownmirButton);
        boldButton = findViewById(R.id.boldButton);
        textView = findViewById(R.id.editText_output);


        bubbleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textTransformer.setWordList(editText.getText().toString());
                textTransformer.setSetType(0);
                textView.setText(textTransformer.replaceList());
            }
        });{}


        strikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textTransformer.setWordList(editText.getText().toString());
                textTransformer.setSetType(1);
                textView.setText(textTransformer.replaceList());

            }
        });{}

        updownmirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textTransformer.setWordList(editText.getText().toString());
                textTransformer.setSetType(2);
                textView.setText(textTransformer.replaceList());
                //textView.setText(textTransformer.getWordList());
                    //String oldtext = editText.getText().toString();
                    //String newText = convertText(oldtext);
                    //textView.setText(newText);
            }
        });{}

        boldButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textTransformer.setWordList(editText.getText().toString());
                textTransformer.setSetType(3);
                textView.setText(textTransformer.replaceList());
                //textView.setText(textTransformer.getWordList());
                //String oldtext = editText.getText().toString();
                //String newText = convertText(oldtext);
                //textView.setText(newText);
            }
        });{}


        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("textView", textView.getText().toString());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(MainActivity.this, "Copied.", Toast.LENGTH_SHORT).show();


            }
        });{}



    }

}