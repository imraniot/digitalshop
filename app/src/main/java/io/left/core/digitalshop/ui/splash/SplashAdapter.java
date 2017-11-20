package io.left.core.digitalshop.ui.splash;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.left.core.digitalshop.data.model.User;
import io.left.core.digitalshop.ui.base.BaseAdapter;
import io.left.core.digitalshop.ui.base.BaseViewHolder;


public class SplashAdapter extends BaseAdapter<User> {

    @Override
    public BaseViewHolder newViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return 0;
    }

    @Override
    protected User getObjForPosition(int position) {
        return null;
    }

    @Override
    public boolean isEqual(User left, User right) {
        return false;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        User user = getItem(position);
        if (user == null) return;

        if (holder instanceof SimpleViewHolder) {
            SimpleViewHolder viewHolder = (SimpleViewHolder) holder;
            viewHolder.bind(user);
        }
    }

    private class SimpleViewHolder extends BaseViewHolder<User> {
        private TextView textView;

        public SimpleViewHolder(View itemView) {
            super(itemView);
        }
        @Override
        public void bind(User item) {
            //textView.setText(item.getUserName());
        }
    }
}
