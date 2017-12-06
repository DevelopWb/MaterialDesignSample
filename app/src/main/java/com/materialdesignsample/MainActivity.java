package com.materialdesignsample;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        initHomeAsUpButton();
    }

    /**
     * 初始化toolbar最左侧的按钮HomeAsUp
     */
    private void initHomeAsUpButton() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.menu_icon2);//图片必须固定大小，不能适配（24*24）
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.text1:
                Toast.makeText(getApplicationContext(), "点击了第一个按钮", Toast.LENGTH_LONG).show();
                break;
            case R.id.text2:
                Toast.makeText(getApplicationContext(), "点击了第2个按钮", Toast.LENGTH_LONG).show();

                break;
            case R.id.text3:
                Toast.makeText(getApplicationContext(), "点击了第3个按钮", Toast.LENGTH_LONG).show();

                break;
            case android.R.id.home://HomeAsUp按钮的点击事件
                mDrawerlayout.openDrawer(Gravity.START);
                break;
            default:
                break;
        }


        return true;
    }
}
