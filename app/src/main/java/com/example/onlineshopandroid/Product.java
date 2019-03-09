package com.example.onlineshopandroid;

public class Product
{
    private String name;
    private Double price;
    private String description;
    private String hype;

    public Product(String name, Double price, String description, String hype)
    {
        this.name = name;
        this.price = price;
        this.description = description;
        this.setHype(hype);
    }

    public String getName()
    {
        return this.name;
    }

    public Double getPrice()
    {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }

    public Product setName(String name)
    {
        this.name = name;

        return this;
    }

    public Product setDescription(String description)
    {
        this.description = description;

        return this;
    }

    public Product setPrice(Double price)
    {
        this.price = price;

        return this;
    }

    public String getHype() {
        return this.hype;
    }

    public Product setHype(String hype) {
        this.hype = hype;

        return  this;
    }
}
