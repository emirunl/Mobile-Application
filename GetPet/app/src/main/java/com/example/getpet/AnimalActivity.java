package com.example.getpet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AnimalActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Animal> animalList;
    DatabaseReference databaseReference;
    ValueEventListener eventListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(AnimalActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        AlertDialog.Builder builder = new AlertDialog.Builder(AnimalActivity.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);

        AlertDialog dialog = builder.create();
        dialog.show();

        animalList = new ArrayList<>();

        MyAdapter adapter = new MyAdapter(AnimalActivity.this, animalList);
        recyclerView.setAdapter(adapter);

        //getting key from previous fragment to list which kind of pet it will list
        String petKind = getIntent().getStringExtra("Key");

        databaseReference = FirebaseDatabase.getInstance().getReference(petKind);
        dialog.show();

        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                animalList.clear();
                for (DataSnapshot itemSnapShot: snapshot.getChildren()){
                    Animal animal = itemSnapShot.getValue(Animal.class);
                    animalList.add(animal);
                }
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                dialog.dismiss();
            }
        });

    }
}