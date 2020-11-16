package com.example.hybrydeinterviewtest.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.hybrydeinterviewtest.R;
import com.rilixtech.widget.countrycodepicker.CountryCodePicker;

import java.util.Objects;

public class RegistrationActivity extends BaseActivity implements View.OnClickListener {

    private CountryCodePicker countryCodePicker;
    private AppCompatEditText phoneEditTextView;

    @NonNull
    public static Intent start(@NonNull Context context) {
        return new Intent(context, RegistrationActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        activateFullScreenActivity();

        initializeViews();

    }

    private void initializeViews(){
        countryCodePicker = findViewById(R.id.countryCodePicker);
        phoneEditTextView = findViewById(R.id.phoneEditTextView);
        AppCompatButton getCodeButton = findViewById(R.id.getCodeButton);

        getCodeButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.getCodeButton) {
            getVerificationCode();
        }
    }

    private void getVerificationCode(){

        String phoneNumber = String.format("(%s) %s", countryCodePicker.getSelectedCountryCodeWithPlus(),
                Objects.requireNonNull(phoneEditTextView.getText()).toString().trim());

        startActivity(VerificationActivity.start(this,phoneNumber));

    }
}
