package learn.cn.com.happytolearn.ui.me;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import learn.cn.com.happytolearn.R;
import learn.cn.com.happytolearn.ui.adapter.CommenAdapter;
import learn.cn.com.happytolearn.ui.adapter.ViewHolder;

/**
 *
 Collection
 收藏
 */
public class MefollowActivity extends AppCompatActivity {

    @BindView(R.id.gz_lv)
    ListView gzLv;
    CommenAdapter adapter;
    List<String> list = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mefollow);
        ButterKnife.bind(this);
        getdata();
    }

    @OnClick(R.id.img_back)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
               finish();
                break;
        }
    }
    public void getdata() {
        for (int i = 0; i < 4; i++) {
            list.add("1");
        }
        gzLv.setAdapter(adapter = new CommenAdapter(this, list, R.layout.adapter_follow) {
            @Override
            public void convert(ViewHolder holder, Object o) {

            }
        });

    }
}
