package com.lipy.miniapps.ui.activity;

import com.lipy.miniapps.R;
import com.lipy.miniapps.ui.activity.base.BaseActivity;
import com.lipy.miniapps.ui.fragment.HomeFragment;
import com.lipy.miniapps.ui.fragment.MessageFragment;
import com.lipy.miniapps.ui.fragment.MineFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.home_layout_view)
    View homeView;

    @BindView(R.id.home_image_view)
    ImageView homeImage;

    @BindView(R.id.message_layout_view)
    View messageView;

    @BindView(R.id.message_image_view)
    ImageView messageImage;

    @BindView(R.id.mine_layout_view)
    View mineView;

    @BindView(R.id.mine_image_view)
    ImageView mineImage;
    private FragmentManager mFragmentManager;
    private HomeFragment mHomeFragment;
    private MessageFragment mMessageFragment;
    private MineFragment mMineFragment;
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mHomeFragment = new HomeFragment();
        mFragmentManager = getSupportFragmentManager();
        fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, mHomeFragment);
        fragmentTransaction.commit();

        homeImage.setBackgroundResource(R.mipmap.comui_tab_home_selected);
    }

    @OnClick(R.id.home_layout_view)
    void homeClick() {
        fragmentTransaction = mFragmentManager.beginTransaction();

        homeImage.setBackgroundResource(R.mipmap.comui_tab_home_selected);
        messageImage.setBackgroundResource(R.mipmap.comui_tab_message);
        mineImage.setBackgroundResource(R.mipmap.comui_tab_person);
        hideFragment(mMessageFragment, fragmentTransaction);
        hideFragment(mMineFragment, fragmentTransaction);

        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
            fragmentTransaction.add(R.id.content_layout, mHomeFragment);
        } else {
            fragmentTransaction.show(mHomeFragment);
        }

        fragmentTransaction.commit();

    }

    @OnClick(R.id.message_layout_view)
    void messageClick() {
        fragmentTransaction = mFragmentManager.beginTransaction();

        homeImage.setBackgroundResource(R.mipmap.comui_tab_home);
        messageImage.setBackgroundResource(R.mipmap.comui_tab_message_selected);
        mineImage.setBackgroundResource(R.mipmap.comui_tab_person);
        hideFragment(mHomeFragment, fragmentTransaction);
        hideFragment(mMineFragment, fragmentTransaction);
        if (mMessageFragment == null) {
            mMessageFragment = new MessageFragment();
            fragmentTransaction.add(R.id.content_layout, mMessageFragment);
        } else {
            fragmentTransaction.show(mMessageFragment);
        }

        fragmentTransaction.commit();
    }

    @OnClick(R.id.mine_layout_view)
    void mineClick() {
        fragmentTransaction = mFragmentManager.beginTransaction();

        homeImage.setBackgroundResource(R.mipmap.comui_tab_home);
        messageImage.setBackgroundResource(R.mipmap.comui_tab_message);
        mineImage.setBackgroundResource(R.mipmap.comui_tab_person_selected);
        hideFragment(mMessageFragment, fragmentTransaction);
        hideFragment(mHomeFragment, fragmentTransaction);

        if (mMineFragment == null) {
            mMineFragment = new MineFragment();
            fragmentTransaction.add(R.id.content_layout, mMineFragment);
        } else {
            fragmentTransaction.show(mMineFragment);
        }

        fragmentTransaction.commit();
    }

    private void hideFragment(Fragment fragment, FragmentTransaction fragmentTransaction) {
        if (fragment != null) {
            fragmentTransaction.hide(fragment);
        }
    }


}
