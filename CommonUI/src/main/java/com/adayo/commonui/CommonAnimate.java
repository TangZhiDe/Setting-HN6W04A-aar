package com.adayo.commonui;

import android.view.View;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by admin on 2018/9/12.
 */

public class CommonAnimate {

    //需要做动画变换所有layout的集合
    private HashMap<Integer, View> mViewMap = new HashMap<>();
    //进行完动画变换后已经有几层layout进行了动画变化
    private int mHaveChangedLevel = 0;

    /**
     *
     * @param viewMap 需要做动画变换所有layout的集合
     */
    public CommonAnimate(HashMap<Integer, View> viewMap) {
        this.mViewMap = viewMap;
    }

    /**
     * 传进来的toLevel是装在Fragment的layout需要到第几层
     *
     * @param toLevel
     */
    public void levelTo(int toLevel) {
        //达到需要到达layout的层数，需要几层level进行动画变化
        int needToChangeLevel = toLevel - 1;

        if (mHaveChangedLevel < needToChangeLevel) {
            levelLow2High(needToChangeLevel);
        } else if (mHaveChangedLevel > needToChangeLevel) {
            levelHigh2Low(needToChangeLevel);
        } else {
            //do nothing
        }
    }


    /**
     * 动画由低到高
     * 比如从第一层调到第三层实际上是先layout1进行动画变换
     * 然后layout1 layout2在进行变换
     * 相当于 from level1 to level2
     *        from level2 to level3
     *
     * @param needToChangeLevel 实际有几层layout需要改变
     */
    private void levelLow2High(int needToChangeLevel) {
        //需要变换动画的次数 比如有n层到m层 就是需要变换m-n次，
        // 也就是动画先由n到第n+1层然后 n+1再到n+2...最后到m层
        int changeLevel = needToChangeLevel - mHaveChangedLevel;
        for (int i = 0; i < changeLevel; i++) {
            HashMap<Integer, View> viewMap = new HashMap<>();
            for (Integer level : mViewMap.keySet()) {
                if (level <= mHaveChangedLevel + 1) {
                    viewMap.put(level, mViewMap.get(level));
                }
            }
            mHaveChangedLevel++;
            for (Integer level : viewMap.keySet()) {
                View view = viewMap.get(level);
                view.animate().scaleY(0.9f - 0.1f * (viewMap.size() - level))
                        .alpha(0.4f).translationX(-40 * (viewMap.size() + 1 - level))
                        .setDuration(500).start();
            }
        }
    }

    /**
     * 动画又高到低
     * 比如从第三层层调到第一层实际上是先layout1 layout2进行动画变换
     * 然后layout1在进行变换
     * 相当于 from level3 to level2
     *        from level2 to level1
     *
     * @param needToChangeLevel 实际有几层layout需要改变
     */
    private void levelHigh2Low(int needToChangeLevel) {
        int changeLevel = mHaveChangedLevel - needToChangeLevel;
        for (int i = 0; i < changeLevel; i++) {
            HashMap<Integer, View> viewMap = new HashMap<>();
            for (Integer level : mViewMap.keySet()) {
                if (level <= mHaveChangedLevel) {
                    viewMap.put(level, mViewMap.get(level));
                }
            }
            for (Integer level : viewMap.keySet()) {
                View view = viewMap.get(level);
                float alphaSize;
                if (level < viewMap.size()) {
                    alphaSize = 0.4f;
                } else {
                    alphaSize = 1f;
                }
                view.animate().scaleY(1f - 0.1f * (viewMap.size() - level))
                        .alpha(alphaSize).translationX(-40 * (viewMap.size() - level))
                        .setDuration(500).start();

            }
            mHaveChangedLevel--;
        }
    }


}
