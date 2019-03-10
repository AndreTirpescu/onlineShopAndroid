package com.example.onlineshopandroid;


import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.example.onlineshopandroid.product.Product;
import com.example.onlineshopandroid.product.ProductCollection;

public class ProductHypeClickListener implements AdapterView.OnItemClickListener
{
    private ProductCollection products;
    private Context context;

    public ProductHypeClickListener(Context context, ProductCollection products)
    {
        this.products = products;
        this.context = context;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id)
    {
        Product prod = products.getProduct(position);
        Intent intent = new Intent(this.context, ProductDetailsActivity.class);
        intent.putExtra("PROD_NAME", prod.getName());
        intent.putExtra("PROD_PRICE", prod.getPrice().toString() + "$");
        intent.putExtra("PROD_DESCRIPTION", prod.getDescription());
        intent.putExtra("PROD_HYPE", prod.getHype());
        context.startActivity(intent);
    }

}
