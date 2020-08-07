package com.rs.example1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RvAdapter2 extends RecyclerView.Adapter<RvAdapter2.MYVIEWHOLDER> {

    List<Model1> list;
   //RvListener listener;
    Context context;

    public RvAdapter2(List<Model1> list/*, RvListener listener*/) {
        this.list = list;
      //  this.listener = listener;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_design2,parent,false);
        return new MYVIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYVIEWHOLDER holder, int position) {

        final Model1 model1 = list.get(position);
        holder.tvTitle.setText(model1.getTitle());

        holder.linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,SecondActivity.class);
                intent.putExtra("title",model1.getTitle());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MYVIEWHOLDER extends RecyclerView.ViewHolder {
        TextView tvTitle;
        LinearLayout linear1;

        public MYVIEWHOLDER(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            linear1 = itemView.findViewById(R.id.linear1);
        }
    }
}
