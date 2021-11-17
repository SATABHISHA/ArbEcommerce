package org.arb.ecart.Products;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import org.arb.ecart.R;

public class ProductDetailsProductImageActivity extends AppCompatActivity {
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details_product_image);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPage);
        CustomProductDetailsProductImageAdapter adapterView = new CustomProductDetailsProductImageAdapter(this);
        mViewPager.setAdapter(adapterView);
    }
}
