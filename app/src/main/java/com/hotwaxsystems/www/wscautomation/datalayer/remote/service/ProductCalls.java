package com.hotwaxsystems.www.wscautomation.datalayer.remote.service;

import com.hotwaxsystems.www.wscautomation.datalayer.remote.pojo.Products.ProductsPojo;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by darkshadow on 26/3/18.
 */

public interface ProductCalls {

    @POST("requirements")
    Call<ProductsPojo> getProduct(@Header("Bearer") String token);
}
