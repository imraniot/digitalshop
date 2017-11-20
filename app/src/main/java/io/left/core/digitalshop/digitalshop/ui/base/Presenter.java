package io.left.core.digitalshop.digitalshop.ui.base;

import android.arch.lifecycle.Lifecycle;

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();

    void attachLifecycle(Lifecycle lifecycle);

    void detachLifecycle(Lifecycle lifecycle);

    void onPresenterCreated();

    void onPresenterDestroy();

}
