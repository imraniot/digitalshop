package io.left.core.digitalshop.ui.base;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/*
*  ****************************************************************************
*  * Created by : Md Imran Hossain on 17-Nov-17 at 4:02 PM.
*  * Email : sudipta@w3engineers.com
*  *
*  * Responsibility: Abstract activity that every other Activity in this application must implement.
*  *
*  * Last edited by : Imran on 02-11-17.
*  *
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
*  ****************************************************************************
*/
public abstract class BaseActivity<V extends MvpView, P extends BasePresenter<V>>
        extends AppCompatActivity implements MvpView, View.OnClickListener {

    /**
     * LifecycleRegistry is an implementation of Lifecycle that can handle multiple observers.
     * It is used by Fragments and Support Library Activities.
     * You can also directly use it if you have a custom LifecycleOwner.
     */
    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    protected P presenter;

    protected ViewDataBinding viewDataBinding;
    private Menu menu;
    private int mDefaultValue = -1;


    /**
     * its built in method in Fragment Activity
     * that is extends by AppCompatActivity
     *
     * @return
     */
    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }

    protected abstract int getLayoutId();

    protected int getToolbarId() {
        return mDefaultValue;
    }

    protected int getMenuId() {
        return mDefaultValue;
    }

    protected int statusBarColor() {
        return mDefaultValue;
    }

    @SuppressWarnings("unchecked")
    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startUI();
    }

    protected void startUI() {

        int layoutId = getLayoutId();
        if (layoutId > mDefaultValue) {
            viewDataBinding = DataBindingUtil.setContentView(this, layoutId);

            BaseViewModel<V, P> viewModel = ViewModelProviders.of(this).get(BaseViewModel.class);
            boolean isPresenterCreated = false;
            if (viewModel.getPresenter() == null) {
                viewModel.setPresenter(initPresenter());
                isPresenterCreated = true;
            }
            presenter = viewModel.getPresenter();
            presenter.attachLifecycle(getLifecycle());
            presenter.attachView((V) this);
            if (isPresenterCreated) {
                presenter.onPresenterCreated();
            }

            int toolbarId = getToolbarId();

            setStatusBarColor();

            if (toolbarId > mDefaultValue) {
                Toolbar toolbar = findViewById(toolbarId);

                if (toolbar != null) {
                    setSupportActionBar(toolbar);
                }

                ActionBar actionBar = getSupportActionBar();
                if (actionBar != null) {
                    actionBar.setDisplayHomeAsUpEnabled(true);
                    actionBar.setDisplayShowHomeEnabled(true);
                }
            }
        }
    }

    protected ViewDataBinding getViewDataBinding() {
        return viewDataBinding;
    }

    private void setStatusBarColor() {

        int statusBarColor = statusBarColor();

        if (statusBarColor > 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = this.getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                }
                window.setStatusBarColor(ContextCompat.getColor(this, statusBarColor));
            }
        }
    }

    @Override
    public void onClick(View view) {

    }

    protected Menu getMenu(){
        return menu;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getMenuId() > mDefaultValue) {
            getMenuInflater().inflate(getMenuId(), menu);
            this.menu = menu;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void refreshMenu() {
        supportInvalidateOptionsMenu();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachLifecycle(getLifecycle());
        presenter.detachView();
    }

    protected void stopUI() {
        onDestroy();
    }

    protected abstract P initPresenter();

    public void setTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    public void setSubtitle(String subtitle) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setSubtitle(subtitle);
        }
    }

    protected void commitFragment(int parentId, BaseFragment baseFragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(parentId, baseFragment, baseFragment.getClass().getName())
                .commit();

        setCurrentFragment(baseFragment);
    }

    protected void setCurrentFragment(BaseFragment baseFragment) {
        this.mBaseCurrentFragment = baseFragment;
    }

    protected BaseFragment mBaseCurrentFragment;

    protected BaseFragment getBaseCurrentFragment() {
        return mBaseCurrentFragment;
    }
}
