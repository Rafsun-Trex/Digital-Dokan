package com.example.digitaldokan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public class Add_Activity extends AppCompatActivity {
    EditText shopnameEdtTxt, cusnameEdtTxt, phnnumEdtTxt, dateEdtTxt, itemEdtTxt, serialEdtTxt, warrantyEdttxt, priceEdtTxt;
    Button addNowBtn, showNowBtn;

    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        shopnameEdtTxt = findViewById(R.id.shopnameEdtTxt);
        cusnameEdtTxt = findViewById(R.id.cusnameEdtTxt);
        phnnumEdtTxt = findViewById(R.id.phnnumEdtTxt);
        dateEdtTxt = findViewById(R.id.dateEdtTxt);
        itemEdtTxt = findViewById(R.id.itemEdtTxt);
        serialEdtTxt = findViewById(R.id.serialEdtTxt);
        warrantyEdttxt = findViewById(R.id.warrantyEdtTxt);
        priceEdtTxt = findViewById(R.id.priceEdtTxt);

        addNowBtn = findViewById(R.id.addNowBtn);
        showNowBtn = findViewById(R.id.showNowBtn);


        db = FirebaseFirestore.getInstance();


        addNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shopname = shopnameEdtTxt.getText().toString().trim();
                String cusname = cusnameEdtTxt.getText().toString().trim();
                String phnnum = phnnumEdtTxt.getText().toString().trim();
                String datetime = dateEdtTxt.getText().toString().trim();
                String itemname = itemEdtTxt.getText().toString().trim();
                String serialnum = serialEdtTxt.getText().toString().trim();
                String warranty = warrantyEdttxt.getText().toString().trim();
                String price = priceEdtTxt.getText().toString().trim();

                uploadData(shopname, cusname, phnnum, datetime, itemname, serialnum, warranty, price);

            }
        });

        showNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Add_Activity.this, ListActivity.class));
                finish();
            }
        });
    }

    private void uploadData(String shopname, String cusname, String phnnum, String datetime, String itemname, String serialnum, String warranty, String price)
    {
        String id = UUID.randomUUID().toString();
        Map<String, Object> doc = new HashMap<>();
        doc.put("id", id);
        doc.put("shopname", shopname);
        doc.put("cusname", cusname);
        doc.put("phnnum", phnnum);
        doc.put("search", phnnum);
        doc.put("datetime", datetime);
        doc.put("itemname", itemname);
        doc.put("serialnum", serialnum);
        doc.put("warranty", warranty);
        doc.put("price", price);

        db.collection("Documents").document(id).set(doc)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Add_Activity.this, "Data uploaded successfully.", Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Add_Activity.this, "Error"+e, Toast.LENGTH_SHORT).show();

                    }
                });

    }


}