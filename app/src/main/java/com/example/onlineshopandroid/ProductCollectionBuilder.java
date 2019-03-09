package com.example.onlineshopandroid;

public class ProductCollectionBuilder {

    public ProductCollection build()
    {
        return new ProductCollection()
                .add(new Product("Product1", 1.0, "Description 1", "WOW"))
                .add(new Product("Product2", 2.0, "Description 2", "Great"))
                .add(new Product("Product3", 3.0, "Description 3", "Best"))
                .add(new Product("Product4", 4.0, "Description 4","Better"))
                .add(new Product("Product5", 5.0, "Description 5", "You won't regret it"))
                .add(new Product("Product6", 6.0, "Description 6", "FREE"))
                .add(new Product("Product7", 7.0, "Description 7", "No way you're not paying attention to this offer"))
                .add(new Product("Product8", 8.0, "Description 8", "Neat"))
                .add(new Product("Product9", 9.0, "Description 9","Kill me now"))
                .add(new Product("Product10", 10.0, "Description 10", "What am I doing here"));
    }

}
