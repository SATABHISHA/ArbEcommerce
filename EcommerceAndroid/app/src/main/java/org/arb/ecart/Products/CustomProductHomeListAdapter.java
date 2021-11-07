package org.arb.ecart.Products;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.arb.ecart.Model.ProductListModel;
import org.arb.ecart.R;

import java.util.ArrayList;

public class CustomProductHomeListAdapter extends RecyclerView.Adapter<CustomProductHomeListAdapter.MyViewHolder> {
    public LayoutInflater inflater;
    public static ArrayList<ProductListModel> productListModelArrayList;
    private Context context;
    public static String od_request_id = "";
//    UserSingletonModel userSingletonModel = UserSingletonModel.getInstance();

//    public static ProgressDialog loading;
//    public static TextView tv_download;


    public CustomProductHomeListAdapter(Context ctx, ArrayList<ProductListModel> productListModelArrayList){

        inflater = LayoutInflater.from(ctx);
        this.productListModelArrayList = productListModelArrayList;
    }
    @Override
    public CustomProductHomeListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_product_home_list, parent, false);
        CustomProductHomeListAdapter.MyViewHolder holder = new CustomProductHomeListAdapter.MyViewHolder(view);
        context = parent.getContext();
        return holder;
    }

    @Override
    public void onBindViewHolder(CustomProductHomeListAdapter.MyViewHolder holder, int position) {
        holder.itemView.setTag(productListModelArrayList.get(position));
        holder.product_image.setBackgroundResource(productListModelArrayList.get(position).getImage());
//        holder.product_image.setImageDrawable(productListModelArrayList.get(position).getImage());
        holder.price.setText(productListModelArrayList.get(position).getPrice());


    }

    @Override
    public int getItemCount() {
        return productListModelArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView price;
        ImageView product_image;
        RelativeLayout relative_layout;



        public MyViewHolder(final View itemView) {
            super(itemView);
            product_image = itemView.findViewById(R.id.image);
            price = itemView.findViewById(R.id.price);
            relative_layout = itemView.findViewById(R.id.relativeLayout);

            relative_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final int position = getAdapterPosition();

//                    od_request_id = outDoorListModelArrayList.get(position).getOd_request_id();
                    Intent i = new Intent(context, ProductDetailsActivity.class);
                    context.startActivity(i);
                }
            });


        }


    }



}
