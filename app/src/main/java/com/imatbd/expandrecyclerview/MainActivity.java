package com.imatbd.expandrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.imatbd.expandrecyclerview.Adapter.MyAdapter;
import com.imatbd.expandrecyclerview.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rvCat;

    private MyAdapter adapter;

    private List<ParentObject> parentObjectList;

    private EditText etCategory;
    private Button btnAdd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parentObjectList = new ArrayList<>();

        rvCat = (RecyclerView) findViewById(R.id.expand_recycler);

        btnAdd = (Button) findViewById(R.id.add);
        etCategory = (EditText) findViewById(R.id.catName);

        btnAdd.setOnClickListener(this);

        adapter = new MyAdapter(getApplicationContext());
        rvCat.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvCat.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        String catName = etCategory.getText().toString().trim();

        Product product = new Product("Product",catName,"Description",100);

        adapter.addProduct(product);
    }
}
