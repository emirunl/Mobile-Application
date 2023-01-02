package com.example.getpet;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<Animal> animalList;

    public MyAdapter(Context context, List<Animal> animalList) {
        this.context = context;
        this.animalList = animalList;
    }
    // for testing
    public MyAdapter(List<Animal> animalList){
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(animalList.get(position).getPetImage()).into(holder.recyclerImage);
        holder.recyclerName.setText(animalList.get(position).getName());
        holder.recyclerAge.setText(animalList.get(position).getAge());
        holder.recyclerGender.setText(animalList.get(position).getGender());

        holder.recyclerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("Image", animalList.get(holder.getAdapterPosition()).getPetImage());
                intent.putExtra("Name", animalList.get(holder.getAdapterPosition()).getName());
                intent.putExtra("Age", animalList.get(holder.getAdapterPosition()).getAge());
                intent.putExtra("Gender", animalList.get(holder.getAdapterPosition()).getGender());

                intent.putExtra("Size", animalList.get(holder.getAdapterPosition()).getSize());
                intent.putExtra("Length", animalList.get(holder.getAdapterPosition()).getLength());
                intent.putExtra("Energy", animalList.get(holder.getAdapterPosition()).getEnergy());

                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView recyclerImage;
    TextView recyclerName, recyclerAge, recyclerGender;
    CardView recyclerCard;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recyclerImage = itemView.findViewById(R.id.recyclerImage);
        recyclerName = itemView.findViewById(R.id.recyclerName);
        recyclerAge = itemView.findViewById(R.id.recyclerAge);
        recyclerGender = itemView.findViewById(R.id.recyclerGender);
        recyclerCard = itemView.findViewById(R.id.recyclerCard);

    }
}