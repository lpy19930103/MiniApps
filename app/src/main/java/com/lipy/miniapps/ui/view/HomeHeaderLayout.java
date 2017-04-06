package com.lipy.miniapps.ui.view;

import com.lipy.miniapps.R;
import com.lipy.miniapps.dto.HomeData;
import com.lipy.miniapps.miniappslibrary.utils.ImageLoaderUtil;
import com.lipy.miniapps.ui.adapter.PhotoPagerAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首页header布局
 * Created by lipy on 2017/3/9 0009.
 */
public class HomeHeaderLayout extends RelativeLayout {

    private HomeData.HeadBean mHeadBean;

    private Context mContext;

    private ImageLoaderUtil mLoaderUtil;

    @BindView(R.id.pager)
    AutoScrollViewPager mViewPager;

    @BindView(R.id.pager_indictor_view)
    CirclePageIndicator mPagerIndictor;

    @BindView(R.id.zuixing_view)
    TextView mHotView;

    @BindView(R.id.content_layout)
    LinearLayout mFootLayout;

    @BindView(R.id.head_image_one)
    ImageView mImageView0x01;

    @BindView(R.id.head_image_two)
    ImageView mImageView0x02;

    @BindView(R.id.head_image_three)
    ImageView mImageView0x03;

    @BindView(R.id.head_image_four)
    ImageView mImageView0x04;


    public HomeHeaderLayout(Context context, HomeData.HeadBean head) {
        super(context);
        mHeadBean = head;
        mContext = context;
        mLoaderUtil = ImageLoaderUtil.getInstance(context);
        initView();
    }

    private void initView() {
        RelativeLayout mRootView = (RelativeLayout) LayoutInflater.from(mContext).inflate(R.layout.listview_home_head_layout, this);
        ButterKnife.bind(this, mRootView);

        ImageView[] mImageViews = new ImageView[4];
        mImageViews[0] = mImageView0x01;
        mImageViews[1] = mImageView0x02;
        mImageViews[2] = mImageView0x03;
        mImageViews[3] = mImageView0x04;

        mViewPager.setAdapter(new PhotoPagerAdapter(mContext, (ArrayList<String>) mHeadBean.getAds(), true));
        mViewPager.startAutoScroll(7000);
        mPagerIndictor.setViewPager(mViewPager);


        for (int i = 0; i < mImageViews.length; i++) {
            mLoaderUtil.displayImage(mImageViews[i], mHeadBean.getMiddle().get(i));
        }

        for (HomeData.HeadBean.FooterBean footerBean : mHeadBean.getFooter()) {
            mFootLayout.addView(createItem(footerBean));
        }
        mHotView.setText(mContext.getString(R.string.today_zuixing));
    }

    private HomeBottomItem createItem(HomeData.HeadBean.FooterBean value) {
        HomeBottomItem item = new HomeBottomItem(mContext, value);
        return item;
    }
}
