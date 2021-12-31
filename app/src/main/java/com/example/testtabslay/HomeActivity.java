package com.example.testtabslay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.testtabslay.databinding.ActivityHomeBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private MainViewModel mainViewModel;

    // tab titles
    private String[] titles = new String[]{"Collection", "Aesthetics", "Bacteria", "Test Strips"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        Log.i("HomeActivity", "MainViewModel is Initialized!");

        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("HomeActivity", mainViewModel.message);
            }
        });

    }
    private void init() {
        // removing toolbar elevation
        getSupportActionBar().setElevation(0);

        binding.viewPager.setAdapter(new ViewPagerFragmentAdapter(this));

        // attaching tab mediator
        new TabLayoutMediator(binding.tabLayout, binding.viewPager,
                (tab, position) -> tab.setText(titles[position])).attach();

    }

    private class ViewPagerFragmentAdapter extends FragmentStateAdapter {

        ViewPagerFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new CollectionFragment();
                case 1:
                    return new AestheticsFragment();
                case 2:
                    return new BacteriaFragment();
                case 3:
                    return new TeststripsFragment();
            }
            return new CollectionFragment();
        }

        @Override
        public int getItemCount() {
            return titles.length;
        }
    }

}
