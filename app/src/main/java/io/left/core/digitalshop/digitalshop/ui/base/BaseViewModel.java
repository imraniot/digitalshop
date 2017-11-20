package io.left.core.digitalshop.digitalshop.ui.base;

import android.arch.lifecycle.ViewModel;

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

public class BaseViewModel<V extends MvpView, P extends Presenter<V>> extends ViewModel {

    /**
     *  The ViewModel is automatically retained during configuration changes
     *  so the data it holds is immediately available to the next activity or
     *  fragment instance.
     *
     *  This will help us not to initialize the Presenter every headerTime.
     *  It will receive and return our presenter’s object.
     */


    private P presenter;

    void setPresenter(P presenter) {
        if (this.presenter == null) {
            this.presenter = presenter;
        }
    }

    P getPresenter() {
        return this.presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.onPresenterDestroy();
        presenter = null;
    }
}
