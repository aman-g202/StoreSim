//package com.hotwaxsystems.www.wscautomation;
//
//
//import android.app.Activity;
//import android.app.Application;
//
//import com.hotwaxsystems.www.wscautomation.di.module.ApiModule;
//import com.hotwaxsystems.www.wscautomation.di.module.AppModule;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.inject.Inject;
//
//import dagger.android.DispatchingAndroidInjector;
//import dagger.android.HasActivityInjector;


//public class WSCAutomationApp extends Application implements HasActivityInjector {

//    private ApiComponent mApiComponent;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//        mApiComponent = DaggerApiComponent.builder()
//                .appModule(new AppModule(this))
//                .apiModule(new ApiModule("https://simplifiedcoding.net/demos/"))
//                .build();
//    }
//
//    public ApiComponent getNetComponent() {
//        return mApiComponent;
//    }
//
//    @Inject
//    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;
//    public Map<String,Object> previousActivity = new HashMap<>();
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        DaggerAppComponent.builder()
//                .application(this)
//                .appModule(new AppModule(this))
//                .apiModule(new ApiModule("https://simplifiedcoding.net/demos/"))
//                .build()
//                .inject(this);
//    }
//
//    @Override
//    public DispatchingAndroidInjector<Activity> activityInjector() {
//        return activityDispatchingAndroidInjector;
//    }
//}
