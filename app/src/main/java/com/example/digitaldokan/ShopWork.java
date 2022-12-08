package com.example.digitaldokan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShopWork extends AppCompatActivity {
    Button updateBtn, addBtn, searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_work);

        addBtn = findViewById(R.id.addBtn);
        updateBtn = findViewById(R.id.updateBtn);

        searchBtn = findViewById(R.id.searchBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShopWork.this, Add_Activity.class));
                //finish();
            }
        });
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShopWork.this, ListActivity.class));
                //finish();
            }
        });
    }
}