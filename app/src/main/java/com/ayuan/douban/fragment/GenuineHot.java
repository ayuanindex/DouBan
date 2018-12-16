package com.ayuan.douban.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ayuan.douban.R;
import com.ayuan.douban.Utils.HttpGetBitmap;
import com.ayuan.douban.Utils.HttpRequest;
import com.ayuan.douban.vo.Images;
import com.ayuan.douban.vo.ListItem;
import com.ayuan.douban.vo.Subjects;

import java.util.ArrayList;
import java.util.Iterator;

public class GenuineHot extends Fragment {

    private String TAG = "GenuineHot";
    private ListView lv_movie_list;
    private String[] strings;
    private TextView test;
    private View rootView;
    private ProgressDialog progressDialog;
    private ArrayList<Subjects> subjects;
    private ArrayList<ListItem> listItems;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    if (subjects != null) {
                        lv_movie_list.setAdapter(new MovieListAdapter());
                        if (progressDialog != null) {
                            progressDialog.dismiss();
                        }
                    }
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_hot_genuinehot, null);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initView(View inflate) {
        lv_movie_list = (ListView) inflate.findViewById(R.id.lv_movie_list);
    }

    @SuppressLint("InflateParams")
    private void initData() {
        /*listItems = new ArrayList<>();*/
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("加载中...");
        progressDialog.show();
        new Thread() {
            @Override
            public void run() {
                super.run();
                subjects = HttpRequest.httpGetMovie(new String[]{"北京", "0", "2", "", ""});
                /*Iterator<Subjects> iterator = subjects.iterator();
                while (iterator.hasNext()) {
                    Subjects subjects = iterator.next();
                    Bitmap bitmap = HttpGetBitmap.getBitmap(subjects.getImages().getSmall(), getActivity());
                    String title = subjects.getTitle();
                    ListItem listItem = new ListItem(bitmap, title);
                    listItems.add(listItem);
                }*/
                if (subjects != null) {
                    Message message = Message.obtain();
                    message.what = 1;
                    mHandler.sendMessage(message);
                }

            }
        }.start();
    }

    private class MovieListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return subjects.size();
        }

        @Override
        public Subjects getItem(int position) {
            return subjects.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view;
            if (convertView == null) {
                view = View.inflate(getActivity(), R.layout.view_item_movie, null);
            } else {
                view = convertView;
            }
            final ImageView iv_logo = (ImageView) view.findViewById(R.id.iv_logo);
            final TextView tv_movie_name = (TextView) view.findViewById(R.id.tv_movie_name);
            RatingBar rb_mark = (RatingBar) view.findViewById(R.id.rb_mark);
            TextView tv_mark = (TextView) view.findViewById(R.id.tv_mark);
            TextView tv_director = (TextView) view.findViewById(R.id.tv_director);
            final TextView tv_actor = (TextView) view.findViewById(R.id.tv_actor);
            TextView tv_seen = (TextView) view.findViewById(R.id.tv_seen);
            Button btn_purchasetickets = (Button) view.findViewById(R.id.btn_purchasetickets);

            new Thread() {
                @Override
                public void run() {
                    super.run();
                    Subjects item = getItem(position);
                    final Bitmap bitmap = HttpGetBitmap.getBitmap(item.getImages().getSmall(), getActivity());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            iv_logo.setImageBitmap(bitmap);
                        }
                    });
                }
            }.start();
            return view;
        }
    }
}
