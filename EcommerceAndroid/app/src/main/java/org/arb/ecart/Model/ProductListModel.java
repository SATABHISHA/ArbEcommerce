package org.arb.ecart.Model;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class ProductListModel {
    String price, product_name, discounted_price;
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

    public String getProduct_name() {
        return product_name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscounted_price() {
        return discounted_price;
    }

    public ImageView getProduct_image() {
        return product_image;
    }

    public void setProduct_image(ImageView product_image) {
        this.product_image = product_image;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setDiscounted_price(String discounted_price) {
        this.discounted_price = discounted_price;
    }
}
