package com.example.digitaldokan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomerWork extends AppCompatActivity {
    Button searchcusBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_work);

        searchcusBtn = findViewById(R.id.customerSearchBtn);

        searchcusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CustomerWork.this, ListActivity.class));
                //finish();

            }
        });
    }
}