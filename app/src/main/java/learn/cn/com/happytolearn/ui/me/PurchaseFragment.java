package learn.cn.com.happytolearn.ui.me;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import learn.cn.com.happytolearn.R;
import learn.cn.com.happytolearn.ui.adapter.CommenAdapter;
import learn.cn.com.happytolearn.ui.adapter.ViewHolder;

/**
 * 购买
 */
public class PurchaseFragment extends Fragment {

    @BindView(R.id.kc_grid)
    GridView kcGrid;
    CommenAdapter adapter;
    List<String> list = new ArrayList<String>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_browse, container, false);
        ButterKnife.bind(this, view);
        getdata();
        return view;
    }

    public void getdata() {
        for (int i = 0; i < 2; i++) {
            list.add("1");
        }

        kcGrid.setAdapter(adapter = new CommenAdapter(getActivity(), list, R.layout.adapter_home) {
            @Override
            public void convert(ViewHolder holder, Object o) {

            }
        });
        // homeGrid.setAdapter( homeGridAdapter=new HomeGridAdapter(getActivity(),list));
    }

}
