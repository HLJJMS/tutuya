package com.tutuya.tck.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.Toast;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.tutuya.tck.R;
import com.tutuya.tck.activity.login.LoginActivity;
import com.tutuya.tck.activity.login.LoginMessageActivity;
import com.tutuya.tck.adapter.GMFragmentAdapter;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.bean.base.TabEntity;
import com.tutuya.tck.bean.network.HomeBannerBean;
import com.tutuya.tck.bean.network.HomeBean;
import com.tutuya.tck.frament.IHomeActivityToFramgent;
import com.tutuya.tck.frament.game.GameFragment;
import com.tutuya.tck.frament.home.HomeMvpFragment;
import com.tutuya.tck.frament.home.IHomeForActivity;
import com.tutuya.tck.frament.mall.MallMvpFragment;
import com.tutuya.tck.frament.my.MyMvpFragment;
import com.tutuya.tck.frament.teach.TeachFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//主页activity
public class HomeActivity extends BaseActivity {
    @BindView(R.id.frament)
    ViewPager viewPager;
    private Boolean isEnd = false, isMyFrist = true;

    @BindView(R.id.tl_2)
    CommonTabLayout tl2;
    List<Fragment> list = new ArrayList<>();
    private GMFragmentAdapter gmFragmentAdapter;
    private String[] mTitles = {"首页", "智力游戏", "在线讲评", "在线商城", "个人中心"};
    private int[] mIconUnselectIds = {R.mipmap.tab_home, R.mipmap.tab_game, R.mipmap.tab_classing, R.mipmap.tab_malling, R.mipmap.tab_person};
    private HomeMvpFragment homeMvpFragment = new HomeMvpFragment();
    private GameFragment gameFragment = new GameFragment();
    private TeachFragment teachFragment = new TeachFragment();
    private MallMvpFragment mallMvpFragment = new MallMvpFragment();
    private MyMvpFragment myMvpFragment = new MyMvpFragment();
    private IHomeActivityToFramgent gameInterface, mallInterface, myInterface, teacherInterface, homeInterface;
    private int[] mIconSelectIds = {R.mipmap.tab_home_select, R.mipmap.tab_game_select, R.mipmap.tab_classing_select, R.mipmap.tab_mall_select, R.mipmap.tab_person_select};
    private HomeBean.DataBean bean;
    private IHomeForActivity iHomeForActivity;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected void initView() {
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initData() {
        addData();
        aboutTab();
        sendTokenToFramgent();
        interfaceState();
        sentDataToHomeFramgent();


    }
    @Subscribe
    public void onEvent(String messageEvent) {
        viewPager.setCurrentItem(0);
        isMyFrist = true;

    }
    private void sentDataToHomeFramgent() {
        ArrayList<HomeBannerBean.DataBean> bannerList = getIntent().getParcelableArrayListExtra("banner");
        iHomeForActivity = homeMvpFragment;
        iHomeForActivity.setData(bannerList);

    }

    //接口声明
    private void interfaceState() {
        mallInterface = mallMvpFragment;
        myInterface = myMvpFragment;
        teacherInterface = teachFragment;
    }

    private void sendTokenToFramgent() {
        Bundle sendBundle = new Bundle();
        sendBundle.putString("token", getMyApplication().getToken());
        sendBundle.putBoolean("vip", getMyApplication().isVip());
        homeMvpFragment.setArguments(sendBundle);
        mallMvpFragment.setArguments(sendBundle);
        gameFragment.setArguments(sendBundle);
        myMvpFragment.setArguments(sendBundle);
        teachFragment.setArguments(sendBundle);
    }

    private void aboutTab() {
        list.add(homeMvpFragment);
        list.add(gameFragment);
        list.add(teachFragment);
        list.add(mallMvpFragment);
        list.add(myMvpFragment);
        gmFragmentAdapter = new GMFragmentAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(gmFragmentAdapter);
        viewPager.setOffscreenPageLimit(4);
        tl2.setTabData(mTabEntities);
        tl2.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
//                if (getMyApplication().getToken() == "") {
//                    startActivity(LoginMessageActivity.class);
//                } else if (position == 4 && isMyFrist == true && getMyApplication().getToken() != "") {
//                    myInterface.loadData();
//                    isMyFrist = false;
//                }

            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                tl2.setCurrentTab(i);
                if (i == 4&&getMyApplication().getToken() == "") {
                    startActivity(LoginMessageActivity.class);
                } else if (i == 4 && isMyFrist == true && getMyApplication().getToken() != "") {
                    myInterface.loadData();
                    isMyFrist = false;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    private void addData() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //点击两次退出
        if (keyCode == 4) {
//            quit.ClickTwiceQuit(this);
            ClickTwiceQuit(this);
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }


    public void ClickTwiceQuit(Context context) {
        //点击两次退出
        Handler h = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                isEnd = false;
            }
        };
        if (isEnd == true) {
            finish();
        } else {
            isEnd = true;
            Toast.makeText(context, "再按一次退出", Toast.LENGTH_LONG).show();
            h.sendEmptyMessageDelayed(1, 2000);
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        iHomeForActivity.getToken(getMyApplication().getToken(), getMyApplication().isVip());
        myInterface.getToken(getMyApplication().getToken(),getMyApplication().isVip());
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}
