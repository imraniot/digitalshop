package io.left.core.digitalshop.ui.base;

import android.view.View;

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

public interface ItemClickListener<T>{
    void onItemClick(View view, T item);
}
