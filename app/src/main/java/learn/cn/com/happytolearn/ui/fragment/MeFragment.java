package learn.cn.com.happytolearn.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import learn.cn.com.happytolearn.R;
import learn.cn.com.happytolearn.ui.me.CollectionActivity;
import learn.cn.com.happytolearn.ui.me.MefollowActivity;
import learn.cn.com.happytolearn.ui.me.MyCourseActivity;
import learn.cn.com.happytolearn.ui.me.NewsActivity;
import learn.cn.com.happytolearn.ui.me.OpinionActivity;
import learn.cn.com.happytolearn.ui.me.UserInfo;


/**
 * Created by LIBO on 2017/4/6.
 */

public class MeFragment extends Fragment {
    View view;
    @BindView(R.id.me_curriculum)
    RelativeLayout meCurriculum;
    @BindView(R.id.me_collection)
    RelativeLayout meCollection;
    @BindView(R.id.xiaoxi)
    RelativeLayout xiaoxi;
    @BindView(R.id.yijian)
    RelativeLayout yijian;
    @BindView(R.id.info)
    RelativeLayout info;
    @BindView(R.id.me_follow)
    RelativeLayout meFollow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        view = inflater.inflate(R.layout.fragment_me, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.me_collection, R.id.me_curriculum, R.id.xiaoxi, R.id.yijian, R.id.info,R.id.me_follow})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.me_curriculum:
                startActivity(new Intent(getActivity(), MyCourseActivity.class));
                break;
            case R.id.me_collection:
                startActivity(new Intent(getActivity(), CollectionActivity.class));
                break;
            case R.id.xiaoxi:
                startActivity(new Intent(getActivity(), NewsActivity.class));
                break;
            case R.id.yijian:
                startActivity(new Intent(getActivity(), OpinionActivity.class));
                break;
            case R.id.info:
                startActivity(new Intent(getActivity(), UserInfo.class));
                break;
            case R.id.me_follow:
                startActivity(new Intent(getActivity(), MefollowActivity.class));
                break;
        }
    }
}
