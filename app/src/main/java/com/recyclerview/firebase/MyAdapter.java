package com.recyclerview.firebase;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
    Context context;
    private static final String TAG = "MyAdapter";

    public MyAdapter(Context context, @NonNull FirebaseRecyclerOptions<Model> options) {
        super(options);
        this.context = context;

    }

    @Override
    protected void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position, Model model) {
        String key = this.getRef(position).getKey();
        holder.name.setText(model.getName());
        Log.e(TAG, "onBindViewHolder: name: "+ model.getName());
        Log.e(TAG, "onBindViewHolder: ky: "+ key);
        Log.e(TAG, "onBindViewHolder: no: "+ model.getNotes());
        Log.e(TAG, "onBindViewHolder: sy: "+ model.getSyllabus());
        holder.linearLayout.setOnClickListener(v->{
            Intent setIntent = new Intent(context, TabActivity.class);
            setIntent.putExtra("key", key);
            context.startActivity(setIntent);
        });
    }

    @NonNull

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_design, parent, false);
        return new MyViewHolder(view);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
//            Model model = new Model();
            linearLayout = itemView.findViewById(R.id.linearLayout);
//            linearLayout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent setIntent = new Intent(itemView.getContext(),TabActivity.class);
//                 //   setIntent.putExtra("key",model.getKey());
//                    itemView.getContext().startActivity(setIntent);
//                }
//            });

        }
    }
}
