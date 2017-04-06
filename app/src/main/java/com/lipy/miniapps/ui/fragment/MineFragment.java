package com.lipy.miniapps.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lipy.miniapps.R;
import com.lipy.miniapps.ui.fragment.base.BaseFragment;

/**
 * Created by Administrator on 2017/3/2.
 */

public class MineFragment extends BaseFragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);

        return view;
    }
}
