package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EmptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_const2);
        setTitle("練習アプリ");
        Intent intent = getIntent();
        int age = intent.getIntExtra("age", 25);
        Toast.makeText(this, "年齢："+age, Toast.LENGTH_SHORT).show();

        EditText nameText = findViewById(R.id.nameText);
        EditText passText = findViewById(R.id.passText);
        Button clearButton1 = findViewById(R.id.clearButton1);
        Button clearButton2 = findViewById(R.id.clearButton2);
        Button confirmButton = findViewById(R.id.confirmBtn);

        clearButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameText.setText("");
            }
        });

        clearButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passText.setText("");
            }
        });

        clearButton2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    setTitle(passText.getText());
                }
                else{
                    setTitle("練習アプリ");
                }
                return false;
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EmptyActivity.this, "名前：" + nameText.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        confirmButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                RadioGroup radioGroup = findViewById(R.id.radioGroup);
                RadioButton chkRb = findViewById(radioGroup.getCheckedRadioButtonId());
                Toast.makeText(EmptyActivity.this, "性別：" + chkRb.getText(), Toast.LENGTH_SHORT).show();
                finish();
                return true;
            }
        });


    }
}