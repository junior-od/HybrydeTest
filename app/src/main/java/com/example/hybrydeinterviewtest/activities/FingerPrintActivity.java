package com.example.hybrydeinterviewtest.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hybrydeinterviewtest.R;

public class FingerPrintActivity extends BaseActivity implements View.OnClickListener {

    private TextView skipstep;
    private AppCompatButton continueButton;

    @NonNull
    public static Intent start(@NonNull Context context) {
        return new Intent(context,  FingerPrintActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_print);

        activateFullScreenActivity();

        initializeViews();
    }

    private void initializeViews(){

        skipstep = findViewById(R.id.skipstep);
        continueButton = findViewById(R.id.continueButton);

        skipstep.setOnClickListener(this);
        continueButton.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.skipstep:
            case R.id.continueButton:
                goToIdentifyPage();
                break;
        }
    }

    private void goToIdentifyPage(){
        startActivity(IdentifyActivity.start(this));
    }
}
