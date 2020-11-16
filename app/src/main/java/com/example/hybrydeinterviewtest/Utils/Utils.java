package com.example.hybrydeinterviewtest.Utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

public class Utils {

    public static class ViewUtils {

        private ViewUtils() {
        }

        public static void hideKeyboard(@NonNull Activity activity) {

            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            View f = activity.getCurrentFocus();
            if (null != f && null != f.getWindowToken() && EditText.class.isAssignableFrom(f.getClass())) {
                if (imm != null) {
                    imm.hideSoftInputFromWindow(f.getWindowToken(), 0);
                }
            } else
                activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        }

        public static void changeStatusBarColorToTransparent(@NonNull Window window) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            }
        }

        public static void setNavigationColorForCompatibleDevices(Window window, Context context, int color) {
            // change the color of the navigation bar for android version >= 21 (Lollipop)
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                window.setNavigationBarColor(ContextCompat.getColor(context, color));

            }
        }

        public static void makeActivityFullScreen(Window window) {

            if (Build.VERSION.SDK_INT >= 21) {
                window.getDecorView()
                        .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            }

        }
    }
}
