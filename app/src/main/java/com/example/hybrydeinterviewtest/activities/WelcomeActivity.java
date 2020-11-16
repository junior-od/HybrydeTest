package com.example.hybrydeinterviewtest.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.hybrydeinterviewtest.R;

public class WelcomeActivity extends BaseActivity {

    @NonNull
    public static Intent start(@NonNull Context context) {
        return new Intent(context,  WelcomeActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        activateFullScreenActivity();


    }
}
