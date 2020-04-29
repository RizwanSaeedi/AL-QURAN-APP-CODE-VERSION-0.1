package quran.islamic.soft.saeedi.com.alquran;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.widget.*;

/**
 * Created by soft on 4/23/2017.
 */

public class SettingsHelper
{
    public static void setFont(Activity context, String font, EditText et)
    {
        Typeface face = Typeface.createFromAsset(context.getAssets(), font + ".ttf");
        et.setTypeface(face);
    }

    public static void setFont(Context context, String font, EditText et)
    {
        Typeface face = Typeface.createFromAsset(context.getAssets(), font + ".ttf");
        et.setTypeface(face);
    }

    public static Typeface setFont(Context context, String font)
    {
        Typeface face = Typeface.createFromAsset(context.getAssets(), font + ".ttf");
        return face;
    }
}
