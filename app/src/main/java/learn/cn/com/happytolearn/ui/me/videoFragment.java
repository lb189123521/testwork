package learn.cn.com.happytolearn.ui.me;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import learn.cn.com.happytolearn.R;
import learn.cn.com.happytolearn.ui.adapter.CommenAdapter;
import learn.cn.com.happytolearn.ui.adapter.ViewHolder;

/**
 * Created by LIBO on 2017/4/7.
 * 视频
 */

public class videoFragment extends Fragment {
    //@BindView(R.id.gz_lv)
    ListView gzLv;
    CommenAdapter adapter;
    List<String> list = new ArrayList<String>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //getdata();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false);
    }


    public void getdata() {
        for (int i = 0; i < 4; i++) {
            list.add("1");
        }
        gzLv.setAdapter(adapter = new CommenAdapter(getActivity(), list, R.layout.adapter_follow) {
            @Override
            public void convert(ViewHolder holder, Object o) {

            }
        });

    }
}
