package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        Intent intent = getIntent();
        String itemName = intent.getStringExtra("item");

        SharedPreferences pref = getPreferences(Context.MODE_PRIVATE);

        EditText thoughtsText = findViewById(R.id.thoughtsText);
        Button saveBt = findViewById(R.id.saveButton);
        Button cancelBt = findViewById(R.id.cancelButton);

        String thoughtsSt = pref.getString(itemName, "");
        thoughtsText.setText(thoughtsSt);

        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                SharedPreferences.Editor editor = pref.edit();
                editor.putString(itemName, thoughtsText.getText().toString());
                editor.apply();
                Toast.makeText(getApplicationContext(), "保存しました", Toast.LENGTH_SHORT).show();
            }
        });

        cancelBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "終了します", Toast.LENGTH_SHORT).show(); finish();
            }
        });
    }
}