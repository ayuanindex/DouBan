package com.ayuan.douban.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ayuan.douban.R;
import com.ayuan.douban.Utils.HttpGetBitmap;
import com.ayuan.douban.Utils.HttpRequest;
import com.ayuan.douban.vo.Actor;
import com.ayuan.douban.vo.ListItem;
import com.ayuan.douban.vo.Subjects;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.SimpleFormatter;

public class GenuineHot extends Fragment {

    private String TAG = "GenuineHot";
    private ListView lv_movie_list;
    private String[] strings;
    private TextView test;
    private static View rootView = null;
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

        lv_movie_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }

    @SuppressLint("InflateParams")
    private void initData() {
        /*listItems = new ArrayList<>();*/
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("电影准备中");
        progressDialog.setMessage("正在加载电影票");
        progressDialog.show();
        new Thread() {
            @Override
            public void run() {
                super.run();
                subjects = HttpRequest.httpGetMovie(getActivity(), new String[]{"北京", "0", "100", "", ""});
                if (subjects != null) {
                    progressDialog.dismiss();
                    progressDialog = null;
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
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            Message obtain = Message.obtain();
            obtain.what = 1;
            mHandler.sendMessage(obtain);
        }

        @Override
        public int getItemViewType(int position) {

            return super.getItemViewType(position);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final View view;
            if (convertView == null) {
                view = View.inflate(getActivity(), R.layout.view_item_movie, null);
            } else {
                view = convertView;
            }
            final ImageView viewWithTag = (ImageView) view.findViewWithTag(R.id.lv_movie_list);
            RelativeLayout rl_root = (RelativeLayout) view.findViewById(R.id.rl_root);
            final ImageView iv_logo = (ImageView) view.findViewById(R.id.iv_logo);
            final TextView tv_movie_name = (TextView) view.findViewById(R.id.tv_movie_name);
            RatingBar rb_mark = (RatingBar) view.findViewById(R.id.rb_mark);
            TextView tv_mark = (TextView) view.findViewById(R.id.tv_mark);
            TextView tv_director = (TextView) view.findViewById(R.id.tv_director);
            final TextView tv_actor = (TextView) view.findViewById(R.id.tv_actor);
            TextView tv_seen = (TextView) view.findViewById(R.id.tv_seen);
            final Button btn_purchasetickets = (Button) view.findViewById(R.id.btn_purchasetickets);
            final Subjects item = getItem(position);

            Bitmap bitmap = HttpGetBitmap.getBitmap(item.getImages().getSmall(), getActivity());
            iv_logo.setImageBitmap(bitmap);

            tv_movie_name.setText(item.getTitle());

            double average = item.getRating().getAverage();
            if (average > 0) {
                float pin = (float) (average / 10f);
                rb_mark.setRating(pin * 5f);
                tv_mark.setText(average + "");
                rb_mark.setVisibility(View.VISIBLE);
            } else {
                rb_mark.setVisibility(View.GONE);
                tv_mark.setText("暂无评分");
                tv_mark.setTextSize(11);
            }

            tv_director.setText("导演:" + item.getDirectors().get(0).getName());

            tv_actor.setText(item.getActors());

            Integer collect_count = item.getCollect_count();
            if (collect_count > 10000) {
                tv_seen.setText(new DecimalFormat("#.0").format(collect_count / 10000) + "万人看过");
            } else {
                tv_seen.setText(collect_count + "人看过");
            }

            btn_purchasetickets.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "哈哈:点击了按钮:" + position, Toast.LENGTH_SHORT).show();
                }
            });
            rl_root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "哈哈:点击了条目" + position, Toast.LENGTH_SHORT).show();
                }
            });

            return view;
        }
    }
}
