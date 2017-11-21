package io.left.core.digitalshop.ui.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import io.left.core.digitalshop.R;
import io.left.core.digitalshop.databinding.ActivityLoginBinding;
import io.left.core.digitalshop.ui.base.BaseActivity;
import io.left.core.utils.helper.Toaster;

/**
 * Created by W3E04 on 11/20/2017.
 */

public class LoginActivity extends BaseActivity<LoginMvpView, LoginPresenter> implements LoginMvpView {

    private ActivityLoginBinding activityLoginBinding;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void startUI() {
        super.startUI();
        activityLoginBinding = (ActivityLoginBinding) getViewDataBinding();
        activityLoginBinding.buttonAccoutCreate.setOnClickListener(this);


        activityLoginBinding.editTextPass.setFocusable(true);
        activityLoginBinding.editTextPass.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    presenter.validPassword(LoginActivity.this, activityLoginBinding.editTextPass.getText());
                    return true;
                }

                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_accout_create:
                presenter.validPassword(this, activityLoginBinding.editTextPass.getText());
                break;
        }
    }


    @Override
    public void goToNext() {
        //startActivity(MainActivity.getStartIntent(this));
        finish();

    }

    @Override
    public void onUserNameError(String error) {
        Toaster.show(error);
    }
}
