package com.ayuan.douban.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ayuan.douban.R;
import com.ayuan.douban.Utils.HttpRequest;
import com.ayuan.douban.vo.Subjects;

import java.util.ArrayList;
import java.util.Iterator;

public class GenuineHot extends Fragment {

    private String TAG = "GenuineHot";
    private ListView lv_movie_list;
    private String[] strings;
    private TextView test;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        /*if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_hot_genuinehot, null);
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }*/
        View inflate = inflater.inflate(R.layout.fragment_hot_genuinehot, null);
        initView(inflate);
        initData();

        return inflate;
    }

    private void initView(View inflate) {
        lv_movie_list = (ListView) inflate.findViewById(R.id.lv_movie_list);
        lv_movie_list.setAdapter(new MovieListAdapter());
    }

    private void initData() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                ArrayList<Subjects> subjects = HttpRequest.httpGetMovie(new String[]{"北京", "0", "2", "", ""});
                Iterator<Subjects> iterator = subjects.iterator();
                while (iterator.hasNext()) {
                    Subjects subject = iterator.next();
                    Log.i(TAG, "哈哈:解析完成了" + subject.toString());
                }
            }
        }.start();
    }

    private class MovieListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if (convertView == null) {
                view = View.inflate(getActivity(), R.layout.view_item_movie, null);
            } else {
                view = convertView;
            }



            return view;
        }
    }
}
