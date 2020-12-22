package com.tolstobrov.salary.services.impl;

import android.content.Context;

import com.tolstobrov.salary.services.NetworkService;

public class NetworkServiceImpl implements NetworkService {

    private Context context;

    public NetworkServiceImpl(Context context) {
        this.context = context;
    }

    @Override
    public String getHello() {
        return context.getClass().getSimpleName();
    }
}
