//package com.hotwaxsystems.www.wscautomation.viewmodel;


//import android.arch.lifecycle.MediatorLiveData;
//import android.arch.lifecycle.ViewModel;
//
//import com.hotwaxsystems.www.wscautomation.datalayer.remote.pojo.product.ProductDetails;
//
//import javax.inject.Inject;

//public class CurrentLoggingSessionViewModel extends ViewModel {


//    public MediatorLiveData<ProductDetails> countLogResponseLiveData;
//    //private AppDatabase mAppDatabase;
//
//
//    public  MediatorLiveData<List<InventoryCountRegister>> inventoryCountRegisterList;
//
//
//    @Inject
//    public CurrentLoggingSessionViewModel(AppDatabase appDatabase) {
//        countLogResponseLiveData = new MediatorLiveData<>();
//        inventoryCountRegisterList = new MediatorLiveData<>();
//        mAppDatabase = appDatabase;
//
//    }
//
//    public LiveData<List<InventoryCountRegister>> getCountLogList() {
//        return mAppDatabase.inventoryCountLog().getAllCountLogRecords();
//    }
//
//    public void storeRecord(final String productUpc, final String productLocation, final int quantity) {
//        new AsyncTask<Void,Void,Void>() {
//
//            @Override
//            protected Void doInBackground(Void... voids) {
//                mAppDatabase.inventoryCountLog().addRecord(new InventoryCountRegister(productUpc, productLocation, quantity));
//                return null;
//            }
//        }.execute();
//    }
//
//    public void deleteSingleRecord (final String productId, final String locationId, final int quantity) {
//        new AsyncTask<Void,Void,Void>() {
//
//            @Override
//            protected Void doInBackground(Void... voids) {
//                mAppDatabase.inventoryCountLog().deleteRecord(new InventoryCountRegister(productId,locationId,quantity));
//                return null;
//            }
//        }.execute();
//    }
//
//    public void clearCountRecords() {
//        new AsyncTask<Void,Void,Void>() {
//
//            @Override
//            protected Void doInBackground(Void... voids) {
//                mAppDatabase.inventoryCountLog().deleteRecords();
//                return null;
//            }
//        }.execute();
//    }
//}
