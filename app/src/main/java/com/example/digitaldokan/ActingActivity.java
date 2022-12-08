package com.example.digitaldokan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActingActivity extends AppCompatActivity {
    Button shopownerBtn, customerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acting);

        shopownerBtn = findViewById(R.id.shopownerBtn);
        customerBtn = findViewById(R.id.CustomerBtn);

        shopownerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActingActivity.this, ShopWork.class));
                //finish();
            }
        });
        customerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActingActivity.this, CustomerWork.class));
                //finish();
            }
        });

    }


}