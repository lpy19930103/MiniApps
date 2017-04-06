package com.lipy.miniapps.ui.view;

import com.lipy.miniapps.R;
import com.lipy.miniapps.dto.HomeData;
import com.lipy.miniapps.miniappslibrary.utils.ImageLoaderUtil;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首页脚布局
 * Created by lipy on 2017/3/9 0009.
 */
public class HomeBottomItem extends RelativeLayout {

    private Context mContext;
    /**
     * UI
     */
    private RelativeLayout mRootView;
    @BindView(R.id.title_view)
    TextView mTitleView;
    @BindView(R.id.info_view)
    TextView mInfoView;
    @BindView(R.id.interesting_view)
    TextView mInterestingView;
    @BindView(R.id.icon_1)
    ImageView mImageOneView;
    @BindView(R.id.icon_2)
    ImageView mImageTwoView;

    /**
     * Data
     */
    private HomeData.HeadBean.FooterBean mData;
    private ImageLoaderUtil mImageLoader;

    public HomeBottomItem(Context context, HomeData.HeadBean.FooterBean data) {
        this(context, null, data);
    }

    public HomeBottomItem(Context context, AttributeSet attrs, HomeData.HeadBean.FooterBean data) {
        super(context, attrs);
        mContext = context;
        mData = data;
        mImageLoader = ImageLoaderUtil.getInstance(mContext);
        initView();
    }

    private void initView() {
        mRootView = (RelativeLayout) LayoutInflater.from(mContext).inflate(R.layout.item_home_recommand_layout, this); //添加到当前布局中
        ButterKnife.bind(this, mRootView);
        mRootView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mTitleView.setText(mData.getTitle());
        mInfoView.setText(mData.getInfo());
        mInterestingView.setText(mData.getFrom());
        mImageLoader.displayImage(mImageOneView, mData.getImageOne());
        mImageLoader.displayImage(mImageTwoView, mData.getImageTwo());
    }
}
