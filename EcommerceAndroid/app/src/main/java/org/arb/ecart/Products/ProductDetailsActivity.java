package org.arb.ecart.Products;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import org.arb.ecart.Model.ProductListModel;
import org.arb.ecart.Model.SliderItem;
import org.arb.ecart.R;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    AlertDialog.Builder builder;
    CoordinatorLayout coordinatorLayout;
    TextView tv_nodata, tv_product_name, tv_strike, tv_price;
    ImageView img_back;
    RecyclerView recycler_view;
    public static CustomProductDetailsAdapter customProductDetailsAdapter;
    ArrayList<ProductListModel> productListModelArrayList = new ArrayList<>();
    SliderView sliderView;
    private CustomProductDetailsSliderAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);


        //--------------------NAVIGATION DRAWER PORTIONS--------------------------//
        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
*/
        //---------------------------------------To change Navigation drawer icon
       /* getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menublack);

        builder = new AlertDialog.Builder(this);
        NavigationView navigationView = findViewById(R.id.nav_view);
        final View header = navigationView.getHeaderView(0);
        coordinatorLayout=findViewById(R.id.cordinatorLayout);
        navigationView.setNavigationItemSelectedListener(this);*/
        //-----------------------END OF NAVIGATION DRAWER PORTIONS--------------------//

        customProductDetailsAdapter = new CustomProductDetailsAdapter(this,productListModelArrayList);

//        ll_recycler = findViewById(R.id.ll_recycler);
        tv_nodata = findViewById(R.id.tv_nodata);
        tv_product_name = findViewById(R.id.tv_product_name);
        tv_strike = findViewById(R.id.tv_strike);
        tv_price = findViewById(R.id.tv_price);
        img_back = findViewById(R.id.img_back);

        //==========Recycler code initializing and setting layoutManager starts======
        recycler_view = findViewById(R.id.recycler_view);
       /* recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));*/
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,RecyclerView.HORIZONTAL,false);
//        gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_view.setLayoutManager(gridLayoutManager);
        //==========Recycler code initializing and setting layoutManager ends======

        tv_product_name.setText(ProductHomeActivity.product_name);
        tv_strike.setText(ProductHomeActivity.strike_price);
        tv_price.setText(ProductHomeActivity.price);
        img_back.setOnClickListener(this);
        LoadData();

        //---added on 17th Nov, code starts---
        sliderView = findViewById(R.id.imageSlider);


        adapter = new CustomProductDetailsSliderAdapter(this);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

        LoadSliderItems();

        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                Log.i("GGG", "onIndicatorClicked: " + sliderView.getCurrentPagePosition());
            }
        });
        //---added on 17th Nov, code ends---
    }

    //=====added on 17th Nov, code starts======
    public void LoadSliderItems() {
        List<SliderItem> sliderItemList = new ArrayList<>();
        //dummy data
        for (int i = 0; i < 5; i++) {
            SliderItem sliderItem = new SliderItem();
            sliderItem.setDescription("Slider Item " + i);
            if (i % 2 == 0) {
                sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
            } else {
                sliderItem.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
            }
            sliderItemList.add(sliderItem);
        }
        adapter.renewItems(sliderItemList);
    }
    public void renewItems(View view) {
        List<SliderItem> sliderItemList = new ArrayList<>();
        //dummy data
        for (int i = 0; i < 5; i++) {
            SliderItem sliderItem = new SliderItem();
            sliderItem.setDescription("Slider Item " + i);
            if (i % 2 == 0) {
                sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
            } else {
                sliderItem.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
            }
            sliderItemList.add(sliderItem);
        }
        adapter.renewItems(sliderItemList);
    }

    public void removeLastItem(View view) {
        if (adapter.getCount() - 1 >= 0)
            adapter.deleteItem(adapter.getCount() - 1);
    }

    public void addNewItem(View view) {
        SliderItem sliderItem = new SliderItem();
        sliderItem.setDescription("Slider Item Added Manually");
        sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
        adapter.addItem(sliderItem);
    }
    //=====added on 17th Nov, code ends======
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    public void LoadData(){
        ProductListModel productListModel = new ProductListModel();
        productListModel.setImage(R.drawable.firetvstickamazon);
        productListModel.setPrice("Rs 8000");
        productListModelArrayList.add(productListModel);

        ProductListModel productListModel1 = new ProductListModel();
        productListModel1.setImage(R.drawable.firetvstickamazon02);
        productListModel1.setPrice("Rs 8000");
        productListModelArrayList.add(productListModel1);

        ProductListModel productListModel2 = new ProductListModel();
        productListModel2.setImage(R.drawable.firetvstickamazon03);
        productListModel2.setPrice("Rs 8000");
        productListModelArrayList.add(productListModel2);

        ProductListModel productListModel3 = new ProductListModel();
        productListModel3.setImage(R.drawable.firetvstickamazon04);
        productListModel3.setPrice("Rs 8000");
        productListModelArrayList.add(productListModel3);

        ProductListModel productListModel4 = new ProductListModel();
        productListModel4.setImage(R.drawable.firetvstickamazon05);
        productListModel4.setPrice("Rs 8000");
        productListModelArrayList.add(productListModel4);

        /*ProductListModel productListModel1 = new ProductListModel();
        productListModel1.setImage(R.drawable.oppo);
        productListModel1.setPrice("Rs 8000");
        productListModelArrayList.add(productListModel1);

        ProductListModel productListModel2 = new ProductListModel();
        productListModel2.setImage(R.drawable.oppo);
        productListModel2.setPrice("Rs 8000");
        productListModelArrayList.add(productListModel2);

        ProductListModel productListModel3 = new ProductListModel();
        productListModel3.setImage(R.drawable.oppo);
        productListModel3.setPrice("Rs 8000");
        productListModelArrayList.add(productListModel3);*/

        recycler_view.setAdapter(customProductDetailsAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                Intent intent_product_home = new Intent(ProductDetailsActivity.this,ProductHomeActivity.class);
                intent_product_home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent_product_home);
                break;
            default:
                break;
        }
    }
}
