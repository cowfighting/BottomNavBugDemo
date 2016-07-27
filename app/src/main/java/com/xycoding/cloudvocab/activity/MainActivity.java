package com.xycoding.cloudvocab.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.xycoding.cloudvocab.R;
import com.xycoding.cloudvocab.activity.base.BaseBindingActivity;
import com.xycoding.cloudvocab.fragment.RecentFragment;
import com.xycoding.cloudvocab.model.TabInfoModel;
import com.xycoding.cloudvocab.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseBindingActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    private List<TabInfoModel> mTabs = new ArrayList<>();

    private ActivityMainBinding mBinding;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                break;
            case R.id.action_account:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void readIntent() {

    }

    @Override
    protected void initControls(Bundle savedInstanceState) {
        mBinding = (ActivityMainBinding) binding;
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

        initTabs();
    }

    @Override
    protected void setListeners() {

    }

    private void initTabs() {
        //recommend
        mTabs.add(new TabInfoModel(R.string.vocab_recommend, R.drawable.btn_star_border, RecentFragment.class));
        //recent
        mTabs.add(new TabInfoModel(R.string.vocab_recent, R.drawable.btn_star, RecentFragment.class));
        //account
        mTabs.add(new TabInfoModel(R.string.vocab_account, R.drawable.ic_account, RecentFragment.class));

        mBinding.tabHost.setup(this, getSupportFragmentManager(), R.id.tab_content);
        for (TabInfoModel tab : mTabs) {
            String tabName = getString(tab.getNameRes());
            //add bottom tab
            AHBottomNavigationItem item = new AHBottomNavigationItem(tabName, tab.getDrawableRes());
            mBinding.bottomNavigation.addItem(item);

            //add tab layout
            TabHost.TabSpec tabSpec = mBinding.tabHost.newTabSpec(tabName).setIndicator(tabName);
            mBinding.tabHost.addTab(tabSpec, tab.getFragmentClass(), null);
        }
        //change colors
        mBinding.bottomNavigation.setAccentColor(ContextCompat.getColor(this, R.color.colorPrimary));
        mBinding.bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                if (!wasSelected) {
                    mBinding.tabHost.setCurrentTab(position);
                }
                return !wasSelected;
            }
        });
    }

}
