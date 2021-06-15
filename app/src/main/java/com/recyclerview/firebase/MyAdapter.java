package com.recyclerview.firebase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.tabs.TabLayout;

public class MyAdapter extends FirebaseRecyclerAdapter<Model, MyAdapter.MyViewHolder> {

    public MyAdapter(@NonNull  FirebaseRecyclerOptions<Model> options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull  MyAdapter.MyViewHolder holder, int position, Model model) {
        holder.name.setText(model.getName());

//        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

    }

    @NonNull

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_design,parent,false);
        return new MyViewHolder(view);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            Model model = new Model();
            linearLayout = itemView.findViewById(R.id.linearLayout);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent setIntent = new Intent(itemView.getContext(),TabActivity.class);
                 //   setIntent.putExtra("key",model.getKey());
                    itemView.getContext().startActivity(setIntent);
                }
            });

        }
    }
}
