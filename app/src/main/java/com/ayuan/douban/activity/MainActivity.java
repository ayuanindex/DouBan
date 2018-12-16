package com.ayuan.douban.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.ayuan.douban.R;
import com.ayuan.douban.fragment.FindAPieceFragment;
import com.ayuan.douban.fragment.HotFragment;
import com.ayuan.douban.fragment.MineFragment;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button btn_hot;
    private Button btn_find;
    private Button btn_mine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        btn_hot = (Button) findViewById(R.id.btn_hot);
        btn_find = (Button) findViewById(R.id.btn_find);
        btn_mine = (Button) findViewById(R.id.btn_mine);

        btn_hot.setOnClickListener(this);
        btn_find.setOnClickListener(this);
        btn_mine.setOnClickListener(this);

        //加载默认的fragment
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_fragment, new HotFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_search:
                //顶部搜索栏
                break;
            case R.id.btn_hot:
                //底部热映按钮
                replaceFragment(new HotFragment());
                break;
            case R.id.btn_find:
                //底部找片按钮
                replaceFragment(new FindAPieceFragment());
                break;
            case R.id.btn_mine:
                //底部我的按钮
                replaceFragment(new MineFragment());
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_fragment, fragment);
        fragmentTransaction.commit();
    }
}
