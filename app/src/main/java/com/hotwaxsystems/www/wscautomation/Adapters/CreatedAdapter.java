package com.hotwaxsystems.www.wscautomation.Adapters;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hotwaxsystems.www.wscautomation.R;
import com.hotwaxsystems.www.wscautomation.datalayer.remote.pojo.Products.ProductsPojo;
import com.hotwaxsystems.www.wscautomation.datalayer.remote.pojo.Products.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darkshadow on 26/3/18.
 */

public class CreatedAdapter extends RecyclerView.Adapter<CreatedAdapter.MyViewHolder> {

    private Context context;
    private List<Result> productsList;
    public static List<Result> checkedProduct = new ArrayList<>();
    private int check;

    public CreatedAdapter(){}

    public CreatedAdapter(Context context, List<Result> productsList, int check) {
        this.context = context;
        this.productsList = productsList;
        this.check = check;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView productname,quantity,createddate,textviewoptions;
        public CheckBox checkboxproduct;

        public MyViewHolder(View itemView) {
            super(itemView);
            productname = (TextView)itemView.findViewById(R.id.productname);
            quantity = (TextView)itemView.findViewById(R.id.productquantity);
            createddate = (TextView)itemView.findViewById(R.id.createddate);
            textviewoptions = (TextView)itemView.findViewById(R.id.textViewOptions);
            checkboxproduct = (CheckBox)itemView.findViewById(R.id.checkBoxproduct);
        }
    }

    @Override
    public CreatedAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.created_list_item,parent,false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(final CreatedAdapter.MyViewHolder holder, int position) {
        final Result product = productsList.get(position);
        holder.productname.setText(product.getProductName());
        holder.quantity.setText(product.getQuantity());
        holder.createddate.setText(product.getCreatedDate());

        holder.textviewoptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creating a popup menu
                PopupMenu popup = new PopupMenu(context, holder.textviewoptions);
                //inflating menu from xml resource
                popup.inflate(R.menu.option_created);
                popup.setGravity(Gravity.END);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.move_approved:
                                Toast.makeText(context,"Approved Clicked "+product.getProductId(),Toast.LENGTH_LONG).show();
                                break;
                            case R.id.move_completed:
                                Toast.makeText(context,"Completed Clicked "+product.getProductId(),Toast.LENGTH_LONG).show();
                                break;
                        }
                        return false;
                    }
                });
                //displaying the popup
                popup.show();

            }
        });

        holder.checkboxproduct.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkedProduct.add(product);
                    holder.checkboxproduct.setButtonDrawable(R.drawable.ic_check_box_black_24dp);
                }else{
                    checkedProduct.remove(product);
                    holder.checkboxproduct.setButtonDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                }
            }
        });

        if (check == 1){
            LinearLayout.LayoutParams param_productname = new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    3.5f
            );
            param_productname.setMargins(10,10,0,0);
            holder.productname.setLayoutParams(param_productname);

            LinearLayout.LayoutParams param_checkbox = new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    0.5f
            );
            param_checkbox.setMargins(10,10,0,0);

            holder.checkboxproduct.setLayoutParams(param_checkbox);
            holder.checkboxproduct.setVisibility(View.VISIBLE);

        }
        else if (check == 2){
            LinearLayout.LayoutParams param_productname = new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    4.0f
            );
            param_productname.setMargins(8,8,0,0);
            holder.productname.setLayoutParams(param_productname);

            LinearLayout.LayoutParams param_checkbox = new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    0f
            );
            param_checkbox.setMargins(8,8,0,0);

            holder.checkboxproduct.setLayoutParams(param_checkbox);
            holder.checkboxproduct.setVisibility(View.GONE);

        }
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public List<Result> checkedProductItem(){
        return checkedProduct;
    }
}
