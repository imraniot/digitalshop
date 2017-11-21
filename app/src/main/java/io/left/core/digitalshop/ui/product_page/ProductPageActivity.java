package io.left.core.digitalshop.ui.product_page;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.left.core.digitalshop.R;
import io.left.core.digitalshop.ui.base.BaseActivity;

public class ProductPageActivity extends BaseActivity<ProductPageMvpView,ProductPagePresenter> implements ProductPageMvpView {

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);
    }

    @Override
    protected ProductPagePresenter initPresenter() {
        return new ProductPagePresenter();
    }
}
