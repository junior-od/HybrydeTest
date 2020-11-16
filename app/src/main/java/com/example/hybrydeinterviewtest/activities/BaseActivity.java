package com.example.hybrydeinterviewtest.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.hybrydeinterviewtest.R;
import com.example.hybrydeinterviewtest.Utils.Utils;
import com.example.hybrydeinterviewtest.interfaces.BaseActivityCallable;

public class BaseActivity extends AppCompatActivity implements BaseActivityCallable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void makeActivityFullScreen() {
        Utils.ViewUtils.makeActivityFullScreen(getWindow());
    }

    @Override
    public void changeStatusBarColorToTransparent() {
        Utils.ViewUtils.changeStatusBarColorToTransparent(getWindow());
    }

    @Override
    public void activateFullScreenActivity() {

        changeStatusBarColorToTransparent();
        makeActivityFullScreen();
        setNavigationBarColor(R.color.colorDarkPurple);
    }

    @Override
    public void setNavigationBarColor(int color) {
        Utils.ViewUtils.setNavigationColorForCompatibleDevices(
               getWindow(),
                this,
                color);
    }

}
