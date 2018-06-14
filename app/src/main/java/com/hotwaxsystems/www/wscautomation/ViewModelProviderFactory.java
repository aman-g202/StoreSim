//package com.hotwaxsystems.www.wscautomation;
//
//import android.arch.lifecycle.ViewModel;
//import android.arch.lifecycle.ViewModelProvider;
//
//import javax.inject.Inject;
//
//public class ViewModelProviderFactory<V> implements ViewModelProvider.Factory {
//
//    private V viewModel;
//
//    @Inject
//    public ViewModelProviderFactory(V viewModel) {
//        this.viewModel = viewModel;
//    }
//
//    @Override
//    public <T extends ViewModel> T create(Class<T> modelClass) {
//        if (modelClass.isAssignableFrom(viewModel.getClass())) {
//            return (T) viewModel;
//        }
//        throw new IllegalArgumentException("Unknown class name");
//    }
//
//}
