package io.left.core.digitalshop.ui.login;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.ViewUtils;
import android.text.Editable;


import io.left.core.digitalshop.R;
import io.left.core.digitalshop.ui.base.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginMvpView> {
    private final String TAG = getClass().getName();


    public void validPassword(Context context, Editable text) {

        String userPassword = text.toString().trim();

        if (userPassword.isEmpty()) {
            getMvpView().onUserNameError(context.getString(R.string.password_blank));
            return;
        }

        if (userPassword.length() < 6) {
            getMvpView().onUserNameError(context.getString(R.string.password_min_eight_character));
            return;
        }

        getMvpView().goToNext();
    }
}
