package com.hotwaxsystems.www.wscautomation.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hotwaxsystems.www.wscautomation.R;


public class PaymentsFragment extends Fragment {

    public PaymentsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_payments, container, false);
    }
}
