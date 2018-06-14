package com.hotwaxsystems.www.wscautomation.di.Component;

import com.hotwaxsystems.www.wscautomation.di.module.ApiModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by darkshadow on 24/3/18.
 */

@Singleton
@Component(modules = {ApiModule.class})
public interface RetrofitComponent {
    Retrofit provideRetrofit();
}
