package com.example.testtabslay;

import android.annotation.SuppressLint;

import androidx.viewpager2.widget.ViewPager2;


import com.example.testtabslay.transformers.AntiClockSpinTransformation;
import com.example.testtabslay.transformers.ClockSpinTransformation;
import com.example.testtabslay.transformers.CubeInDepthTransformation;
import com.example.testtabslay.transformers.CubeInRotationTransformation;
import com.example.testtabslay.transformers.CubeOutDepthTransformation;
import com.example.testtabslay.transformers.CubeOutRotationTransformation;
import com.example.testtabslay.transformers.CubeOutScalingTransformation;
import com.example.testtabslay.transformers.DepthPageTransformer;
import com.example.testtabslay.transformers.DepthTransformation;
import com.example.testtabslay.transformers.FadeOutTransformation;
import com.example.testtabslay.transformers.FanTransformation;
import com.example.testtabslay.transformers.GateTransformation;
import com.example.testtabslay.transformers.HingeTransformation;
import com.example.testtabslay.transformers.VerticalFlipTransformation;
import com.example.testtabslay.transformers.PopTransformation;
import com.example.testtabslay.transformers.SimpleTransformation;
import com.example.testtabslay.transformers.SpinnerTransformation;
import com.example.testtabslay.transformers.TossTransformation;
import com.example.testtabslay.transformers.HorizontalFlipTransformation;
import com.example.testtabslay.transformers.VerticalShutTransformation;
import com.example.testtabslay.transformers.ZoomOutPageTransformer;

public class Utils {
    @SuppressLint("NewApi")
    public static ViewPager2.PageTransformer getTransformer(int id) {
        switch (id) {
            case R.id.action_anti_clock_spin:
                return new AntiClockSpinTransformation();
            case R.id.action_clock_spin:
                return new ClockSpinTransformation();
            case R.id.action_cube_in_depth:
                return new CubeInDepthTransformation();
            case R.id.action_cube_in_rotate:
                return new CubeInRotationTransformation();
            case R.id.action_cube_out_depth:
                return new CubeOutDepthTransformation();
            case R.id.action_cube_out_rotate:
                return new CubeOutRotationTransformation();
            case R.id.action_cube_out_scaling:
                return new CubeOutScalingTransformation();
            case R.id.action_depth_page:
                return new DepthPageTransformer();
            case R.id.action_depth:
                return new DepthTransformation();
            case R.id.action_fade_out:
                return new FadeOutTransformation();
            case R.id.action_fan:
                return new FanTransformation();
            case R.id.action_gate:
                return new GateTransformation();
            case R.id.action_hinge:
                return new HingeTransformation();
            case R.id.action_horizontal_flip:
                return new VerticalFlipTransformation();
            case R.id.action_pop:
                return new PopTransformation();
            case R.id.action_simple_transformation:
                return new SimpleTransformation();
            case R.id.action_spinner:
                return new SpinnerTransformation();
            case R.id.action_toss:
                return new TossTransformation();
            case R.id.action_vertical_flip:
                return new HorizontalFlipTransformation();
            case R.id.action_vertical_shut:
                return new VerticalShutTransformation();
            case R.id.action_zoom_out:
                return new ZoomOutPageTransformer();
        }

        return null;
    }
}
