package org.arb.ecart.Products;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import org.arb.ecart.Model.BannerListModel;
import org.arb.ecart.Model.ProductListModel;
import org.arb.ecart.R;

import java.util.ArrayList;

public class ProductHomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    AlertDialog.Builder builder;
    CoordinatorLayout coordinatorLayout;
    TextView tv_nodata;
    RecyclerView recycler_view, recycler_view_banner;
    public static String product_name = "", price = "", strike_price = "";
    public static CustomProductHomeBannerListAdapter customProductHomeBannerListAdapter;
    ArrayList<BannerListModel> bannerListModelArrayList = new ArrayList<>();

    public static CustomProductHomeListAdapter customProductHomeListAdapter;
    ArrayList<ProductListModel> productListModelArrayList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_home);

        //--------------------NAVIGATION DRAWER PORTIONS--------------------------//
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
//        toggle.setHomeAsUpIndicator(R.drawable.menublack);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //---------------------------------------To change Navigation drawer icon
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.hamburgericon1);

        builder = new AlertDialog.Builder(this);
        NavigationView navigationView = findViewById(R.id.nav_view);
        final View header = navigationView.getHeaderView(0);
        /*tv_fullname=header.findViewById(R.id.tv_fullname);
        tv_companynam=header.findViewById(R.id.tv_companynam);*/
        //  ed_userpassword=findViewById(R.id.ed_userpassword);
        coordinatorLayout=findViewById(R.id.cordinatorLayout);
       /* tv_fullname.setText(userSingletonModel.getFull_employee_name());
        tv_companynam.setText(userSingletonModel.getCompany_name());*/
        navigationView.setNavigationItemSelectedListener(this);
        //-----------------------END OF NAVIGATION DRAWER PORTIONS--------------------//

        customProductHomeListAdapter = new CustomProductHomeListAdapter(this,productListModelArrayList);

//        ll_recycler = findViewById(R.id.ll_recycler);
        tv_nodata = findViewById(R.id.tv_nodata);

        //==========Recycler code initializing and setting layoutManager starts======
        recycler_view = findViewById(R.id.recycler_view);
       /* recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));*/
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recycler_view.setLayoutManager(gridLayoutManager);
        //==========Recycler code initializing and setting layoutManager ends======

        LoadData();

        //=======Code for banner recycler view, code starts======
        customProductHomeBannerListAdapter = new CustomProductHomeBannerListAdapter(this,bannerListModelArrayList);

//        tv_nodata = findViewById(R.id.tv_nodata);

        //==========Recycler code initializing and setting layoutManager starts======
        recycler_view_banner = findViewById(R.id.recycler_view_banner);


        GridLayoutManager gridLayoutManagerBanner = new GridLayoutManager(getApplicationContext(),1,RecyclerView.HORIZONTAL,false);
//        gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_view_banner.setLayoutManager(gridLayoutManagerBanner);
        //==========Recycler code initializing and setting layoutManager ends======

        LoadBannerData();
        //=======Code for banner recycler view, code ends======
    }

    public void LoadBannerData(){
        BannerListModel bannerListModel = new BannerListModel();
        bannerListModel.setImage(R.drawable.star);
        bannerListModel.setTv_name("Mobiles");
        bannerListModelArrayList.add(bannerListModel);

        BannerListModel bannerListModel1 = new BannerListModel();
        bannerListModel1.setImage(R.drawable.star);
        bannerListModel1.setTv_name("Electronics");
        bannerListModelArrayList.add(bannerListModel1);

        BannerListModel bannerListModel2 = new BannerListModel();
        bannerListModel2.setImage(R.drawable.star);
        bannerListModel2.setTv_name("Apparel");
        bannerListModelArrayList.add(bannerListModel2);

        BannerListModel bannerListModel3 = new BannerListModel();
        bannerListModel3.setImage(R.drawable.star);
        bannerListModel3.setTv_name("Appliances");
        bannerListModelArrayList.add(bannerListModel3);

        BannerListModel bannerListModel4 = new BannerListModel();
        bannerListModel4.setImage(R.drawable.star);
        bannerListModel4.setTv_name("Furniture");
        bannerListModelArrayList.add(bannerListModel4);



        recycler_view_banner.setAdapter(customProductHomeBannerListAdapter);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        item.setIcon(R.drawable.menublack);
        return false;
    }

    public void LoadData(){
        ProductListModel productListModel = new ProductListModel();
        productListModel.setImage(R.drawable.androidmobile);
        productListModel.setPrice("Rs 12999");
        productListModel.setProduct_name("Samsung Galaxy M21");
        productListModel.setDiscounted_price("Rs 11500");
        productListModelArrayList.add(productListModel);

        ProductListModel productListModel1 = new ProductListModel();
        productListModel1.setImage(R.drawable.firetvstickamazon);
        productListModel1.setPrice("Rs 3999");
        productListModel1.setProduct_name("Amazon Fire TV Stick");
        productListModel1.setDiscounted_price("Rs 3150");
        productListModelArrayList.add(productListModel1);

        ProductListModel productListModel2 = new ProductListModel();
        productListModel2.setImage(R.drawable.ledtv);
        productListModel2.setPrice("Rs 49000");
        productListModel2.setProduct_name("LG Smart TV 50 Inch");
        productListModel2.setDiscounted_price("Rs 46500");
        productListModelArrayList.add(productListModel2);

        ProductListModel productListModel3 = new ProductListModel();
        productListModel3.setImage(R.drawable.mixergrinder);
        productListModel3.setPrice("Rs 2175");
        productListModel3.setProduct_name("Jaipan Mixer Grinder");
        productListModel3.setDiscounted_price("Rs 1950");
        productListModelArrayList.add(productListModel3);

        recycler_view.setAdapter(customProductHomeListAdapter);

    }
}
