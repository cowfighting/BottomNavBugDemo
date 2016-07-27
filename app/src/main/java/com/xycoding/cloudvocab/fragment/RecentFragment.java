package com.xycoding.cloudvocab.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.xycoding.cloudvocab.R;
import com.xycoding.cloudvocab.fragment.base.BaseBindingFragment;
import com.xycoding.cloudvocab.adapter.VocabListAdapter;
import com.xycoding.cloudvocab.databinding.FragmentRecentBinding;

import java.util.ArrayList;

/**
 * Created by xuyang on 2016/7/26.
 */
public class RecentFragment extends BaseBindingFragment {

    private FragmentRecentBinding mBinding;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recent;
    }

    @Override
    protected void readIntent() {

    }

    @Override
    protected void initControls(Bundle savedInstanceState) {
        mBinding = (FragmentRecentBinding) binding;

        ArrayList<String> itemsData = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            itemsData.add("Fragment Recent Item " + i);
        }
        VocabListAdapter adapter = new VocabListAdapter(itemsData);
        mBinding.fragmentDemoRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBinding.fragmentDemoRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void setListeners() {

    }
}
