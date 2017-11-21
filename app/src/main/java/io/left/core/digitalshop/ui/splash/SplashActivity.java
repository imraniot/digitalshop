

package io.left.core.digitalshop.ui.splash;

import android.content.Intent;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import io.left.core.digitalshop.R;
import io.left.core.digitalshop.databinding.ActivitySplashBinding;
import io.left.core.digitalshop.ui.base.BaseActivity;


public class SplashActivity extends BaseActivity<SplashMvpView, SplashPresenter> implements SplashMvpView {
    private static final int SPLASH_TIME = 3000;

    private ActivitySplashBinding activitySplashBinding;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void startUI() {
        super.startUI();

        activitySplashBinding = (ActivitySplashBinding) getViewDataBinding();


        Animation downtop = AnimationUtils.loadAnimation(this, R.anim.downtop);
        activitySplashBinding.appName.setAnimation(downtop);

        presenter.doAction();
    }

    @Override
    protected void stopUI() {
        super.stopUI();
    }

    @Override
    protected SplashPresenter initPresenter() {
        return new SplashPresenter();
    }

    @Override
    public void goToNextPage() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                finish();
            }
        }, SPLASH_TIME);
    }
}
