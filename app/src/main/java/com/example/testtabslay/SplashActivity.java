package com.example.testtabslay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.MenuInflater;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testtabslay.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {
    private ViewsSliderAdapter mAdapter;
    private TextView[] dots;
    private int[] layouts;
    private ActivitySplashBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
       // timerStart();
    }

    private void init() {
        // layouts of all welcome sliders
        // add few more layouts if you want
        layouts = new int[]{
                R.layout.slide_one,
                R.layout.slide_two,
                R.layout.slide_three,
                R.layout.slide_four};

        mAdapter = new ViewsSliderAdapter();
        binding.viewPager.setAdapter(mAdapter);
        binding.viewPager.registerOnPageChangeCallback(pageChangeCallback);

        binding.btnSkip.setOnClickListener(v -> launchHomeScreen());

        binding.btnNext.setOnClickListener(v -> {
            // checking for last page
            // if last page home screen will be launched
            int current = getItem(+1);
            if (current < layouts.length) {
                // move to next screen
                binding.viewPager.setCurrentItem(current);
            } else {
                launchHomeScreen();
            }
        });

        binding.iconMore.setOnClickListener(view -> {
            showMenu(view);
        });

        // adding bottom dots
        addBottomDots(0);
    }

    /*
     * Adds bottom dots indicator
     * */
    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        binding.layoutDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            binding.layoutDots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    private int getItem(int i) {
        return binding.viewPager.getCurrentItem() + i;
    }

    private void launchHomeScreen() {
        Toast.makeText(this, R.string.slides_ended, Toast.LENGTH_LONG).show();
        timerStart();
        //finish();
    }

    private void showMenu(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.pager_transformers, popup.getMenu());
        popup.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.action_orientation) {
                binding.viewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
            } else {
                binding.viewPager.setPageTransformer(Utils.getTransformer(item.getItemId()));
                binding.viewPager.setCurrentItem(0);
                binding.viewPager.getAdapter().notifyDataSetChanged();
            }
            return false;
        });
        popup.show();
    }

    /*
     * ViewPager page change listener
     */
    ViewPager2.OnPageChangeCallback pageChangeCallback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                binding.btnNext.setText(getString(R.string.start));
                binding.btnSkip.setVisibility(View.GONE);
            } else {
                // still pages are left
                binding.btnNext.setText(getString(R.string.next));
                binding.btnSkip.setVisibility(View.VISIBLE);
            }
        }
    };


    private void timerStart() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, HomeActivity.class));
          //  finish();
        }, 1000);
    }

}

