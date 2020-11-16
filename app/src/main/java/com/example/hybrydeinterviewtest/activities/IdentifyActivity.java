package com.example.hybrydeinterviewtest.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.example.hybrydeinterviewtest.R;

public class IdentifyActivity extends BaseActivity implements View.OnClickListener {

    private CardView nationalCardView;
    private CardView passportCardView;

    @NonNull
    public static Intent start(@NonNull Context context) {
        return new Intent(context,  IdentifyActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify);

        activateFullScreenActivity();

        initializeViews();
    }

    private void initializeViews(){

        nationalCardView = findViewById(R.id.nationalCardView);
        passportCardView = findViewById(R.id.passportCardView);

        nationalCardView.setOnClickListener(this);
        passportCardView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.nationalCardView:
            case R.id.passportCardView:
                goToWelcomePage();
                break;
        }
    }

    private void goToWelcomePage(){
        startActivity(WelcomeActivity.start(this));
    }
}
