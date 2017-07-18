package com.example.collegemessageonline.Controller.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.collegemessageonline.Adapter.TabAdapter;
import com.example.collegemessageonline.Controller.Fragment.Campus;
import com.example.collegemessageonline.Controller.Fragment.FuDaoFragment;
import com.example.collegemessageonline.Controller.Fragment.HeadLine;
import com.example.collegemessageonline.Controller.Fragment.HuoDong;
import com.example.collegemessageonline.Controller.Fragment.KeTang;
import com.example.collegemessageonline.Controller.Fragment.Live;
import com.example.collegemessageonline.Controller.Fragment.Recreation;
import com.example.collegemessageonline.Controller.Fragment.TaoLunFragment;
import com.example.collegemessageonline.Controller.ShiTi.Name;
import com.example.collegemessageonline.Model.Base.BaseActivity;
import com.example.collegemessageonline.MyGrideLayout.MyGridLayout;
import com.example.collegemessageonline.R;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity {
    private final static String DAY = "day";
    private final static String NIGHT = "night";
    private static final String TAG = "简单点";
    private TabLayout home_tablayout;
    private ViewPager home_viewpager;
    private MyGridLayout mGridLayout_dragable;
    private ArrayList<String> list1;
    private MyGridLayout mGridLayout2_disdragble;
    private ArrayList<String> list2;
    private LinearLayout mGridLayout_ll;
    private View mGridLayoutTitle;
    private boolean mFlag = true;
    private ImageView image;
    private ImageView cicleimageview;
    private ArrayList<Fragment> list;
    private ArrayList<String> arrayList;
    private Name name;
    private TabAdapter adapter;
    private Fragment fragment;
    private String s;
    private Campus campus;
    private KeTang keTang;
    private Recreation recreation;
    private HuoDong huoDong;
    private HeadLine headLine;
    private Live live;
    private FuDaoFragment fuDaoFragment;
    private TaoLunFragment taoLunFragment;
    private TextView myView;
    private String string;
    private SharedPreferences sharedPreferences;
    private WindowManager mWindowManager;

    @Override
    public void initData() {
   moshi();
        arrayList = new ArrayList<>();
        list = new ArrayList<>();
        campus = new Campus();
        keTang = new KeTang();
        recreation = new Recreation();
        huoDong = new HuoDong();
        headLine = new HeadLine();
        live = new Live();
        fuDaoFragment = new FuDaoFragment();
        taoLunFragment = new TaoLunFragment();
        list.add(campus);
        list.add(keTang);
        list.add(recreation);
        list.add(huoDong);
        list.add(headLine);
        list.add(live);

        arrayList.add("校园");
        arrayList.add("社会");
        arrayList.add("活动");
        arrayList.add("头条");
        arrayList.add("阅读");
        arrayList.add("生活");
        mGridLayout2_disdragble.setOnItemClickLitener(new MyGridLayout.OnItemClickLitener() {
            @Override
            public void OnItemClickLitener(String strItem, View v) {
                mGridLayout2_disdragble.removeView(v);
                mGridLayout_dragable.addTvItem(strItem);
                if (strItem.equals("辅导员")) {
                    arrayList.add("辅导员");
                    list.add(fuDaoFragment);
                }
                if (strItem.equals("讨论")) {
                    arrayList.add("讨论");
                    list.add(taoLunFragment);
                }
                if (strItem.equals("校园")) {
                    arrayList.add("校园");
                    list.add(new Campus());
                }
                if (strItem.equals("社会")) {
                    arrayList.add("社会");
                    list.add(new KeTang());
                }
                if (strItem.equals("活动")) {
                    arrayList.add("活动");
                    list.add(new HuoDong());
                }
                if (strItem.equals("头条")) {
                    arrayList.add("头条");
                    list.add(new HeadLine());
                }
                if (strItem.equals("阅读")) {
                    arrayList.add("阅读");
                    list.add(new Recreation());
                }
                if (strItem.equals("生活")) {
                    arrayList.add("生活");
                    list.add(new Live());
                }
                adapter.notifyDataSetChanged();
            }
        });
        mGridLayout_dragable.setOnItemClickLitener(new MyGridLayout.OnItemClickLitener() {
            @Override
            public void OnItemClickLitener(String strItem, View v) {
                mGridLayout_dragable.removeView(v);
                mGridLayout2_disdragble.addTvItem(strItem);
                final int i = arrayList.indexOf(strItem);
                final int a = list.indexOf(campus);
                final int b = list.indexOf(keTang);
                final int c = list.indexOf(recreation);
                final int d = list.indexOf(huoDong);
                final int e = list.indexOf(headLine);
                final int f = list.indexOf(live);
                final int g = list.indexOf(fuDaoFragment);
                Log.e("123456789789546", g + "");
                final int h = list.indexOf(taoLunFragment);

                if (strItem.equals("校园")) {
                    list.remove(a);
                    arrayList.remove(i);

                }
                if (strItem.equals("社会")) {
                    list.remove(b);
                    arrayList.remove(i);

                }
                if (strItem.equals("活动")) {
                    list.remove(c);
                    arrayList.remove(i);

                }
                if (strItem.equals("头条")) {
                    list.remove(d);
                    arrayList.remove(i);

                }
                if (strItem.equals("阅读")) {
                    list.remove(e);
                    arrayList.remove(i);

                }
                if (strItem.equals("生活")) {
                    list.remove(f);
                    arrayList.remove(i);

                }
                if (strItem.equals("辅导员")) {
                    list.remove(g);
                    arrayList.remove(i);

                }
                if (strItem.equals("讨论")) {
                    list.remove(h);
                    arrayList.remove(i);
                }
                adapter.notifyDataSetChanged();
            }
        });

        adapter = new TabAdapter(getSupportFragmentManager(), list, arrayList);
        adapter.notifyDataSetChanged();
        home_viewpager.setAdapter(adapter);
        home_tablayout.setupWithViewPager(home_viewpager);
        image = (ImageView) findViewById(R.id.frg_add);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mFlag) {

                    mGridLayout_ll.setVisibility(View.VISIBLE);
                    mGridLayoutTitle.setVisibility(View.VISIBLE);
                    home_tablayout.setVisibility(View.GONE);
                    // 加号旋转动画 打开 顺时针
                    Animation anim = AnimationUtils.loadAnimation(HomeActivity.this,
                            R.anim.animation);
                    anim.setDuration(500);
                    anim.setFillAfter(true);
                    v.startAnimation(anim);

                    // 标题动画(由完全透明 ----完全不透明)
                    AlphaAnimation aa = new AlphaAnimation(0.0F, 1.0F);
                    aa.setDuration(1000);
                    aa.setFillAfter(true);
                    mGridLayoutTitle.startAnimation(aa);

                    // 从上往下平移动画
                    Animation translateAnim = AnimationUtils.loadAnimation(
                            HomeActivity.this, R.anim.top2bottom_anim);
                    mGridLayout_ll.startAnimation(translateAnim);

                    mFlag = false;
                } else {

                    mGridLayoutTitle.setVisibility(View.GONE);
                    home_tablayout.setVisibility(View.VISIBLE);
                    // 逆时针旋转动画
                    Animation anim = AnimationUtils.loadAnimation(HomeActivity.this,
                            R.anim.animation2);
                    anim.setDuration(500);
                    anim.setFillAfter(true);
                    v.startAnimation(anim);

                    // 标题动画(由完全不透明 ----完全透明)
                    AlphaAnimation aa = new AlphaAnimation(1.0F, 0.0F);
                    aa.setDuration(500);
                    aa.setFillAfter(true);
                    mGridLayoutTitle.startAnimation(aa);

                    // 从下往上平移动画
                    Animation translateAnim = AnimationUtils.loadAnimation(
                            HomeActivity.this, R.anim.bottom2top_anim);
                    mGridLayout_ll.startAnimation(translateAnim);
                    translateAnim.start();
                    translateAnim.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            mGridLayout_ll.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    mFlag = true;
                }

            }

        });
        initGridLayout();

    }

    private void moshi() {
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        sharedPreferences = getSharedPreferences("skinchange", MODE_PRIVATE);
        string = sharedPreferences.getString("skin", DAY);
        Log.e("sahdjklf", string);
        if (string.equals(NIGHT)) {
            night();
        } else {
            day();
        }
    }

    @Override
    protected void onClick() {

    }

    @Override
    protected void initId() {
        cicleimageview = (ImageView) findViewById(R.id.onlyone);
        SharedPreferences sharedPreferences = getSharedPreferences("msg", MODE_PRIVATE);
        final boolean state = sharedPreferences.getBoolean("state", false);
        final String touxiang = sharedPreferences.getString("touxiang", null);
        if (state) {
            Glide.with(this).load(touxiang).into(cicleimageview);
        } else {
            cicleimageview.setImageResource(R.drawable.ic_nav_my_pressed);
        }

        home_tablayout = (TabLayout) findViewById(R.id.frg_tablayout);
        home_viewpager = (ViewPager) findViewById(R.id.viewpager);
        home_tablayout.setTabTextColors(Color.BLACK, Color.WHITE);
        findViewById(R.id.onlyone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, OnlyOne.class);
                startActivity(intent);
            }
        });
        mGridLayout_ll = (LinearLayout) findViewById(R.id.gridlayout_ll);
        mGridLayoutTitle = findViewById(R.id.layout_grid_title);
        mGridLayout_dragable = (MyGridLayout) findViewById(R.id.gridelayout_top);
        mGridLayout2_disdragble = (MyGridLayout) findViewById(R.id.gridelayout_down);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    private void initGridLayout() {
        mGridLayout_dragable.setGridLayoutItemDrageAble(true);
        list1 = new ArrayList<String>();
        list1.add("头条");
        list1.add("社会");
        list1.add("生活");
        list1.add("校园");
        list1.add("阅读");
        mGridLayout_dragable.addItems(list1);

        mGridLayout2_disdragble.setGridLayoutItemDrageAble(false);
        list2 = new ArrayList<String>();
        list2.add("辅导员");
        list2.add("讨论");
        mGridLayout2_disdragble.addItems(list2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initId();
    }

    private static boolean isExit = false;

    private static Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {

        if (!isExit) {
            isExit = true;
            Toast.makeText(HomeActivity.this, "再按一次后退键退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {

            Log.e(TAG, "exit application");

            this.finish();
        }
    }

    public void night() {
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.FILL_PARENT,
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                        | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.BOTTOM;
        params.y=11;
        if (myView == null) {
            myView = new TextView(this);
            myView.setBackgroundColor(0x80000000);
        }
        mWindowManager.addView(myView, params);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("skin", NIGHT);
        edit.commit();
    }

    public void day() {
        if (myView != null) {
            mWindowManager.removeView(myView);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("skin", DAY);
            edit.commit();
        }
    }
}
