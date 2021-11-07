package org.arb.ecart.Products;

import android.os.Bundle;
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

import org.arb.ecart.Model.ProductListModel;
import org.arb.ecart.R;

import java.util.ArrayList;

public class ProductDetailsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    AlertDialog.Builder builder;
    CoordinatorLayout coordinatorLayout;
    TextView tv_nodata;
    RecyclerView recycler_view;
    public static CustomProductDetailsAdapter customProductDetailsAdapter;
    ArrayList<ProductListModel> productListModelArrayList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        //--------------------NAVIGATION DRAWER PORTIONS--------------------------//
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //---------------------------------------To change Navigation drawer icon
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menublack);

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

        customProductDetailsAdapter = new CustomProductDetailsAdapter(this,productListModelArrayList);

//        ll_recycler = findViewById(R.id.ll_recycler);
        tv_nodata = findViewById(R.id.tv_nodata);

        //==========Recycler code initializing and setting layoutManager starts======
        recycler_view = findViewById(R.id.recycler_view);
       /* recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));*/
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,RecyclerView.HORIZONTAL,false);
//        gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_view.setLayoutManager(gridLayoutManager);
        //==========Recycler code initializing and setting layoutManager ends======

        LoadData();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    public void LoadData(){
        ProductListModel productListModel = new ProductListModel();
        productListModel.setImage(R.drawable.oppo);
        productListModel.setPrice("Rs 8000");
        productListModelArrayList.add(productListModel);

        ProductListModel productListModel1 = new ProductListModel();
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
        productListModelArrayList.add(productListModel3);

        recycler_view.setAdapter(customProductDetailsAdapter);

    }
}
