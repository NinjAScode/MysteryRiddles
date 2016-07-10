package ninjascode.mysteryriddles.app.common;

import android.content.Context;
import android.widget.Toast;

import java.text.SimpleDateFormat;

/**
 * Created by svetla.ivanova on 10.7.2016 г..
 */
public class Helper {
    private static SimpleDateFormat formatter;
    private static SimpleDateFormat noMsFormatter;
    private static SimpleDateFormat dayDateFormatter;

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

    public static SimpleDateFormat getDateFormatter() {
        if (formatter == null) {
            formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S");
            formatter.setLenient(false);
        }

        return formatter;
    }

    public static SimpleDateFormat getNoMsDateFormatter() {
        if (noMsFormatter == null) {
            noMsFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            noMsFormatter.setLenient(false);
        }

        return noMsFormatter;
    }

    public static SimpleDateFormat getShortDateFormatter() {
        if (dayDateFormatter == null) {
            dayDateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            dayDateFormatter.setLenient(false);
        }

        return dayDateFormatter;
    }
}
