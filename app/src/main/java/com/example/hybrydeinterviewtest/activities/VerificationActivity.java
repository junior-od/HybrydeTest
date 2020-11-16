package com.example.hybrydeinterviewtest.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hybrydeinterviewtest.R;

public class VerificationActivity extends BaseActivity implements View.OnClickListener {
    public static final String PHONE_NUMBER = "PHONE_NUMBER";

    private TextView sliderBody;
    private AppCompatButton verifyButton;

    String getPhoneNumber;


    @NonNull
    public static Intent start(@NonNull Context context, @NonNull String phoneNumber) {
        return new Intent(context,  VerificationActivity.class)
                .putExtra(PHONE_NUMBER,phoneNumber);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        activateFullScreenActivity();

        initializeViews();
    }

    @SuppressLint("DefaultLocale")
    private void initializeViews(){

        sliderBody = findViewById(R.id.sliderBody);
        verifyButton = findViewById(R.id.verifyButton);

        verifyButton.setOnClickListener(this);

        getPhoneNumber = getIntent().getStringExtra(PHONE_NUMBER);

        sliderBody.setText(String.format("%s %s", getString(R.string.enter_a_4_digit_number_that_n_was_sent_to), getPhoneNumber));

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.verifyButton){
            goToFingerPrintPage();

        }
    }

    private void goToFingerPrintPage(){
        startActivity(FingerPrintActivity.start(this));
    }
}
