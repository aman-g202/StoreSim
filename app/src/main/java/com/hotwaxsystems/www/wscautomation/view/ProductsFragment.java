package com.hotwaxsystems.www.wscautomation.view;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hotwaxsystems.www.wscautomation.Adapters.CreatedAdapter;
import com.hotwaxsystems.www.wscautomation.R;
import com.hotwaxsystems.www.wscautomation.Utils.MyDividerItemDecoration;
import com.hotwaxsystems.www.wscautomation.Utils.RecyclerTouchListener;
import com.hotwaxsystems.www.wscautomation.Utils.SharedPrefUtil;
import com.hotwaxsystems.www.wscautomation.datalayer.remote.pojo.Products.ProductsPojo;
import com.hotwaxsystems.www.wscautomation.datalayer.remote.pojo.Products.Result;
import com.hotwaxsystems.www.wscautomation.datalayer.remote.pojo.utilities.Login;
import com.hotwaxsystems.www.wscautomation.datalayer.remote.pojo.utilities.LoginPojo;
import com.hotwaxsystems.www.wscautomation.datalayer.remote.service.LoginCalls;
import com.hotwaxsystems.www.wscautomation.datalayer.remote.service.ProductCalls;
import com.hotwaxsystems.www.wscautomation.di.Component.DaggerRetrofitComponent;
import com.hotwaxsystems.www.wscautomation.di.Component.RetrofitComponent;
import com.hotwaxsystems.www.wscautomation.di.module.ApiModule;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import dagger.android.DaggerActivity;
import dagger.android.DaggerFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.view.View.VISIBLE;


public class ProductsFragment extends Fragment {

    private Context mContext;
    private RecyclerView createdProductsRecycler;
    private ImageView expand,removecheckbox,senditem;
    private TextView approved, completed,proposed;
    private CardView createdCardView;
    private CreatedAdapter createdAdapter;
    Integer temp = 0, tempapproved = 0, tempcompleted = 0 ;
    private Retrofit retrofit;
    SharedPrefUtil sharedPrefUtil = null;
    private List<Result> productList = new ArrayList<>();

    public ProductsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.fragment_products, container, false);

        mContext = getActivity();
        ((DrawerActivity)mContext).setAppBarTitle("Products");

        expand = (ImageView)view.findViewById(R.id.expand);
        removecheckbox = (ImageView)view.findViewById(R.id.removecheckbox);
        senditem = (ImageView)view.findViewById(R.id.senditem);
        proposed = (TextView)view.findViewById(R.id.proposed);
        createdCardView = (CardView)view.findViewById(R.id.createdCardView);
//        expandapproved = (ImageView)view.findViewById(R.id.expandapproved);
//        expandcompleted = (ImageView)view.findViewById(R.id.expandcompleted);
//        created = (TextView)view.findViewById(R.id.createdtextview);
//        approved = (TextView)view.findViewById(R.id.approvedtextview);
//        completed = (TextView)view.findViewById(R.id.completedtextview);

        createdProductsRecycler = (RecyclerView)view.findViewById(R.id.recycler_view_created);
        createdAdapter = new CreatedAdapter(mContext,productList,0);

        sharedPrefUtil = new SharedPrefUtil(mContext);

        RetrofitComponent component = DaggerRetrofitComponent.builder().apiModule(new ApiModule("https://hc-india.hotwax.co/api/")).build();
        retrofit = component.provideRetrofit();

        LoginCalls service = retrofit.create(LoginCalls.class);
        Call<LoginPojo> loginCall = service.getAuthenticationToken("admin","hotwax@786");
        loginCall.enqueue(new Callback<LoginPojo>() {
            @Override
            public void onResponse(Call<LoginPojo> call, Response<LoginPojo> response) {
                if (response.isSuccessful() && response.body() != null){
                    if(response.body().getToken() != null){
//                        Toast.makeText(getActivity(),response.body().getToken(),Toast.LENGTH_LONG).show();
                        sharedPrefUtil.createLoginToken("token",response.body().getToken());
                        sharedPrefUtil.createLoginSessonId("jsessionid",response.body().getSessionId());
                    }
                    else{
                        Toast.makeText(getActivity(),"Some Error on the Server Side",Toast.LENGTH_LONG).show();
                    }

                }
                else{
                    Toast.makeText(getActivity(),"Error Occured",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginPojo> call, Throwable t) {
                if(t.getMessage() != null) {
                    Toast.makeText(mContext, t.getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "Login Failed, Please check Username and Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        createdProductsRecycler.setLayoutManager(mLayoutManager);
        createdProductsRecycler.setItemAnimator(new DefaultItemAnimator());
        createdProductsRecycler.addItemDecoration(new MyDividerItemDecoration(getActivity(),LinearLayoutManager.VERTICAL,16));


        createdProductsRecycler.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), createdProductsRecycler, new ProductsFragment.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

                createdAdapter = new CreatedAdapter(mContext,productList,1);
                createdProductsRecycler.setAdapter(createdAdapter);

                LinearLayout.LayoutParams param_proposed = new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        3.1f
                );
                param_proposed.gravity = Gravity.CENTER_VERTICAL;
                param_proposed.setMargins(10,0,0,0);
                proposed.setLayoutParams(param_proposed);

                LinearLayout.LayoutParams param_removecheckbox = new LinearLayout.LayoutParams(
                        0,
                        60,
                        0.5f
                );

                removecheckbox.setLayoutParams(param_removecheckbox);
                removecheckbox.setVisibility(VISIBLE);

                LinearLayout.LayoutParams param_senditem = new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        0.7f
                );

                senditem.setLayoutParams(param_senditem);
                senditem.setVisibility(VISIBLE);
//                productname.setLayoutParams(param);

            }
        }));


        ProductCalls productservice = retrofit.create(ProductCalls.class);
        Call<ProductsPojo> productPojo = productservice.getProduct(sharedPrefUtil.retrieveLoginToken("token",null));
        productPojo.enqueue(new Callback<ProductsPojo>() {
            @Override
            public void onResponse(Call<ProductsPojo> call, Response<ProductsPojo> response) {
                if (response.isSuccessful() && response.body() != null){

                    List<Result> productResult;
                    productResult = response.body().getResult();
                    for (int i=0; i<productResult.size();i++){
                        Result singleProduct = productResult.get(i);
                        if (singleProduct.getStatusId().equals("REQ_CREATED")){
//                            Toast.makeText(getActivity(),singleProduct.getProductName(),Toast.LENGTH_LONG).show();
                            productList.add(singleProduct);
                        }
                    }

                    createdAdapter = new CreatedAdapter(mContext,productList,0);
                    createdProductsRecycler.setAdapter(createdAdapter);

                }
                else{
                    Toast.makeText(getActivity(),"Some Error on the Server Side",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ProductsPojo> call, Throwable t) {
                if(t.getMessage() != null) {
                    Toast.makeText(mContext, t.getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "Login Failed, Please check Username and Password", Toast.LENGTH_SHORT).show();
                }
            }
        });


//        approved.setText("ajkdhfejrgiewhrgieruhgregreg\nhugheiuhgeughreuyr" +
//                "gwhergbouw\nergbjahdbrgherhjgbhjegb\nsjhrbghberhjgbgshgef" +
//                "sehrgbe\neghfvvhfvehrgfvefvbehgvf\nsegrvfhevfrehgfvrrgtf" +
//                "ashdfahsdbfabfhawebfhawebrhfbaeihrgfb\nhebgfbqehrgfhqer" +
//                "whegihgfqhegfqhegbrhfbhayergbfajhr" +
//                "qwehrgfhqagfqr\nqherhbfhqegbrhjbfjhbwerfhbew" +
//                "qwehrgfbrehjgfbjhergbjehrgfbrehf" +
//                "rgfergehrgbqejhrgbherg" +
//                "gkehrgbjeqhrhfbhkerg\nwehgrvghewrvhvhwergvtgjvwetg" +
//                "welhrgbhergberryhgfbqhegf\nwjhebgggggggggggggb");
//
//        completed.setText("ajkdhfejrgiewhrgieruhgregreg\nhugheiuhgeughreuyr" +
//                "gwhergbouw\nergbjahdbrgherhjgbhjegb\nsjhrbghberhjgbgshgef" +
//                "sehrgbe\neghfvvhfvehrgfvefvbehgvf\nsegrvfhevfrehgfvrrgtf" +
//                "ashdfahsdbfabfhawebfhawebrhfbaeihrgfb\nhebgfbqehrgfhqer" +
//                "whegihgfqhegfqhegbrhfbhayergbfajhr" +
//                "qwehrgfhqagfqr\nqherhbfhqegbrhjbfjhbwerfhbew" +
//                "qwehrgfbrehjgfbjhergbjehrgfbrehf" +
//                "rgfergehrgbqejhrgbherg" +
//                "gkehrgbjeqhrhfbhkerg\nwehgrvghewrvhvhwergvtgjvwetg" +
//                "welhrgbhergberryhgfbqhegf\nwjhebgggggggggggggb");

        createdProductsRecycler.setVisibility(View.GONE);
//        approved.setVisibility(View.GONE);
//        completed.setVisibility(View.GONE);

        expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                if (temp == 0){
                    createdProductsRecycler.setVisibility(VISIBLE);
                    expand.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                    temp = 1;
                }
                else if (temp == 1){
                    createdProductsRecycler.setVisibility(View.GONE);
                    expand.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    temp = 0;
                }

            }
        });

        createdCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (temp == 0){
                    createdProductsRecycler.setVisibility(VISIBLE);
                    expand.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                    temp = 1;
                }
                else if (temp == 1){
                    createdProductsRecycler.setVisibility(View.GONE);
                    expand.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    temp = 0;
                }

            }
        });

        removecheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createdAdapter = new CreatedAdapter(mContext,productList,2);
                createdProductsRecycler.setAdapter(createdAdapter);

                LinearLayout.LayoutParams param_proposed = new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        4.3f
                );
                param_proposed.gravity = Gravity.CENTER_VERTICAL;
                param_proposed.setMargins(8,0,0,0);
                proposed.setLayoutParams(param_proposed);

                LinearLayout.LayoutParams param_removecheckbox = new LinearLayout.LayoutParams(
                        0,
                        0,
                        0f
                );

                removecheckbox.setLayoutParams(param_removecheckbox);
                removecheckbox.setVisibility(View.GONE);

                LinearLayout.LayoutParams param_senditem = new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        0f
                );

                senditem.setLayoutParams(param_senditem);
                senditem.setVisibility(View.GONE);

            }
        });

        senditem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext,"send Clicked",Toast.LENGTH_SHORT).show();
                CreatedAdapter checkProduct = new CreatedAdapter();
                List<Result> checkedItem = checkProduct.checkedProductItem();
                if (checkedItem.size() == 0){
                    Toast.makeText(mContext,"Kindly click on check boxes to move products",Toast.LENGTH_SHORT).show();
                }
                else {
                    String productids = "";
                    for(Result item : checkedItem){
                        productids += item.getProductId()+" - ";
                    }
                    Toast.makeText(mContext,productids,Toast.LENGTH_SHORT).show();
                }

            }
        });

//        expandapproved.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (tempapproved == 0){
//                    approved.setVisibility(VISIBLE);
//                    expandapproved.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
//                    tempapproved = 1;
//                }
//                else if (tempapproved == 1){
//                    approved.setVisibility(View.GONE);
//                    expandapproved.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
//                    tempapproved = 0;
//                }
//
//            }
//        });
//
//        expandcompleted.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (tempcompleted == 0){
//                    completed.setVisibility(VISIBLE);
//                    expandcompleted.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
//                    tempcompleted = 1;
//                }
//                else if (tempcompleted == 1){
//                    completed.setVisibility(View.GONE);
//                    expandcompleted.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
//                    tempcompleted = 0;
//                }
//
//            }
//        });

        return view;
    }

    public interface ClickListener {
        void onClick(View child, int childPosition);

        void onLongClick(View child, int childPosition);
    }
}
