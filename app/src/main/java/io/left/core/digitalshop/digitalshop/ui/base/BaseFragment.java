package io.left.core.digitalshop.digitalshop.ui.base;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public abstract class BaseFragment<V extends MvpView, P extends BasePresenter<V>>
        extends Fragment implements MvpView, View.OnClickListener {

    /**
     * LifecycleRegistry is an implementation of Lifecycle that can handle multiple observers.
     * It is used by Fragments and Support Library Activities.
     * You can also directly use it if you have a custom LifecycleOwner.
     */
    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
    protected P presenter;
    private int mDefaultValue = -1;
    private ViewDataBinding viewDataBinding;

    protected int getLayoutId() {
        return mDefaultValue;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        int layoutId = getLayoutId();
        if (layoutId <= mDefaultValue) { // if default or invalid layout id, then no possibility to create view
            return super.onCreateView(inflater, container, savedInstanceState);
        }
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false);
        return viewDataBinding.getRoot();
    }

    @SuppressWarnings("unchecked")
    @CallSuper
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BaseViewModel<V, P> viewModel = ViewModelProviders.of(this).get(BaseViewModel.class);
        boolean isPresenterCreated = false;
        if (viewModel.getPresenter() == null) {
            viewModel.setPresenter(initPresenter());
            isPresenterCreated = true;
        }
        presenter = viewModel.getPresenter();
        presenter.attachLifecycle(getLifecycle());
        presenter.attachView((V) this);
        if (isPresenterCreated)
            presenter.onPresenterCreated();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        startUI();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }

    protected void startUI() {

    }

    protected ViewDataBinding getViewDataBinding() {
        return viewDataBinding;
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.detachLifecycle(getLifecycle());
            presenter.detachView();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected void stopUI() {
        onDestroy();
    }

    private BaseActivity getBaseActivity() {
        return ((BaseActivity) getActivity());
    }

    private boolean isBaseActivityInstance() {
        return BaseActivity.class.isInstance(getActivity());
    }

    protected void setTitle(String title) {
        if (isBaseActivityInstance()) {
            getBaseActivity().setTitle(title);
        }
    }

    protected void setSubtitle(String subtitle) {
        if (isBaseActivityInstance()) {
            getBaseActivity().setSubtitle(subtitle);
        }
    }

    protected abstract P initPresenter();
}
