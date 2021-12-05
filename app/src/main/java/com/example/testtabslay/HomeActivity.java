package com.example.testtabslay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

import com.example.testtabslay.databinding.ActivityHomeBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeActivity extends AppCompatActivity {

   private ActivityHomeBinding binding;

    // tab titles
    private String[] titles = new String[]{"Collection", "Aesthetics", "Tickets", "Movies"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }
    private void init() {
        // removing toolbar elevation
        getSupportActionBar().setElevation(0);

        binding.viewPager.setAdapter(new ViewPagerFragmentAdapter(this));

        // attaching tab mediator
        new TabLayoutMediator(binding.tabLayout, binding.viewPager,
                (tab, position) -> tab.setText(titles[position])).attach();

        //for add tab icon
       // binding.tabLayout.getTabAt(0).setIcon(R.drawable.ic_android_black_24dp);
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
                    return new TicketsFragment();
                case 3:
                    return new MoviesFragment();
            }
            return new CollectionFragment();
        }

        @Override
        public int getItemCount() {
            return titles.length;
        }
    }
}
