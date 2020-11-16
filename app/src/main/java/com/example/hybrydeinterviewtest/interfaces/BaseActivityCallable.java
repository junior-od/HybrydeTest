package com.example.hybrydeinterviewtest.interfaces;

import androidx.annotation.DrawableRes;

public interface BaseActivityCallable {

    void makeActivityFullScreen();

    void changeStatusBarColorToTransparent();

    void activateFullScreenActivity();

    void setNavigationBarColor(@DrawableRes int color);

}
