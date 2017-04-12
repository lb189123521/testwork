package learn.cn.com.happytolearn;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import learn.cn.com.happytolearn.ui.fragment.HomeFragment;
import learn.cn.com.happytolearn.ui.fragment.MeFragment;
import learn.cn.com.happytolearn.ui.fragment.TrainFragment;


public class MainActivity extends FragmentActivity {


    @BindView(R.id.fragment)
    FrameLayout fragment;
    @BindView(R.id.image_home)
    ImageView imageHome;
    @BindView(R.id.text_home)
    TextView textHome;
    @BindView(R.id.layout_home)
    LinearLayout layoutHome;
    @BindView(R.id.image_train)
    ImageView imageTrain;
    @BindView(R.id.text_train)
    TextView textTrain;
    @BindView(R.id.layout_train)
    LinearLayout layoutTrain;
    @BindView(R.id.image_me)
    ImageView imageMe;
    @BindView(R.id.text_me)
    TextView textMe;
    @BindView(R.id.layout_me)
    LinearLayout layoutMe;
    public Fragment mTab01,mTab02,mTab03;
    private LocationClient locationClient;
    String ss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //核心代码.
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            //给状态栏设置颜色。我设置透明。
            window.setStatusBarColor(Color.TRANSPARENT);//设置状态栏颜色
            window.setNavigationBarColor(Color.TRANSPARENT);//设置导航栏颜色
        }*/
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSelect(0);
       // locationClient= new LocationClient(this);
        //locationClient.registerLocationListener(locListener);
        //initLoctionOption();
      //  locationClient.start();//默认发起1次请求
    }


    @OnClick({R.id.layout_home, R.id.layout_train, R.id.layout_me})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_home:
                setSelect(0);
                break;
            case R.id.layout_train:
                setSelect(1);
                break;
            case R.id.layout_me:
                setSelect(2);
                break;
        }
    }
    private void setSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        resetNavigation();
        hideFragment(transaction);
        // 把图片设置为亮的
        // 设置内容区域
        switch (i) {
            case 0:
                if (mTab01 == null) {
                    mTab01 = new HomeFragment();

                    transaction.add(R.id.fragment, mTab01);

                } else {

                    transaction.show(mTab01);
                }

                imageHome.setBackgroundResource(R.mipmap.icon_shouye1);
                textHome.setTextColor(getResources().getColor(R.color.theme_color));


                break;
            case 1:
                if (mTab02 == null) {
                    mTab02 = new TrainFragment();
                    transaction.add(R.id.fragment, mTab02);
                } else {
                    transaction.show(mTab02);

                }
                imageTrain.setBackgroundResource(R.mipmap.icon_peixun1);
                textTrain.setTextColor(getResources().getColor(R.color.theme_color));
                break;
            case 2:
                if (mTab03 == null) {
                    mTab03 = new MeFragment();
                    transaction.add(R.id.fragment, mTab03);
                } else {
                    transaction.show(mTab03);
                }
                imageMe.setBackgroundResource(R.mipmap.icon_wode1);
                textMe.setTextColor(getResources().getColor(R.color.theme_color));
                break;

            default:
                break;
        }

        transaction.commit();
    }
    private void resetNavigation() {
		/* image_on_trial,image_task,image_qa,image_vip;
		 *
		 text_on_trial,text_task,text_qa,text_vip;*/
        imageHome.setBackgroundResource(R.mipmap.icon_shouye);
        textHome.setTextColor(getResources().getColor(R.color.text_color1));

        imageTrain.setBackgroundResource(R.mipmap.icon_peixun);
        textTrain.setTextColor(getResources().getColor(R.color.text_color1));

        imageMe.setBackgroundResource(R.mipmap.icon_wode);
        textMe.setTextColor(getResources().getColor(R.color.text_color1));

    }
    public void hideFragment(FragmentTransaction transaction) {
        if (mTab01 != null) {
            transaction.hide(mTab01);
        }
        if (mTab02 != null) {
            transaction.hide(mTab02);
        }
        if (mTab03 != null) {
            transaction.hide(mTab03);
        }


    }
    private BDLocationListener locListener=new BDLocationListener(){
        StringBuilder sb=new StringBuilder();
        @Override
        public void onReceiveLocation(BDLocation location) {
            //  sb.append("当前时间 : ");
            //	sb.append(location.getTime());

            //sb.append("\n定位类型 : ");
            //	sb.append(location.getLocType());

            //	sb.append("\n纬度 : ");
            //	sb.append(location.getLatitude());
            ///	sb.append("\n精度 : ");
            //	sb.append(location.getLongitude());
            //	sb.append("\n定位半径 : ");
            //	sb.append(location.getRadius());

            if (location.getLocType() == BDLocation.TypeNetWorkLocation){
                // 网络定位结果
                //	sb.append("\n国 省 市 区.. : ");
                //sb.append(location.getLocationDescribe())
                //	String s = 	sb.append(location.getLocationDescribe())+"";
                ss= sb.append(location.getAddrStr())+"";
                // 运营商信息
                //	sb.append("\n网络定位结果 :");
                //	sb.append("定位成功");
            }
            //sb.append("\n简略地址信息 : ");
            //sb.append(location.getLocationDescribe())+"";


            List<Poi> list = location.getPoiList();// 附近信息
            if (list != null){
                sb.append("\npoilist size = : ");
                sb.append(list.size());
                for (Poi p : list){
                    sb.append("\npoi= : ");
                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                }
            }
            Log.i("result:",sb.toString());
            HomeFragment.loc=ss;
        }

    };




    private void initLoctionOption(){
        LocationClientOption locOption=new LocationClientOption();
        //net loc
        locOption.setLocationMode(LocationClientOption.LocationMode.Battery_Saving);
        locOption.setCoorType("gcj02");// 定位结果坐标系
        locOption.setScanSpan(0);//定位请求的时间间隔，定位一次
        locOption.setIsNeedAddress(true);//设置是否需要地址信息
        locOption.setIsNeedLocationDescribe(true);//简单位置描述
        locOption.setIsNeedLocationPoiList(true);
        locOption.setIgnoreKillProcess(true);
        locationClient.setLocOption(locOption);
        locationClient.stop();
    }
    @Override
    protected void onStop() {
        super.onStop();
        //locationClient.stop();
    }

}