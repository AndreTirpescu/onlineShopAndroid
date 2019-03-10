package com.example.onlineshopandroid.product;

import java.util.ArrayList;
import java.util.List;

public class ProductCollection
{
    List<Product> productList;

    public ProductCollection()
    {
        this.productList = new ArrayList<Product>();
    }

    public ProductCollection add(Product prod)
    {
        productList.add(prod);

        return this;
    }

    public List<String> productNames()
    {
        List<String> productNames = new ArrayList<String>();
        for (Product p : productList) {
            productNames.add(p.getName());
        }

        return productNames;
    }

    public List<Product> getProducts()
    {
        return this.productList;
    }

    public Product getProduct(Integer index)
    {
        return this.productList.get(index);
    }
}
