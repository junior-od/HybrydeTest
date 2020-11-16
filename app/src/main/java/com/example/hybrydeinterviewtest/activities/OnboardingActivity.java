package com.example.hybrydeinterviewtest.activities;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;

import com.example.hybrydeinterviewtest.R;
import com.example.hybrydeinterviewtest.adapters.OnboardingSliderAdapter;

import java.util.Timer;
import java.util.TimerTask;

public class OnboardingActivity extends BaseActivity implements View.OnClickListener {

    private static final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    private static final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.
    private Handler handler;
    private OnboardingSliderAdapter onboardingSliderAdapter;
    private int currentPageIndex = 0;
    //views
    private ViewPager viewPager;
    private LinearLayout dotsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        activateFullScreenActivity();

        initializeViews();
        configureTimer();

    }

    //view pager listener
    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            currentPageIndex = position;
            addDotsIndicator(currentPageIndex);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private void addDotsIndicator(int position) {
        ImageView[] rectangleDots = new ImageView[3];
        dotsLayout.removeAllViews();
        for (int i = 0; i < rectangleDots.length; i++) {

            rectangleDots[i] = new ImageView(this);
            rectangleDots[i].setImageResource(R.drawable.inactive_bullet);
            rectangleDots[i].setPadding(5, 0, 5, 0);
            dotsLayout.addView(rectangleDots[i]);
        }


        rectangleDots[position].setImageResource(R.drawable.active_bullet);

    }

    private void configureTimer() {
        /*After setting the adapter use the timer */
        handler = new Handler();
        final Runnable update = () -> {
            if (currentPageIndex == onboardingSliderAdapter.getCount()) {
                currentPageIndex = 0;
            }
            viewPager.setCurrentItem(currentPageIndex++, true);
        };

        //set timer
        Timer timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(update);
            }
        }, DELAY_MS, PERIOD_MS);
    }

    private void initializeViews(){
        onboardingSliderAdapter = new OnboardingSliderAdapter(this);
        viewPager = findViewById(R.id.onBoardViewPager);
        dotsLayout = findViewById(R.id.onBoardBottomLinearLayout);
        AppCompatButton createAccountButton = findViewById(R.id.createAccountButton);
        AppCompatButton loginButton = findViewById(R.id.loginButton);

        createAccountButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);

        //set adapter in view pager
        viewPager.setAdapter(onboardingSliderAdapter);

        addDotsIndicator(currentPageIndex);
        viewPager.addOnPageChangeListener(pageChangeListener);

    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.createAccountButton:
                goToRegistrationPage();
                break;

            case R.id.loginButton:

                break;
        }
    }

    private void goToRegistrationPage(){
        startActivity(RegistrationActivity.start(this));
    }
}
