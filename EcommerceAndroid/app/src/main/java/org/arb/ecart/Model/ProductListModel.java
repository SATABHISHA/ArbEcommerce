package org.arb.ecart.Model;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class ProductListModel {
    String price;
    ImageView product_image;
    Integer image;


    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ImageView getProduct_image() {
        return product_image;
    }

    public void setProduct_image(ImageView product_image) {
        this.product_image = product_image;
    }
}
