package learn.cn.com.happytolearn.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import learn.cn.com.happytolearn.R;
import learn.cn.com.happytolearn.ui.adapter.CommenAdapter;
import learn.cn.com.happytolearn.ui.adapter.ViewHolder;
import learn.cn.com.happytolearn.ui.me.MyCourseActivity;
import learn.cn.com.happytolearn.ui.train.DetailsActivity;
import learn.cn.com.happytolearn.utils.GlideImageLoader;

/**
 * Created by LIBO on 2017/4/6.
 */

public class TrainFragment extends Fragment {
    View view;
    @BindView(R.id.train_lv)
    ListView trainLv;
    CommenAdapter adapter;
    List<String> list = new ArrayList<String>();
    /*List<String> list1 = new ArrayList<String>();*/
    List<Integer> list1 = new ArrayList<Integer>();
    Banner banner;
    @BindView(R.id.train_search)
    ImageView trainSearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        view = inflater.inflate(R.layout.fragment_train, null);
        ButterKnife.bind(this, view);
        getdata();
        init();
        setbanner();
        return view;
    }

    private void init() {
        trainLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("libo", "============");
                startActivity(new Intent(getActivity(), DetailsActivity.class));
            }
        });
    }

    public void getdata() {
        for (int i = 0; i < 10; i++) {
            list.add("1");
        }
        trainLv.setAdapter(adapter = new CommenAdapter(getActivity(), list, R.layout.adapter_train) {
            @Override
            public void convert(ViewHolder holder, Object o) {

            }
        });
    }

    private void setbanner() {
       /* list1.add("http://f.hiphotos.baidu.com/image/pic/item/0df3d7ca7bcb0a46dfd3acd76f63f6246a60af6e.jpg");
        list1.add("http://d.hiphotos.baidu.com/image/pic/item/562c11dfa9ec8a13f075f10cf303918fa1ecc0eb.jpg");
        list1.add("http://a.hiphotos.baidu.com/image/pic/item/8601a18b87d6277f1ee195d42c381f30e824fc6f.jpg");*/
        list1.add(R.mipmap.banner1);
        list1.add(R.mipmap.banner2);
        list1.add(R.mipmap.bannner_kecheng);
        banner = (Banner) view.findViewById(R.id.train_banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(list1);
        //设置banner动画效果
        // banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        // banner.setBannerTitles(mlist);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                switch (position) {
                    case 0:
                        Log.i("libo", "00000000");
                        break;
                    case 1:
                        Log.i("libo", "1111111");
                        break;
                    case 2:
                        Log.i("libo", "22222222");
                        break;
                }
            }
        });
    }

    //如果你需要考虑更好的体验，可以这么操作
    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }

    @OnClick(R.id.train_search)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.train_search:
                startActivity(new Intent(getActivity(), MyCourseActivity.class));
                break;
        }
    }
}
