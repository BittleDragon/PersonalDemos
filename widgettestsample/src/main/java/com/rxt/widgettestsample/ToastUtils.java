package com.rxt.widgettestsample;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by raoxuting on 2017/7/26.
 */

public class ToastUtils {

    private static Toast toast;

    public static void show(Context context, String s) {

        if (toast == null) {
            toast = Toast.makeText(context, s, Toast.LENGTH_SHORT);
        } else {
            toast.setText(s);
        }
        toast.show();
    }
}
