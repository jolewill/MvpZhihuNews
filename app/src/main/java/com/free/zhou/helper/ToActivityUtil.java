package com.free.zhou.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import java.util.List;

/**
 *

 *
 */
public class ToActivityUtil {

    /**
     * @param packageContext
     * @param action         ��������Intent
     * @Description: ��ʽ����,��ת
     */
    public static void startActivityIntentSafe(Context packageContext,
                                               Intent action) {
        // Verify it resolves
        PackageManager packageManager = packageContext.getPackageManager();
        List activities = packageManager.queryIntentActivities(action,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;

        // Start an activity if it's safe
        if (isIntentSafe) {
            packageContext.startActivity(action);
        }

    }

    /**
     * @param packageContext
     * @param cls
     * @param keys
     * @param values         �ֶ��ı�int[] values����,���Դ���������������,�Ͳ�������
     * @Description: ��ת,�������ķ���;��Ҫ��������������,�ټ������ذ�,��ʱֻд��ô���,���岻��
     */
    public static void toNextActivity(Context packageContext, Class<?> cls,
                                      String[] keys, int[] values) {
        Intent i = new Intent(packageContext, cls);
        for (int j = 0; j < values.length; j++) {
            i.putExtra(keys[j], values[j]);
        }
        packageContext.startActivity(i);

    }


    public static void toNextActivity(Context packageContext, Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(packageContext, cls);
        intent.putExtras(bundle);
        packageContext.startActivity(intent);
    }

    /**
     * @param packageContext from,һ�㴫XXXActivity.this
     * @param cls            to,һ�㴫XXXActivity.class
     * @Description: ��ת
     */
    public static void toNextActivity(Context packageContext, Class<?> cls) {
        Intent i = new Intent(packageContext, cls);
        packageContext.startActivity(i);
    }

    /**
     * @param packageContext
     * @param cls
     * @param keyvalues      ��Ҫ����ȥ��String����{{key1,values},{key2,value2}...}
     * @Description: ��ת,�������ķ���;��Ҫ��������������,�ټ������ذ�
     */
    public static void toNextActivity(Context packageContext, Class<?> cls,
                                      String[][] keyvalues) {
        Intent i = new Intent(packageContext, cls);
        Bundle bundle = new Bundle();
        for (String[] strings : keyvalues) {
            bundle.putString(strings[0], strings[1]);
        }
        i.putExtras(bundle);
        packageContext.startActivity(i);

    }

    public static void toNextActivityAndFinish(Context packageContext,
                                               Class<?> cls) {
        Intent i = new Intent(packageContext, cls);
        packageContext.startActivity(i);

        ((Activity) packageContext).finish();
    }

    public static void finish(Activity activity) {
        activity.finish();
    }


}
