package io.left.core.utils.helper;

import android.content.Context;
import android.widget.Toast;

public class Toaster {
    private static Context sContext;

    private Toaster() {
    }

    public static void init(Context context) {
        sContext = context;
    }

    public static void show(String txt) {
        Toast.makeText(sContext, txt, Toast.LENGTH_SHORT).show();
    }

    public static void showShort(String txt) {
        Toast.makeText(sContext, txt, Toast.LENGTH_SHORT).show();
    }
}