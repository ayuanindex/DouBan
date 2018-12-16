package com.ayuan.douban.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ayuan.douban.R;

public class GenuineHot extends Fragment {

    private ListView lv_movie_list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_hot_genuinehot, null);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        lv_movie_list = (ListView) inflate.findViewById(R.id.lv_movie_list);
    }
}
