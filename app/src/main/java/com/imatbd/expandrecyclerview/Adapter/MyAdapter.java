package com.imatbd.expandrecyclerview.Adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.imatbd.expandrecyclerview.Model.Product;
import com.imatbd.expandrecyclerview.Model.ProductCategory;
import com.imatbd.expandrecyclerview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Genius 03 on 10/18/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CategoryViewHolder> {
    private Context context;
    private List<ProductCategory> productCategoryList;
    private LayoutInflater inflater;

    public MyAdapter(Context context) {
        this.context = context;
        this.productCategoryList = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
    }

    public void addProduct(Product product){

        if(getExistingCategory(product.getCategory())!=null){
            getExistingCategory(product.getCategory()).addProduct(product);
        }else{
            productCategoryList.add(new ProductCategory(product));
        }

        notifyDataSetChanged();



    }

    private boolean isCategoryExist(String cat){
        boolean retBool = false;

        for(ProductCategory x: productCategoryList){
            if(x.getCategory().equals(cat)){
                retBool=true;
                break;
            }
        }

        return retBool;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.single_category,parent,false);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        ProductCategory productCategory = productCategoryList.get(position);

        holder.tvCat.setText(productCategory.getCategory());
        holder.rvProduct.setLayoutManager(new LinearLayoutManager(context));
        holder.rvProduct.setAdapter(new ProductAdapter(context,productCategory.getProductList()));

        if(holder.isExpand){
            holder.rvProduct.setVisibility(View.VISIBLE);
        }else{
            holder.rvProduct.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return productCategoryList.size();
    }

   /* @Override
    public int getItemCount() {
        return parentObjectList.size();
    }

    private ProductCategory getExistingCategory(String category){
        ProductCategory productCategory = null;
        for(ParentObject x: parentObjectList){
            ProductCategory pc = (ProductCategory) x;

            if(pc.getCategory().equals(category)){
                productCategory = pc;
                break;
            }
        }

        return productCategory;
    }*/

    private ProductCategory getExistingCategory(String category){
        ProductCategory productCategory = null;
        for(ProductCategory x: productCategoryList){

            if(x.getCategory().equals(category)){
                productCategory = x;
                break;
            }
        }

        return productCategory;
    }



    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvCat;
        public ImageButton ivExpand;
        public RecyclerView rvProduct;
        public boolean isExpand=false;

        public CategoryViewHolder(View itemView) {
            super(itemView);

            tvCat = itemView.findViewById(R.id.tv_cat);
            ivExpand = itemView.findViewById(R.id.iv_expand);
            rvProduct = itemView.findViewById(R.id.rv_product);

            ivExpand.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(isExpand){
                isExpand=false;
            }else{
                isExpand=true;
            }
            notifyDataSetChanged();
        }
    }



}
