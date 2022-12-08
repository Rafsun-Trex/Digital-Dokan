package com.example.digitaldokan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    List<Model> modelList = new ArrayList<>();
    RecyclerView mRecyclerView;

    RecyclerView.LayoutManager layoutManager;
    FirebaseFirestore db;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        db = FirebaseFirestore.getInstance();

        mRecyclerView = findViewById(R.id.reccycler_view);
        mRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        showData();


    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                searchData(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void searchData(String s) {

        db.collection("Documents").whereEqualTo("search", s)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        modelList.clear();
                        for(DocumentSnapshot doc: task.getResult())
                        {
                            Model model = new Model(
                                    doc.getString("shopname"),
                                    doc.getString("cusname"),
                                    doc.getString("phnnum"),
                                    doc.getString("datetime"),
                                    doc.getString("itemname"),
                                    doc.getString("serialnum"),
                                    doc.getString("warranty"),
                                    doc.getString("id"),
                                    doc.getString("price")
                            );

                            modelList.add(model);

                        }

                        adapter = new CustomAdapter(ListActivity.this, modelList);
                        mRecyclerView.setAdapter(adapter);


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ListActivity.this, "Error: "+e, Toast.LENGTH_SHORT).show();

                    }
                });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    private void showData() {
        db.collection("Documents").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        for(DocumentSnapshot doc: task.getResult())
                        {
                            Model model = new Model(
                                    doc.getString("shopname"),
                                    doc.getString("cusname"),
                                    doc.getString("phnnum"),
                                    doc.getString("datetime"),
                                    doc.getString("itemname"),
                                    doc.getString("serialnum"),
                                    doc.getString("warranty"),
                                    doc.getString("id"),
                                    doc.getString("price"));
                            modelList.add(model);

                        }

                        adapter = new CustomAdapter(ListActivity.this, modelList);
                        mRecyclerView.setAdapter(adapter);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ListActivity.this, "Error: "+e, Toast.LENGTH_SHORT).show();

                    }
                });
    }
}