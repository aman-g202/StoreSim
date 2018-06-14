package com.hotwaxsystems.www.wscautomation.datalayer.remote.service;

import com.hotwaxsystems.www.wscautomation.datalayer.remote.pojo.utilities.Login;
import com.hotwaxsystems.www.wscautomation.datalayer.remote.pojo.utilities.LoginPojo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginCalls {

    @FormUrlEncoded
    @POST("getAuthenticationToken")
    Call<LoginPojo> getAuthenticationToken(@Field("USERNAME") String username, @Field("PASSWORD") String password);

}
