package com.imatbd.expandrecyclerview.Model;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Genius 03 on 10/18/2017.
 */

public class ProductCategory {
    private List<Product> productList;
    private String category;


    public ProductCategory(Product product) {
        this.category = product.getCategory();
        productList = new ArrayList<>();
        productList.add(product);
    }


    public List<Product> getProductList() {
        return productList;
    }


    public void addProduct(Product product){
        productList.add(product);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
