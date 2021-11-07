package org.arb.ecart.Model;

import android.widget.ImageView;

public class BannerListModel {
    String tv_name;
    ImageView product_image;
    Integer image;

    public String getTv_name() {
        return tv_name;
    }

    public ImageView getProduct_image() {
        return product_image;
    }

    public Integer getImage() {
        return image;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public void setProduct_image(ImageView product_image) {
        this.product_image = product_image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
