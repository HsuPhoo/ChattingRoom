package com.example.mizuki.chatroomapplication.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mizuki.chatroomapplication.data.model.AppModel;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    private AppModel mAppModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        if(getActionBar() != null ){
            getActionBar().setDisplayHomeAsUpEnabled(setDisplayHomeEnabled());
        }
        ButterKnife.bind(this,this);

        mAppModel = ViewModelProviders.of(this).get(AppModel.class);
    }

    protected abstract boolean setDisplayHomeEnabled();

    public abstract int getLayout();

    public AppModel getmAppModel() {
        return mAppModel;
    }
}
