package com.imatbd.expandrecyclerview.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.imatbd.expandrecyclerview.Model.Product;
import com.imatbd.expandrecyclerview.R;

import java.util.List;

/**
 * Created by Genius 03 on 10/18/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private Context context;
    private List<Product> productList;
    private LayoutInflater inflater;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.single_product,parent,false);

        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

        Product product = productList.get(position);

        holder.tvName.setText(product.getName());
        holder.tvDesc.setText(product.getDescription());
        holder.tvPrice.setText(String.valueOf(product.getPrice()));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductViewHolder extends ChildViewHolder implements View.OnClickListener {
        public TextView tvName,tvDesc,tvPrice;

        public ProductViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.prod_name);
            tvDesc = itemView.findViewById(R.id.prod_description);
            tvPrice = itemView.findViewById(R.id.prod_price);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
