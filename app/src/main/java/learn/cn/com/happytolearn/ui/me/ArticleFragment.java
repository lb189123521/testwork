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
import butterknife.ButterKnife;
import learn.cn.com.happytolearn.R;
import learn.cn.com.happytolearn.ui.adapter.CommenAdapter;
import learn.cn.com.happytolearn.ui.adapter.ViewHolder;

/**
 * Created by LIBO on 2017/4/7.
 * 文章
 */

public class ArticleFragment extends Fragment {

    CommenAdapter adapter;
    List<String> list = new ArrayList<String>();
    @BindView(R.id.wz_lv)
    ListView wzLv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_article, container, false);
        ButterKnife.bind(this, view);
        getdata();
        return view;
    }

    public void getdata() {
        for (int i = 0; i < 4; i++) {
            list.add("1");
        }
        wzLv.setAdapter(adapter = new CommenAdapter(getActivity(), list, R.layout.adapter_honme) {
            @Override
            public void convert(ViewHolder holder, Object o) {

            }
        });

    }
}
