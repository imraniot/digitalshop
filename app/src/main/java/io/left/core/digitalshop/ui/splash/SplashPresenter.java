/*
*  ****************************************************************************
*  * Created by : Azizul Islam on 13-Oct-17 at 4:02 PM.
*  * Email : azizul@w3engineers.com
*  *
*  * Last edited by : Azizul Islam on 13-Oct-17.
*  *
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
*  ****************************************************************************
*/
package io.left.core.digitalshop.ui.splash;

import android.text.TextUtils;

import io.left.core.digitalshop.data.helper.PreferenceKey;
import io.left.core.digitalshop.ui.base.BasePresenter;
import io.left.core.digitalshop.utils.helper.SharedPref;


public class SplashPresenter extends BasePresenter<SplashMvpView> {
    private final String TAG = getClass().getSimpleName();

    public void doAction() {
        if (TextUtils.isEmpty(SharedPref.read(PreferenceKey.MY_USER_NAME_KEY))) {
            getMvpView().goToNextPage(false);
        } else {
            getMvpView().goToNextPage(true);
        }
    }
}