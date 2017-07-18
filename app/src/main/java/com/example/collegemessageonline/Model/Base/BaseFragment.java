package com.example.collegemessageonline.Model.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

/**
 * Created by 陆向阳 on 2017/7/10.
 */

public abstract class BaseFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(LayoutId(),container,false);
        initView(view);
        try {
            initData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return view;
    }

    protected abstract void initData()throws IOException;

    protected abstract void initView(View view);

    protected abstract int LayoutId();
    protected  abstract void setBundle(Bundle bundle);
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        if (hidden)
            onHidden();
        else
            onShow();

    }

    protected abstract void onShow();

    protected abstract void onHidden();

    @Override
    public void onDestroyView() {
        LayoutId();
        super.onDestroyView();

    }
}
