//package com.hotwaxsystems.www.wscautomation.di.builder;
//
//
//import com.hotwaxsystems.www.wscautomation.view.BalanceFragment;
//import com.hotwaxsystems.www.wscautomation.view.DashboardFragment;
//import com.hotwaxsystems.www.wscautomation.view.DrawerActivity;
//import com.hotwaxsystems.www.wscautomation.view.OrganizationFragment;
//import com.hotwaxsystems.www.wscautomation.view.PaymentsFragment;
//import com.hotwaxsystems.www.wscautomation.view.ProductsFragment;
//import com.hotwaxsystems.www.wscautomation.view.PromotionsFragment;
//import com.hotwaxsystems.www.wscautomation.di.module.AppModule;
//
//import dagger.Module;
//import dagger.android.ContributesAndroidInjector;
//
//
//@Module
//public abstract class ActivityBuilder {
//
//    @ContributesAndroidInjector
//    abstract DrawerActivity bindDrawerActivity();
//
//    @ContributesAndroidInjector(modules = {AppModule.class})
//    abstract BalanceFragment bindBalanceFragment();
//
//    @ContributesAndroidInjector(modules = {AppModule.class})
//    abstract DashboardFragment bindDashboardFragment();
//
//    @ContributesAndroidInjector(modules = {AppModule.class})
//    abstract OrganizationFragment bindOrganizationFragment();
//
//    @ContributesAndroidInjector(modules = {AppModule.class})
//    abstract PaymentsFragment bindPaymentsFragment();
//
//    @ContributesAndroidInjector(modules = {AppModule.class})
//    abstract ProductsFragment bindProductsFragment();
//
//    @ContributesAndroidInjector(modules = {AppModule.class})
//    abstract PromotionsFragment bindPromotionsFragment();
//
//}
