package com.ayuan.douban.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ayuan.douban.R;
import com.ayuan.douban.Utils.SPUtils;

/**
 * 热映
 */
public class HotFragment extends Fragment implements View.OnClickListener {

    private Button btn_left;
    private Button btn_right;
    private TextView tv_search_hot;
    private Spinner s_select_city;
    private View v_left;
    private View v_right;
    private String TAG = "HotFragment";
    private String[] citys = {"北京", "上海", "广东", "南京", "武汉", "苏州", "天津"};
    public String city;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_hot, null);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        tv_search_hot = (TextView) inflate.findViewById(R.id.tv_search_hot);
        s_select_city = (Spinner) inflate.findViewById(R.id.s_select_city);

        v_left = inflate.findViewById(R.id.v_left);
        v_right = inflate.findViewById(R.id.v_right);

        btn_left = (Button) inflate.findViewById(R.id.btn_left);
        btn_right = (Button) inflate.findViewById(R.id.btn_right);

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.item_citys, citys);
        s_select_city.setAdapter(stringArrayAdapter);

        btn_left.setOnClickListener(this);
        btn_right.setOnClickListener(this);
        tv_search_hot.setOnClickListener(this);

        s_select_city.setSelection(SPUtils.getInt(getActivity(), SPUtils.CITYCODE, 0));


        s_select_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SPUtils.putString(getActivity(), SPUtils.CITYNAME, citys[position]);
                SPUtils.putInt(getActivity(), SPUtils.CITYCODE, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //加载默认页面
        final FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_hot, new GenuineHot(), "GenuineHot");
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_left:
                v_left.setVisibility(View.VISIBLE);
                v_right.setVisibility(View.INVISIBLE);
                replaceFragment(new GenuineHot(), "GenuineHot");
                break;
            case R.id.btn_right:
                v_left.setVisibility(View.INVISIBLE);
                v_right.setVisibility(View.VISIBLE);
                replaceFragment(new ComingSoon(), "ComingSoon");
                break;
            case R.id.tv_search_hot:
                Toast.makeText(getActivity(), "正在搜索", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void replaceFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_hot, fragment, tag);
        fragmentTransaction.commit();
    }
}
