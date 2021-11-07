package org.arb.ecart.Products;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.arb.ecart.Model.BannerListModel;
import org.arb.ecart.Model.ProductListModel;
import org.arb.ecart.R;

import java.util.ArrayList;

public class CustomProductHomeBannerListAdapter extends RecyclerView.Adapter<CustomProductHomeBannerListAdapter.MyViewHolder> {
    public LayoutInflater inflater;
    public static ArrayList<BannerListModel> bannerListModelArrayList;
    private Context context;
    public static String od_request_id = "";
//    UserSingletonModel userSingletonModel = UserSingletonModel.getInstance();

//    public static ProgressDialog loading;
//    public static TextView tv_download;


    public CustomProductHomeBannerListAdapter(Context ctx, ArrayList<BannerListModel> bannerListModelArrayList){

        inflater = LayoutInflater.from(ctx);
        this.bannerListModelArrayList = bannerListModelArrayList;
    }
    @Override
    public CustomProductHomeBannerListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_product_home_banner_list, parent, false);
        CustomProductHomeBannerListAdapter.MyViewHolder holder = new CustomProductHomeBannerListAdapter.MyViewHolder(view);
        context = parent.getContext();
        return holder;
    }

    @Override
    public void onBindViewHolder(CustomProductHomeBannerListAdapter.MyViewHolder holder, int position) {
        holder.itemView.setTag(bannerListModelArrayList.get(position));
        holder.image.setBackgroundResource(bannerListModelArrayList.get(position).getImage());
//        holder.product_image.setImageDrawable(bannerListModelArrayList.get(position).getImage());
        holder.tv_name.setText(bannerListModelArrayList.get(position).getTv_name());


    }

    @Override
    public int getItemCount() {
        return bannerListModelArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_name;
        ImageView image;



        public MyViewHolder(final View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            tv_name = itemView.findViewById(R.id.tv_name);




        }


    }



}