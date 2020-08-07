package com.rs.example1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter1 extends RecyclerView.Adapter<RVAdapter1.MYVIEWHOLDER> {

    List<Model1> list;
    RvListener rvListener;
    Context context;
   int counter = 0;

    public RVAdapter1(List<Model1> list, RvListener rvListener) {
        this.list = list;
        this.rvListener = rvListener;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_design1,parent,false);
        return new MYVIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MYVIEWHOLDER holder, int position) {

        final Model1 model1 = list.get(position);
        holder.tvTitle.setText(model1.getTitle());
        holder.relative1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                initializeRecyclerviewData(model1, holder);
            }
        });

    }

    private void initializeRecyclerviewData(Model1 model1, MYVIEWHOLDER holder) {

        counter++;

        ArrayList  titleList2;
        titleList2 = new ArrayList();

        if (model1.getTitle().equals("Top 250")){
            titleList2.add(new Model1("Iron man"));
            titleList2.add(new Model1("Iron man2"));
            titleList2.add(new Model1("Iron man3"));
        }
        else if (model1.getTitle().equals("Now Showing")){

            titleList2.add(new Model1("The Conjuring"));
            titleList2.add(new Model1("Despicable 2"));
            titleList2.add(new Model1("Turbo"));
            titleList2.add(new Model1("Grown Ups2"));
            titleList2.add(new Model1("Red2"));
            titleList2.add(new Model1("The Wolverine"));

        }   else if (model1.getTitle().equals("Coming soon..")) {

            titleList2.add(new Model1("2 Guns"));
            titleList2.add(new Model1("The Smurfs 2"));
            titleList2.add(new Model1("The Spectacular Now"));
            titleList2.add(new Model1("The Canyons"));
            titleList2.add(new Model1("Europa Report"));

        }

        if (counter==1){

            holder.rv2.setVisibility(View.VISIBLE);
            holder.ivViewMore.setImageResource(R.drawable.up_arrow_blue);
            Animation animation1 =
                    AnimationUtils.loadAnimation(context, R.anim.rotate);
            holder.ivViewMore.startAnimation(animation1);

        }
        else {

            counter= 0;
            holder.rv2.setVisibility(View.GONE);
            holder.ivViewMore.setImageResource(R.drawable.down_arrow_blue);
            Animation animation1 =
                    AnimationUtils.loadAnimation(context, R.anim.rotate);
            holder.ivViewMore.startAnimation(animation1);

        }


        RvAdapter2  adapter2 = new RvAdapter2(titleList2);
        holder.rv2.setAdapter(adapter2);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MYVIEWHOLDER extends RecyclerView.ViewHolder implements View.OnClickListener, RvListener{
        TextView tvTitle;
        RecyclerView rv2;
        ImageView ivViewMore;
        RelativeLayout relative1;

        public MYVIEWHOLDER(@NonNull View itemView) {
            super(itemView);

            ivViewMore = itemView.findViewById(R.id.ivViewMore);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            rv2 = itemView.findViewById(R.id.rv2);
            relative1 = itemView.findViewById(R.id.relative1);

            intializeTitleRecyclerview();

            itemView.setOnClickListener(this);
            relative1.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
        }

        private void intializeTitleRecyclerview() {

            rv2 = itemView.findViewById(R.id.rv2);
            rv2.setHasFixedSize(true);
            rv2.addItemDecoration(new DividerItemDecoration(rv2.getContext(), DividerItemDecoration.VERTICAL));
            rv2.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        }

        @Override
        public void Rvclick(View view, int Position) {

        }
    }

}
