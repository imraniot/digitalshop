package io.left.core.digitalshop.utils;/*
package io.left.digitalblock.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import io.left.core.flare.R;

*/
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
*//*

public class Glider {
    static Context thisContext;

    public static void init(Context context) {
        thisContext = context;
    }

    public static void show(String location, ImageView imageView) {
        try {
            if (location != null && !location.isEmpty() && imageView != null && thisContext != null) {
                Glide.with(thisContext)
                        .load(location)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                        .into(imageView);
            }
        } catch (Exception e) {
        }
    }

    public static void showCircular(ImageView imageView, Object location) {
        if (location != null && imageView != null && thisContext != null) {

            Glide.with(thisContext)
                    .load(location)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(imageView);
        }
    }

    public static void showWithPlaceholder(ImageView imageView, String location) {
        if (location != null && imageView != null && thisContext != null) {
            Glide.with(thisContext)
                    .load(location)
                    .placeholder(R.drawable.photo_male_8)
                    .into(imageView);

        }
    }

    public static void loadUserAvatar(String path, ImageView imageView){
        if(imageView == null) return;
        Glide.with(thisContext.getApplicationContext())
                .load(path)   //passing your url to load image.
                .override(18, 18)  //just set override like this
                .error(R.drawable.photo_male_8)
                .centerCrop()
                .into(imageView);
    }
}*/
