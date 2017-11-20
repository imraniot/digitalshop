package io.left.core.digitalshop.ui.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;


import io.left.core.digitalshop.utils.rx.AppSchedulerProvider;
import io.left.core.digitalshop.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
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
public abstract class BasePresenter<V extends MvpView> implements LifecycleObserver, Presenter<V> {

    /**
     * Marks a class as a LifecycleObserver.
     * It does not have any methods, instead,
     * relies process OnLifecycleEvent annotated methods.
     * <p>
     * class TestObserver implements LifecycleObserver {
     *
     * @OnLifecycleEvent(ON_CREATE) void onCreated(LifecycleOwner source) {}
     * @OnLifecycleEvent(ON_ANY) void onAny(LifecycleOwner source, Event event) {}
     * }
     */

    protected String TAG = getClass().getSimpleName();
    private V mMvpView;
    private Bundle stateBundle;

    private SchedulerProvider mSchedulerProvider = null;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    /*
    * Optional method for add  AppSchedulerProvider class in your Activity
    * */
    public void addScheduler() {
        this.mSchedulerProvider = new AppSchedulerProvider();
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    @Override
    public void attachView(V mvpView) {
        mMvpView = mvpView;
//        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void detachView() {
        mMvpView = null;

        if (mCompositeDisposable != null) mCompositeDisposable.dispose();

        mSchedulerProvider = null;
    }

    @Override
    public void attachLifecycle(Lifecycle lifecycle) {
        lifecycle.addObserver(this);
    }

    @Override
    public void detachLifecycle(Lifecycle lifecycle) {
        lifecycle.removeObserver(this);
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    /**
     * get MVP view of the Activity
     *
     * @return
     */
    public V getMvpView() {
        return mMvpView;
    }

    /**
     * get Activity bundle state
     *
     * @return
     */
    public Bundle getStateBundle() {
        return stateBundle == null ?
                stateBundle = new Bundle() : stateBundle;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }



    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }

    @Override
    public void onPresenterDestroy() {
        if (stateBundle != null && !stateBundle.isEmpty()) {
            stateBundle.clear();
        }
    }

    @Override
    public void onPresenterCreated() {
        //NO-OP
    }
}

