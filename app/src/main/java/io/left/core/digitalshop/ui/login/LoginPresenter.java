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
import android.widget.ImageView;

import java.io.IOException;
import java.util.concurrent.Callable;


import io.left.core.digitalshop.ui.base.BasePresenter;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends BasePresenter<LoginMvpView> {
    private final String TAG = getClass().getName();

   /* public void processUriFromGallery(Uri imageUri, ContentResolver contentResolver) throws IOException {

        getCompositeDisposable().add(sampleObservable(imageUri, contentResolver)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).
                        subscribe(new Consumer<Bitmap>() {
                    @Override
                    public void accept(@NonNull Bitmap bitmap) throws Exception {
                        getMvpView().setProfileImage(bitmap);
                    }
                }));
    }

    private Observable<Bitmap> sampleObservable(final Uri imageUri, final ContentResolver contentResolver) {

        return Observable.defer(new Callable<ObservableSource<Bitmap>>() {
            @Override
            public ObservableSource<Bitmap> call() throws Exception {
                Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri);
                imageBitmap = ImageUtil.on().getProcessedLargeBitmap(imageBitmap);
                return Observable.just(imageBitmap);
            }
        });
    }

    public void processUserInfo(String userName, Bitmap profileBitmap) {
        if (profileBitmap != null) {

            ImageUtil.on().processImage(profileBitmap);

            String profilePath = DirectoryConstants.AVATAR_DIRECTORY + DirectoryConstants.MY_AVATAR_LARGE;
            String thumbPath = DirectoryConstants.AVATAR_DIRECTORY + DirectoryConstants.MY_AVATAR_THUMB;

            SharedPref.write(PreferenceKey.MY_USER_PROFILE_PATH_KEY, profilePath);
            SharedPref.write(PreferenceKey.MY_USER_PROFILE_THUMB_KEY, thumbPath);

            ViewUtils.isScanMedia(profilePath, thumbPath);
        }

        SharedPref.write(PreferenceKey.MY_USER_NAME_KEY, userName);

        getMvpView().goToNext();
    }

    public void saveProfile(Context context, Editable text, ImageView bitmap, boolean isImageChange) {
        String userName = text.toString().trim();

        if (ViewUtils.isEmpty(userName)) {
            getMvpView().onUserNameError(context.getString(R.string.error_invalid_username));
           // userName = SharedPref.read(PreferenceKey.MY_USER_NAME_KEY);
        }

        if (userName.length() < 2) {
            getMvpView().onUserNameError(context.getString(R.string.error_minimum_two_char_username));
            return;

        }

        if (!ProfileUtil.isUserNameValid(userName)) {
            getMvpView().onUserNameError(context.getString(R.string.error_invalid_username));
            return;
        }

        if (isImageChange) {
            if (PermissionUtil.on().requestPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                if (bitmap != null)
                    processUserInfo(userName, ((BitmapDrawable) bitmap.getDrawable()).getBitmap());
            }
        } else {
            processUserInfo(userName, null);
        }
    }*/
}
