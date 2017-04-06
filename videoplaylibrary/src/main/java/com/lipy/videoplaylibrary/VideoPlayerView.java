package com.lipy.videoplaylibrary;

import com.lipy.videoplaylibrary.utils.VideoUtil;

import android.content.Context;
import android.util.Log;

/**
 * Created by lipy on 2017/3/27 0027.
 */
public class VideoPlayerView extends BaseVideoPlayerView {
    public VideoPlayerView(Context context) {
        super(context);
    }

    public VideoPlayerView(Context context, Boolean fullFlag) {
        super(context, fullFlag);
    }

//    public void updateAdInScrollView() {
//        int currentArea = VideoUtil.getVisiblePercent(mVideoView);
//        //小于0表示未出现在屏幕上，不做任何处理
//        Log.e(TAG, "currentArea:--------------" + currentArea);
//        Log.e(TAG, "playerState:--------------" + playerState);
//        if (currentArea <= 0) {
//            return;
//        }
//        //刚要滑入和滑出时，异常状态的处理
//        if (Math.abs(currentArea - lastArea) >= 100) {
//            return;
//        }
//        if (currentArea < VIDEO_SCREEN_PERCENT) {
//            //进入自动暂停状态
//            if (canPause) {
//                pause();
//                canPause = false;
//            }
//            lastArea = 0;
////            setIsComplete(false); // 滑动出50%后标记为从头开始播
////            setIsRealPause(false); //以前叫setPauseButtonClick()
//            return;
//        }
//
//        if (isRealPause() || isComplete()) {
//            //进入手动暂停或者播放结束，播放结束和不满足自动播放条件都作为手动暂停
//            if (canPause) {
//                pause();
//                canPause = false;
//            }
//            return;
//        }
//
//        //满足自动播放条件或者用户主动点击播放，开始播放
//        if (VideoUtil.canAutoPlay(getContext(), VideoUtil.getCurrentSetting())
//                || mMediaPlayer.isPlaying()) {
//            lastArea = currentArea;
//            if (playerState == STATE_IDLE) {
//                load();
//            } else {
//                resume();
//            }
//            canPause = true;
//            setIsRealPause(false);
//        } else {
//            pause();
//            setIsRealPause(true); //不能自动播放则设置为手动暂停效果
//        }
//    }

    public void updateAdInScrollView() {
        int currentArea = VideoUtil.getVisiblePercent(mVideoView);
        //小于0表示未出现在屏幕上，不做任何处理
        Log.e(TAG, "currentArea:--------------" + currentArea);
        Log.e(TAG, "playerState:--------------" + playerState);
        if (currentArea <= 0) {
            return;
        }
        //刚要滑入和滑出时，异常状态的处理
        if (Math.abs(currentArea - lastArea) >= 100) {
            Log.e(TAG, "Math.abs--------------" + Math.abs(currentArea - lastArea));
            mMediaPlayer.reset();
            return;
        }
        if (currentArea < VIDEO_SCREEN_PERCENT) {
            //进入自动暂停状态
            if (canPause) {
                pause();
                canPause = false;
            }
            lastArea = 0;
            setIsComplete(false); // 滑动出50%后标记为从头开始播
            setIsRealPause(false); //以前叫setPauseButtonClick()
            return;
        }


        if (isRealPause() || isComplete()) {
            //进入手动暂停或者播放结束，播放结束和不满足自动播放条件都作为手动暂停
            pause();
            canPause = false;
            return;
        }

        //满足自动播放条件或者用户主动点击播放，开始播放
        if (VideoUtil.canAutoPlay(getContext(), VideoUtil.getCurrentSetting())
                || mMediaPlayer.isPlaying()) {
            lastArea = currentArea;
            resume();
            canPause = true;
            setIsRealPause(false);
        } else {
            pause();
            setIsRealPause(true); //不能自动播放则设置为手动暂停效果
        }
    }


}
