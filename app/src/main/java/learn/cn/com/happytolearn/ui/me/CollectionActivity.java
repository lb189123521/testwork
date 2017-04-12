package learn.cn.com.happytolearn.ui.me;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import learn.cn.com.happytolearn.R;

/**
 * 收藏
 */
public class CollectionActivity extends AppCompatActivity {

    @BindView(R.id.shipin)
    Button shipin;
    @BindView(R.id.wenzhang)
    Button wenzhang;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.view2)
    View view2;
    public Fragment mTab01,mTab02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        ButterKnife.bind(this);
        setSelect(0);
    }

    @OnClick({R.id.shipin, R.id.wenzhang})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shipin:
                setSelect(0);
                break;
            case R.id.wenzhang:
                setSelect(1);
                break;
        }
    }
    private void setSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);

        switch (i) {
            case 0:
                if (mTab01 == null) {
                    mTab01 = new videoFragment();

                    transaction.add(R.id.tab_fragment1, mTab01);

                } else {

                    transaction.show(mTab01);
                }



                view1.setVisibility(View.VISIBLE);
                view2.setVisibility(View.INVISIBLE);
                break;
            case 1:
                if (mTab02 == null) {
                    mTab02 = new ArticleFragment();
                    transaction.add(R.id.tab_fragment1, mTab02);
                } else {
                    transaction.show(mTab02);

                }

                view2.setVisibility(View.VISIBLE);
                view1.setVisibility(View.INVISIBLE);
                break;

            default:
                break;
        }

        transaction.commit();
    }

    public void hideFragment(FragmentTransaction transaction) {
        if (mTab01 != null) {
            transaction.hide(mTab01);
        }
        if (mTab02 != null) {
            transaction.hide(mTab02);
        }

    }
}
