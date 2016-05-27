package com.example.pgriffiths3156.chapter5;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends Activity implements View.OnClickListener{

    public SharedPreferences prefs;
    public SharedPreferences.Editor editor;
    String dataName = "MyData";
    String stringName = "MyString";
    String defaultString = ":-(";
    String currentString = "";//empty
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getSharedPreferences(dataName,MODE_PRIVATE);
        editor = prefs.edit();

        currentString = prefs.getString(stringName, defaultString);

        button1 =(Button) findViewById(R.id.button);

        button1.setOnClickListener(this);

        button1.setText(currentString);

    }


    @Override
    public void onClick(View view) {
        Random randInt = new Random();
        int ourRandom = randInt.nextInt(10);

        currentString = currentString + ourRandom;

        editor.putString(stringName, currentString);
        editor.commit();

        button1.setText(currentString);

    }
}
