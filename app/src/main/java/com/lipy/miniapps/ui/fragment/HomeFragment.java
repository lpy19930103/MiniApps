package com.lipy.miniapps.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lipy.miniapps.R;
import com.lipy.miniapps.biz.Biz;
import com.lipy.miniapps.dto.HomeData;
import com.lipy.miniapps.miniappslibrary.http.listener.IResultListener;
import com.lipy.miniapps.miniappslibrary.http.message.ActionMessage;
import com.lipy.miniapps.miniappslibrary.http.response.ServiceResult;
import com.lipy.miniapps.miniappslibrary.utils.Log;
import com.lipy.miniapps.ui.adapter.HomeAdapter;
import com.lipy.miniapps.ui.fragment.base.BaseFragment;
import com.lipy.miniapps.ui.view.HomeHeaderLayout;
import com.lipy.miniapps.ui.view.RecycleViewDivider;
import com.lipy.miniapps.zxing.app.CaptureActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lipy on 2017/3/2.
 */

public class HomeFragment extends BaseFragment implements IResultListener {

    private List<HomeData.ListBean> mList = new ArrayList<>();

    @BindView(R.id.qrcode_view)
    View qrcodeView;

    @BindView(R.id.category_view)
    View categoryView;

    @BindView(R.id.search_view)
    View searchView;

    @BindView(R.id.loading_view)
    ImageView loadingView;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private HomeAdapter mHomeAdapter;

    @OnClick(R.id.qrcode_view)
    void qrcode() {
        startActivity(new Intent(getReqContext(), CaptureActivity.class));


    }

    @OnClick(R.id.category_view)
    void category() {
    }

    @OnClick(R.id.search_view)
    void search() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        AnimationDrawable anim = (AnimationDrawable) loadingView.getDrawable();
        anim.start();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new RecycleViewDivider(getReqContext(), LinearLayoutManager.VERTICAL, 10, getResources().getColor(R.color.transparent)));// 添加分割线。
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new Biz(this).homeDetails();
    }


    @Override
    public Context getReqContext() {
        return getActivity();
    }

    @Override
    public void onSuccess(ServiceResult result) {
        if (result.getDto() instanceof HomeData) {
            HomeData homeData = (HomeData) result.getDto();
            mList.addAll(homeData.getList());
            showSuccessView(homeData.getHead());
        }
    }

    private void showSuccessView(HomeData.HeadBean head) {
        recyclerView.setVisibility(View.VISIBLE);
        loadingView.setVisibility(View.GONE);


        mHomeAdapter = new HomeAdapter(getReqContext(), mList, null);
        mHomeAdapter.addHeaderView(new HomeHeaderLayout(getReqContext(), head));
        recyclerView.setAdapter(mHomeAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mHomeAdapter.updateAdInScrollView();

            }

        });

    }

    @Override
    public void onFailer(ActionMessage result) {
        Log.e("onFailer");
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mHomeAdapter.destoryVideoView();
    }
}
