/*


package io.left.core.digitalshop.ui.splash;

import android.content.Intent;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import io.left.core.digitalshop.R;
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

        stopService();

        Animation downtop = AnimationUtils.loadAnimation(this, R.anim.downtop);

        activitySplashBinding.textAppName.setAnimation(downtop);

        presenter.doAction();
    }

    private void stopService() {
       // if (ViewUtils.isServiceRunning(FlareService.class, this)) {
            stopService(new Intent(this, FlareService.class));
       // }
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
    public void goToNextPage(final boolean isLogin) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isLogin) {
                    startActivity(MainActivity.getStartIntent(SplashActivity.this));
                } else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }
                finish();
            }
        }, SPLASH_TIME);
    }
}*/
