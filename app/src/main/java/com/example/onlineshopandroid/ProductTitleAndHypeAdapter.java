package com.example.onlineshopandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ProductTitleAndHypeAdapter extends ArrayAdapter<Product>
{
    private Context context;
    private ProductCollection products;
    private LayoutInflater inflater;

    public ProductTitleAndHypeAdapter(Context context, ProductCollection products)
    {
        super(context, 0, products.getProducts());
        this.context = context;
        this.products = products;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = this.inflater.inflate(R.layout.product_intro, parent, false);
        Product prod = this.products.getProduct(position);

        TextView title = (TextView) listItem.findViewById(R.id.title);
        title.setText(prod.getName());

        TextView release = (TextView) listItem.findViewById(R.id.hype);
        release.setText(prod.getHype());

        return listItem;
    }
}
