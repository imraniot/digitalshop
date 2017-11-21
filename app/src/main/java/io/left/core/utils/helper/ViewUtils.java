package io.left.core.utils.helper;

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



}
