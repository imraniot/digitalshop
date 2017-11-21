package io.left.core.utils.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/*
*  ****************************************************************************
*  * File Name: SharedPref.java
*  * Uses: For all type of SharedPreferences functionality
*
*  * Created by : Imran process 17-Nov-17 at 6:35 PM.
*  * Email : sudipta@w3engineers.com
*  *
*  * Last edited by : Imran process 17-Nov-17 at 6:38 PM.
*  *
*  * Last Reviewed by : <Reviewer Name> process <mm/dd/yy>
*  ****************************************************************************
*/
public class SharedPref {
    private static SharedPreferences preferences;
    public static final String KEY_BOARD_HEIGHT = "keyboard_height";
    private SharedPref() {
    }

    public static void init(Context context) {
        if (preferences == null) {
            preferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
    }

    public static boolean write(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(key, value);

        return editor.commit();
    }

    public static boolean write(String key, boolean value) {
        SharedPreferences.Editor editor = preferences.edit();

        editor.putBoolean(key, value);

        return editor.commit();
    }

    public static boolean write(String key, int value) {
        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt(key, value);

        return editor.commit();
    }

    public static String read(String key) {
        return preferences.getString(key, "");
    }
    public static int readInt(String key) {
        return preferences.getInt(key, 0);
    }
    public static boolean readBoolean(String key) {
        return preferences.getBoolean(key, false);
    }
}