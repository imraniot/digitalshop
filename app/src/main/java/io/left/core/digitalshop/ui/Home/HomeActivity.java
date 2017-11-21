package io.left.core.digitalshop.ui.Home;

import android.content.Context;
import android.content.Intent;

import io.left.core.digitalshop.R;
import io.left.core.digitalshop.ui.base.BaseActivity;

public class HomeActivity extends BaseActivity<HomeMvpView, HomePresenter> implements HomeMvpView {

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        return intent;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void startUI() {
        super.startUI();
    }


    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }
}
