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
package io.left.core.digitalshop.ui.login;

import android.graphics.Bitmap;

import io.left.core.digitalshop.ui.base.MvpView;


public interface LoginMvpView extends MvpView {

    void goToNext();

    void onUserNameError(String error);
}
