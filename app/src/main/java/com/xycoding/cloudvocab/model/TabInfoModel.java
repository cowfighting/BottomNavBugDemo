package com.xycoding.cloudvocab.model;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

/**
 * Created by xuyang on 2016/7/26.
 */
public class TabInfoModel {

    @StringRes
    private int nameRes;

    @DrawableRes
    private int drawableRes;

    private Class<?> fragmentClass;

    /**
     * 构造函数
     *
     * @param nameRes
     * @param drawableRes
     * @param fragmentClass
     */
    public TabInfoModel(
            @StringRes int nameRes, @DrawableRes int drawableRes, Class<?> fragmentClass) {
        this.nameRes = nameRes;
        this.drawableRes = drawableRes;
        this.fragmentClass = fragmentClass;
    }

    public int getNameRes() {
        return nameRes;
    }

    public void setNameRes(int nameRes) {
        this.nameRes = nameRes;
    }

    public int getDrawableRes() {
        return drawableRes;
    }

    public void setDrawableRes(int drawableRes) {
        this.drawableRes = drawableRes;
    }

    public Class<?> getFragmentClass() {
        return fragmentClass;
    }

    public void setFragmentClass(Class<?> fragmentClass) {
        this.fragmentClass = fragmentClass;
    }
}
