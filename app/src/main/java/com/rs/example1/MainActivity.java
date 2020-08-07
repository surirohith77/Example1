package com.rs.example1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RvListener {

    RecyclerView rv1;
    ArrayList  titleList1;
    RVAdapter1 adapter1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intializeTitleRecyclerview();
        RvTItle();
    }

    private void intializeTitleRecyclerview() {

        rv1 = findViewById(R.id.rv1);
        rv1.setHasFixedSize(true);
        rv1.addItemDecoration(new DividerItemDecoration(rv1.getContext(), DividerItemDecoration.VERTICAL));
        rv1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        
    }

    private void RvTItle() {

        titleList1 = new ArrayList();
        titleList1.add(new Model1("Top 250"));
        titleList1.add(new Model1("Now Showing"));
        titleList1.add(new Model1("Coming soon.."));

        adapter1 = new RVAdapter1(titleList1,this);
        rv1.setAdapter(adapter1);

    }

    @Override
    public void Rvclick(View view, int Position) {

    }


}