package com.ayuan.douban.fragment;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.ayuan.douban.R;

/**
 * 热映
 */
public class HotFragment extends Fragment implements View.OnClickListener {

    private Button btn_left;
    private Button btn_right;
    private TextView tv_search;
    private Spinner s_select_city;
    private View v_left;
    private View v_right;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_hot, null);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        tv_search = (TextView) inflate.findViewById(R.id.tv_search);
        s_select_city = (Spinner) inflate.findViewById(R.id.s_select_city);
        v_left = inflate.findViewById(R.id.v_left);
        v_right = inflate.findViewById(R.id.v_right);

        btn_left = (Button) inflate.findViewById(R.id.btn_left);
        btn_right = (Button) inflate.findViewById(R.id.btn_right);

        btn_left.setOnClickListener(this);
        btn_right.setOnClickListener(this);
        tv_search.setOnClickListener(this);

        //加载默认页面
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_hot, new GenuineHot());
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_left:
                v_left.setVisibility(View.VISIBLE);
                v_right.setVisibility(View.INVISIBLE);
                replaceFragment(new GenuineHot());
                break;
            case R.id.btn_right:
                v_left.setVisibility(View.INVISIBLE);
                v_right.setVisibility(View.VISIBLE);
                replaceFragment(new ComingSoon());
                break;
            case R.id.tv_search:
                Toast.makeText(getActivity(), "正在搜索", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_hot, fragment);
        fragmentTransaction.commit();
    }
}
