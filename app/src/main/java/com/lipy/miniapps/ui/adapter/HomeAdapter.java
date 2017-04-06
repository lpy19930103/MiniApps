package com.lipy.miniapps.ui.adapter;

import com.lipy.miniapps.R;
import com.lipy.miniapps.dto.HomeData;
import com.lipy.miniapps.miniappslibrary.http.HttpConstants;
import com.lipy.miniapps.miniappslibrary.utils.ImageLoaderUtil;
import com.lipy.miniapps.miniappslibrary.utils.Utils;
import com.lipy.videoplaylibrary.VideoPlayerView;

import org.byteam.superadapter.IMulItemViewType;
import org.byteam.superadapter.SimpleMulItemViewType;
import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;
import org.byteam.superadapter.animation.SlideInBottomAnimation;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 首页adapter
 * Created by lipy on 2017/3/8 0008.
 */
public class HomeAdapter extends SuperAdapter<HomeData.ListBean> {

    private static final int CARD_COUNT = 4;
    private static final int VIDOE_TYPE = 0x00;
    private static final int CARD_TYPE_ONE = 0x01;
    private static final int CARD_TYPE_TWO = 0x02;
    private static final int CARD_TYPE_THREE = 0x03;
    private List<HomeData.ListBean> mList;
    private ImageLoaderUtil mImageLoaderUtil;
    private Context mContext;
    private VideoPlayerView mMVideoPlayerView;

    public HomeAdapter(Context context, List<HomeData.ListBean> list, int layoutResId) {
        super(context, list, layoutResId);
        mList = list;
        mContext = context;
        enableLoadAnimation(500, new SlideInBottomAnimation());

    }

    public void updateAdInScrollView() {
        if (mMVideoPlayerView != null) {
            mMVideoPlayerView.updateAdInScrollView();
        }
    }

    public void destoryVideoView() {
        if (mMVideoPlayerView != null) {
            mMVideoPlayerView.destory();
        }
    }


    public HomeAdapter(Context context, List<HomeData.ListBean> list, SimpleMulItemViewType<HomeData.ListBean> mulItemViewType) {
        super(context, list, mulItemViewType);
        mList = list;
        mContext = context;
        enableLoadAnimation(500, new SlideInBottomAnimation());
        mImageLoaderUtil = ImageLoaderUtil.getInstance(mContext);
    }


    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, HomeData.ListBean item) {
        switch (viewType) {
            case VIDOE_TYPE:
                CircleImageView mLogoView = holder.findViewById(R.id.item_logo_view);
                RelativeLayout videoView = holder.findViewById(R.id.video_ad_layout);
                mImageLoaderUtil.displayImage(mLogoView, item.getLogo());
                holder.setText(R.id.item_info_view, item.getInfo().concat(mContext.getString(R.string.tian_qian)));
                holder.setText(R.id.item_title_view, item.getTitle());
                holder.setText(R.id.item_footer_view, item.getText());
                ImageView mShareView = holder.findViewById(R.id.item_share_view);

                mMVideoPlayerView = new VideoPlayerView(mContext);
                mMVideoPlayerView.setId();
                mMVideoPlayerView.setViewGroup(videoView);
                mMVideoPlayerView.setDataUrl(HttpConstants.getUrl()+"test.mp4");
//              mVideoPlayerView.setDataUrl("http://192.168.1.125:8080/miniapps/test2.mp4");
//              mVideoPlayerView.setDataUrl("http://baobab.wdjcdn.com/14564977406580.mp4");
                videoView.addView(mMVideoPlayerView);


                //为对应布局创建播放器
                mShareView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "shareview", Toast.LENGTH_SHORT).show();
                    }
                });

                break;
            case CARD_TYPE_ONE:
                CircleImageView mLogoView1 = holder.findViewById(R.id.item_logo_view);
                mImageLoaderUtil.displayImage(mLogoView1, item.getLogo());
                holder.setText(R.id.item_info_view, item.getInfo().concat(mContext.getString(R.string.tian_qian)));
                holder.setText(R.id.item_title_view, item.getTitle());
                holder.setText(R.id.item_footer_view, item.getText());
                holder.setText(R.id.item_info_view, item.getTitle());
                holder.setText(R.id.item_price_view, item.getPrice());
                holder.setText(R.id.item_from_view, item.getFrom());
                holder.setText(R.id.item_zan_view, item.getZan());
                LinearLayout mProductLayout = holder.findViewById(R.id.product_photo_layout);
                mProductLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                mProductLayout.removeAllViews();
                //动态添加多个imageview
                for (String url : item.getUrl()) {
                    mProductLayout.addView(createImageView(url));
                }
                break;
            case CARD_TYPE_TWO:

                CircleImageView mLogoView2 = holder.findViewById(R.id.item_logo_view);
                mImageLoaderUtil.displayImage(mLogoView2, item.getLogo());
                holder.setText(R.id.item_info_view, item.getInfo().concat(mContext.getString(R.string.tian_qian)));
                holder.setText(R.id.item_title_view, item.getTitle());
                holder.setText(R.id.item_footer_view, item.getText());
                holder.setText(R.id.item_info_view, item.getTitle());
                holder.setText(R.id.item_price_view, item.getPrice());
                holder.setText(R.id.item_from_view, item.getFrom());
                holder.setText(R.id.item_zan_view, item.getZan());
                ImageView mProductView = holder.findViewById(R.id.product_photo_view);
                mImageLoaderUtil.displayImage(mProductView, item.getUrl().get(0));

                break;
            case CARD_TYPE_THREE:
                ViewPager mViewPager = (ViewPager) holder.findViewById(R.id.pager);
                //add data
                ArrayList<HomeData.ListBean> recommandList = handleData(item);
                mViewPager.setPageMargin(Utils.dip2px(mContext, 12));
                mViewPager.setAdapter(new HotSalePagerAdapter(mContext, recommandList));
                mViewPager.setCurrentItem(recommandList.size() * 100);
                break;
        }
    }

    @Override
    protected IMulItemViewType offerMultiItemViewType() {
        return new SimpleMulItemViewType() {
            @Override
            public int getItemViewType(int position, Object o) {
                return mList.get(position).getType();
            }

            @Override
            public int getViewTypeCount() {
                return CARD_COUNT;
            }

            @Override
            public int getLayoutId(int viewType) {
                switch (viewType) {
                    case VIDOE_TYPE:
                        return R.layout.item_video_layout;
                    case CARD_TYPE_ONE:
                        return R.layout.item_product_card_one_layout;
                    case CARD_TYPE_TWO:
                        return R.layout.item_product_card_two_layout;
                    case CARD_TYPE_THREE:
                        return R.layout.item_product_card_three_layout;
                }
                return 0;
            }
        };
    }

    //动态添加ImageView
    private ImageView createImageView(String url) {
        ImageView photoView = new ImageView(mContext);
        LinearLayout.LayoutParams params = new LinearLayout.
                LayoutParams(Utils.dip2px(mContext, 100),
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.leftMargin = Utils.dip2px(mContext, 5);
        photoView.setLayoutParams(params);
        mImageLoaderUtil.displayImage(photoView, url);
        return photoView;
    }

    //为ViewPager结构化数据
    public static ArrayList<HomeData.ListBean> handleData(HomeData.ListBean value) {
        ArrayList<HomeData.ListBean> values = new ArrayList<>();
        String[] titles = value.getTitle().split("@");
        String[] infos = value.getInfo().split("@");
        String[] prices = value.getPrice().split("@");
        String[] texts = value.getText().split("@");
        ArrayList<String> urls = (ArrayList<String>) value.getUrl();
        int start = 0;
        for (int i = 0; i < titles.length; i++) {
            HomeData.ListBean tempValue = new HomeData.ListBean();
            tempValue.setTitle(titles[i]);
            tempValue.setInfo(infos[i]);
            tempValue.setPrice(prices[i]);
            tempValue.setText(texts[i]);
            tempValue.setUrl(extractData(urls, start, 3));
            start += 3;

            values.add(tempValue);
        }
        return values;
    }

    private static ArrayList<String> extractData(ArrayList<String> source, int start, int interval) {
        ArrayList<String> tempUrls = new ArrayList<>();
        for (int i = start; i < start + interval; i++) {
            tempUrls.add(source.get(i));
        }
        return tempUrls;
    }


    @Override
    public void addHeaderView(View header) {
        super.addHeaderView(header);
    }
}
