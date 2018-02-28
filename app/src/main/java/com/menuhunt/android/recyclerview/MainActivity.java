package com.menuhunt.android.recyclerview;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CallFragment.OnFragmentInteractionListener,
        ContactFragment.OnFragmentInteractionListener, FavoriteFragment.OnFragmentInteractionListener{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateFragments();
    }

    private void populateFragments(){
        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewpager_id);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        if(viewPagerAdapter != null) {
            viewPagerAdapter.addFragment(new CallFragment(), "", R.drawable.ic_call);
            viewPagerAdapter.addFragment(new ContactFragment(), "", R.drawable.ic_contacts);
            viewPagerAdapter.addFragment(new FavoriteFragment(), "", R.drawable.ic_favorite);
            viewPager.setAdapter(viewPagerAdapter);
            tabLayout.setupWithViewPager(viewPager);
            for(int i=0; i<tabLayout.getTabCount(); i++) {
                tabLayout.getTabAt(i).setIcon(viewPagerAdapter.getTabIcon(i));
            }
            tabLayout.getTabAt(0).select();
        }
        getSupportActionBar().setElevation(0); //get rid of the line between action bar and the tablayout
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
