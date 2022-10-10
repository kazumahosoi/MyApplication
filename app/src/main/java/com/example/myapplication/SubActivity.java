package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_const);

        setTitle("Sub Activity"); // ←追加する

        TextView nameLabel = findViewById(R.id.nameLabel);
        nameLabel.setText("Name");

        EditText nameText = findViewById(R.id.nameText2);
        Button clearButton = findViewById(R.id.clearButton);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameText.setText("");
            }
        });

        Button sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(this);

        Button confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        setTitle("Button Clicked");

        switch (view.getId()){
            case R.id.sendButton:
                Intent intent = new Intent( this , EmptyActivity.class);
                intent.putExtra("age",19);
                startActivity(intent);
//                Toast.makeText(this, "送信クリック", Toast.LENGTH_SHORT).show();
                break;
            case R.id.confirmButton:
                Toast.makeText(this, "確認クリック", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}