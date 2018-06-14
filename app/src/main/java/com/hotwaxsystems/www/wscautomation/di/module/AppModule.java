//package com.hotwaxsystems.www.wscautomation.di.module;
//
//import android.app.Application;
//import android.arch.lifecycle.ViewModelProvider;
//
//import com.hotwaxsystems.www.wscautomation.ViewModelProviderFactory;
//import com.hotwaxsystems.www.wscautomation.viewmodel.CurrentLoggingSessionViewModel;
//
//import javax.inject.Named;
//import javax.inject.Singleton;
//
//import dagger.Module;
//import dagger.Provides;
//
//@Module
//public class AppModule {
//
//    private Application mApplication;
//
//    public AppModule(Application mApplication) {
//        this.mApplication = mApplication;
//    }
//
//    @Provides
//    @Named("ViewModel")
//    ViewModelProvider.Factory viewModelProvider(CurrentLoggingSessionViewModel currentLoggingSessionViewModel) {
//        return new ViewModelProviderFactory<>(currentLoggingSessionViewModel);
//    }
//
//    @Provides
//    @Singleton
//    Application provideApplication() {
//        return mApplication;
//    }
//
//}
//
//
