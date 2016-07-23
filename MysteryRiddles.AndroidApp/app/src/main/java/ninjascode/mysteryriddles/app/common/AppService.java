package ninjascode.mysteryriddles.app.common;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import ninjascode.mysteryriddles.R;

/**
 * Created by svetla.ivanova on 10.7.2016 г..
 */
public class AppService {
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

    public static void setToolbarLogo(AppCompatActivity activity){
        // Display icon in the toolbar
        activity.getSupportActionBar().setDisplayShowHomeEnabled(true);
        activity.getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        activity.getSupportActionBar().setDisplayUseLogoEnabled(true);
    }

    public static void setToolbarTitle(AppCompatActivity activity, Toolbar toolbar){
        // Remove default title text
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);

        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        UiService.setTypeface(activity, GlobalConstants.CONTENT_FONT_PATH, toolbarTitle);
    }
}
