package learn.cn.com.happytolearn.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import learn.cn.com.happytolearn.R;
import learn.cn.com.happytolearn.ui.adapter.CommenAdapter;
import learn.cn.com.happytolearn.ui.adapter.HomeGridAdapter;
import learn.cn.com.happytolearn.ui.adapter.ViewHolder;
import learn.cn.com.happytolearn.utils.GlideImageLoader;
import learn.cn.com.happytolearn.utils.MyListView;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by LIBO on 2017/4/6.
 */

public class HomeFragment extends Fragment {
    View view;
    public static String loc;
    @BindView(R.id.home_lv)
    MyListView homeLv;
    CommenAdapter adapter;
    List<String> list = new ArrayList<String>();
    @BindView(R.id.home_sp)
    SwipeRefreshLayout homeSp;
    Banner banner;
   // List<String> list1 = new ArrayList<String>();
   List<Integer> list1 = new ArrayList<Integer>();
    @BindView(R.id.home_grid)
    GridView homeGrid;
    HomeGridAdapter homeGridAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
        init();
        setbanner();
        getdata();
        return view;
    }

    private void setbanner() {
       /* list1.add("http://g.hiphotos.baidu.com/image/pic/item/91ef76c6a7efce1b5b6d3e18ab51f3deb58f659a.jpg");
        list1.add("http://h.hiphotos.baidu.com/image/pic/item/eaf81a4c510fd9f95090a3bb212dd42a2934a459.jpg");
        list1.add("http://a.hiphotos.baidu.com/image/pic/item/9358d109b3de9c8231050f5d6881800a18d84384.jpg");*/
        list1.add(R.mipmap.banner1);
        list1.add(R.mipmap.banner2);
        list1.add(R.mipmap.bannner_kecheng);
        Integer[] images = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
        banner = (Banner) view.findViewById(R.id.banner);
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

    private void init() {
        homeSp.setColorSchemeResources(android.R.color.holo_blue_light);
        homeSp.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Observable observable = Observable.create(new Observable.OnSubscribe<Integer>() {

                    @Override
                    public void call(Subscriber<? super Integer> subscriber) {
                        subscriber.onNext(1);
                    }

                });
                observable.delay(1, TimeUnit.SECONDS).
                        subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(Object o) {
                                homeSp.setRefreshing(false);
                            }
                        });
            }
        });
    }

    public void getdata() {
        for (int i = 0; i < 4; i++) {
            list.add("1");
        }
        homeLv.setAdapter(adapter = new CommenAdapter(getActivity(), list, R.layout.adapter_honme) {
            @Override
            public void convert(ViewHolder holder, Object o) {

            }
        });
        homeGrid.setAdapter(adapter = new CommenAdapter(getActivity(), list, R.layout.adapter_home) {
            @Override
            public void convert(ViewHolder holder, Object o) {

            }
        });
       // homeGrid.setAdapter( homeGridAdapter=new HomeGridAdapter(getActivity(),list));
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
}
