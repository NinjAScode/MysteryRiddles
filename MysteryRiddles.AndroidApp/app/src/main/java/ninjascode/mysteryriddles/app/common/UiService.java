package ninjascode.mysteryriddles.app.common;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

/**
 * Created by svetla.ivanova on 10.7.2016 г..
 */
public class UiService {
    public static void makeText(Context context, String message){
        Toast.makeText(
                context,
                message,
                Toast.LENGTH_SHORT).show();
    }

    public static void makeText(Context context, String message, int duration){
        Toast.makeText(
                context,
                message,
                duration).show();
    }

    public static void setTypeface(Context context, String fontPath, TextView... textView){
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontPath);
        for (TextView txt: textView) {
            txt.setTypeface(typeface);
        }
    }
}
