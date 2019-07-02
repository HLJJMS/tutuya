package com.tutuya.tck.activity.mall;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.diyview.FlowView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.bt_search)
    TextView btSearch;
    @BindView(R.id.lishi)
    TextView lishi;
    @BindView(R.id.null_data)
    TextView nullData;
    private List<String> list = new ArrayList<>();

    @Override
    protected void initView() {
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        headTitle.setText("搜索");
        aboutFlowView();
    }

    private void aboutFlowView() {
        final FlowView flowView;
        flowView = findViewById(R.id.flow_view);
        for (int i = 0; i < 10; i++) {
            list.add("Android");
            list.add("Java");
            list.add("IOS");
            list.add("python");
        }
//往容器内添加TextView数据
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 5, 10, 5);
        if (flowView != null) {
            flowView.removeAllViews();
        }
        for (int i = 0; i < list.size(); i++) {
            TextView tv = new TextView(this);
            tv.setPadding(28, 10, 28, 10);
            tv.setText(list.get(i));
            tv.setMaxEms(10);
            tv.setBackgroundResource(R.drawable.corner_white_solid);
            tv.setSingleLine();
            tv.setLayoutParams(layoutParams);
            flowView.addView(tv, layoutParams);
        }
    }

    @OnClick({R.id.back, R.id.bt_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_search:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
