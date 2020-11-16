package com.example.hybrydeinterviewtest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.hybrydeinterviewtest.R;

public class OnboardingSliderAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;

    private int[] sliderImages = {
            R.drawable.onboarding_icon,
            R.drawable.onboarding_icon,
            R.drawable.onboarding_icon
    };

    private String[] sliderHeadings = {
            "Let's Get Started",
            "Let's Get Started",
            "Let's Get Started"
    };

    private String[] sliderBodys = {
            "Join Us Now And Enjoy Free\n Credit Free Shipping\n Instantly",
            "Join Us Now And Enjoy Free\n Credit Free Shipping\n Instantly",
            "Join Us Now And Enjoy Free\n Credit Free Shipping\n Instantly"
    };

    public OnboardingSliderAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return sliderHeadings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.onboarding_slider_layout,container,false);
        ImageView sliderImage = view.findViewById(R.id.image);
        TextView sliderHeader = view.findViewById(R.id.sliderHeader);
        TextView sliderBody = view.findViewById(R.id.sliderBody);


        sliderImage.setImageResource(sliderImages[position]);
        sliderHeader.setText(sliderHeadings[position]);
        sliderBody.setText(sliderBodys[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }


}
