package ninjascode.mysteryriddles.app.common;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.widget.Toast;

import java.text.SimpleDateFormat;

import ninjascode.mysteryriddles.R;

/**
 * Created by svetla.ivanova on 10.7.2016 г..
 */
public class FragmentService {
    public static String getLatestBackStackEntryName(Activity context){
        FragmentManager fragmentManager = context.getFragmentManager();
        FragmentManager.BackStackEntry backEntry = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1);
        return backEntry.getName();
    }

    public static void getFragmentAnimated(Activity context, int containerId, Fragment fragment, String fragmentTag){
        FragmentTransaction ft = context.getFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.animator.fragment_fade_in, R.animator.fragment_fade_out);
                ft.add(containerId, fragment, fragmentTag)
                .addToBackStack(fragmentTag)
                .commit();
    }

    public static void switchFragment(Activity context, int containerId, Fragment fragment, String fragmentTag) {
        context.getFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment, fragmentTag)
                .commit();
    }

    public static void clearBackStack(Activity context) {
        context.getFragmentManager()
                .popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
}
