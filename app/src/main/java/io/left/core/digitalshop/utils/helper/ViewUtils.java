/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 *//*


package io.left.core.digitalshop.utils.helper;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.TypedValue;
import android.view.View;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

import io.left.core.digitalshop.R;


*/
/**
 * Created by janisharali on 27/01/17.
 *//*


public final class ViewUtils {
    private Context context;

    public static final Semaphore LOCK = new Semaphore(0);

    private ViewUtils() {
        // This utility class is not publicly instantiable
    }

    private ViewUtils(Context context) {
        this.context = context;
    }


    public static float pxToDp(float px) {
        float densityDpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        return px / (densityDpi / 160f);
    }

    public static int dpToPx(float dp) {
        float density = Resources.getSystem().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

    public static void changeIconDrawableToGray(Context context, Drawable drawable) {
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(ContextCompat
                    .getColor(context, R.color.dark_gray), PorterDuff.Mode.SRC_ATOP);
        }
    }

    private static boolean isNull(Object view) {
        return view == null;
    }

    public static View getViewById(View parentView, int viewId) {
        if (!isNull(parentView) && viewId > 0) {
            return parentView.findViewById(viewId);
        }
        return null;
    }

    public static View getViewById(Activity activity, int viewId) {
        if (!isNull(activity) && viewId > 0) {
            return activity.findViewById(viewId);
        }
        return null;
    }

    public static RecyclerView getRecyclerView(Activity parentView, int resourceId) {
        View view = getViewById(parentView, resourceId);

        if (RecyclerView.class.isInstance(view)) {
            return (RecyclerView) view;
        }
        return null;
    }

    public static RecyclerView.LayoutManager newLinearLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }

    public static RecyclerView.LayoutManager newGridLayoutManager(Context context, int columns) {
        return new GridLayoutManager(context, columns);
    }


    public static RecyclerView.LayoutManager newStaggeredGridLayoutManager(int spanCount, int orientation) {
        return new StaggeredGridLayoutManager(spanCount, orientation);
    }

    public static RecyclerView.Adapter getAdapter(RecyclerView recyclerView) {
        if (recyclerView != null) {
            return recyclerView.getAdapter();
        }
        return null;
    }

    private static Handler backGroundThread;
    private static HandlerThread executor;

    public static void postBackground(Runnable runnable, long delay) {
        removeBackground(runnable);
        backGroundThread.postDelayed(runnable, delay);
    }

    private static void removeBackground(Runnable runnable) {
        resolveHandler();
        backGroundThread.removeCallbacks(runnable);
    }

    private static void resolveHandler() {
        if (executor == null) {
            executor = new HandlerThread("Backend_thread", Thread.MAX_PRIORITY);
            executor.start();
        }
        if (backGroundThread == null) {
            backGroundThread = new Handler(executor.getLooper());
        }
    }

    public static int getStatusBarHeight(Context context) {
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");

        if (resourceId > 0) {
            return context.getResources().getDimensionPixelSize(resourceId);
        }

        return 0;
    }

    public static int getActionBarHeight(Context context) {
        TypedValue tv = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true);

        int actionBarHeight = context.getResources().getDimensionPixelSize(tv.resourceId);

        if (actionBarHeight > 0) {
            return actionBarHeight;
        }
        return 0;
    }

    public static int getHeight(Context context) {
        //DisplayMetrics displayMetrics = new DisplayMetrics();

        return context.getResources().getDisplayMetrics().heightPixels;
    }



    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    public static void isScanMedia(String... paths) {
        MediaScannerConnection.scanFile(FlareApplication.getContext(), paths, null,
                new MediaScannerConnection.MediaScannerConnectionClient() {

                    @Override
                    public void onMediaScannerConnected() {

                    }

                    @Override
                    public void onScanCompleted(String s, Uri uri) {

                    }
                });
    }

    public static boolean isEmpty(String... strings) {
        for (String string : strings) {
            if (TextUtils.isEmpty(string))
                return true;
        }
        return false;
    }

    public static String lastUpdateDate(double value) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        String lastUpdatedTime = dateFormat.format(value);
        return "Updated at " + lastUpdatedTime;
    }

    public static String geoLocation(double latitute, double longitute) {
        return latitute + ", " + longitute;
    }

    public static String getDistance(String distance) {
        return String.valueOf(new DecimalFormat("##.##").format(distance));
    }

    public static boolean isServiceRunning(Class<?> serviceClass, Context context) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public static String getTimeAgo(long time, final Context context) {

        final int SECOND_MILLIS = 1000;
        final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
        final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
        final int DAY_MILLIS = 24 * HOUR_MILLIS;
        final long WEEK_IN_MILLIS = DAY_MILLIS * 7;
        final long YEAR_MILLIS = WEEK_IN_MILLIS * 52;
        final long FIVE_MINUTE_MILLIS = MINUTE_MILLIS * 5;

        if (time < 1000000000000L) {
            time *= 1000;
        }
        long now = TimeUtil.parseToLocalMilliFromMilli(System.currentTimeMillis());

        if (*/
/*headerTime > now || *//*
time <= 0) {
            String dateString = DateFormat.format("hh:mm a", new Date(now)).toString();
            return dateString;
        }

        long diff = now - time;

        //Fixme headerTime related work need to be done when the sender is using greater headerTime than receiver

        if (diff < 0L) {
            diff = -diff;
        }

        if (diff <= 2 * MINUTE_MILLIS) {
            return " " + context.getResources().getString(R.string.just_now);
        } else if (diff < 60 * MINUTE_MILLIS) {

            return diff / MINUTE_MILLIS + " " + context.getResources().getString(R.string.mins_ago);
        } else if (diff < 4 * HOUR_MILLIS) {
            if (diff >= 1 * HOUR_MILLIS && diff < 2 * HOUR_MILLIS) {
                return diff / HOUR_MILLIS + " " + context.getResources().getString(R.string.hour_ago);
            } else {
                return diff / HOUR_MILLIS + " " + context.getResources().getString(R.string.hours_ago);
            }
        } else if (diff < 24 * HOUR_MILLIS) {
            String dateString = DateFormat.format("hh:mm a", new Date(time)).toString();
            return dateString;
        } else if (diff < 7 * DAY_MILLIS) {
            return new SimpleDateFormat("EEEE").format(new Date(time));
        } else if (diff < 1 * YEAR_MILLIS) {

            int currentYear = TimeUtil.getYear(now);
            int timeYear = TimeUtil.getYear(time);

            if (currentYear != timeYear) {
                return DateFormat.format(" dd MMM yyyy ", new Date(time)).toString();
            }

            return DateFormat.format(" dd MMM", new Date(time)).toString();

        } else if (diff > 1 * YEAR_MILLIS) {
            String dateString = DateFormat.format(" dd MMM yyyy ", new Date(time)).toString();
            return dateString;
        } else {
            return diff / DAY_MILLIS + " " + context.getResources().getString(R.string.days_ago);
        }
    }


}
*/
