package learn.cn.com.happytolearn.ui.train;

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

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.jg_js)
    Button jgJs;
    @BindView(R.id.px_js)
    Button pxJs;
    @BindView(R.id.zx_ly)
    Button zxLy;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.view3)
    View view3;
    public Fragment mTab01,mTab02,mTab03;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        setSelect(0);
    }

    @OnClick({R.id.jg_js, R.id.px_js, R.id.zx_ly})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.jg_js:
                setSelect(0);
                break;
            case R.id.px_js:
                setSelect(1);
                break;
            case R.id.zx_ly:
                setSelect(2);
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
                    mTab01 = new JGDetailsFragment();

                    transaction.add(R.id.tab_fragment4, mTab01);

                } else {

                    transaction.show(mTab01);
                }



                view1.setVisibility(View.VISIBLE);
                view2.setVisibility(View.INVISIBLE);
                view3.setVisibility(View.INVISIBLE);
                break;
            case 1:
                if (mTab02 == null) {
                    mTab02 = new PXIntroduceFragment();
                    transaction.add(R.id.tab_fragment4, mTab02);
                } else {
                    transaction.show(mTab02);

                }

                view2.setVisibility(View.VISIBLE);
                view1.setVisibility(View.INVISIBLE);
                view3.setVisibility(View.INVISIBLE);
                break;
            case 2:
                if (mTab03 == null) {
                    mTab03 = new OnlineMessageFragment();
                    transaction.add(R.id.tab_fragment4, mTab03);
                } else {
                    transaction.show(mTab03);

                }
                view3.setVisibility(View.VISIBLE);
                view2.setVisibility(View.INVISIBLE);
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
        if (mTab03 != null) {
            transaction.hide(mTab03);
        }
    }
}
