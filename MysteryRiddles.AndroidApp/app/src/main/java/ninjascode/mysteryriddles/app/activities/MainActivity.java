package ninjascode.mysteryriddles.app.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import ninjascode.mysteryriddles.R;
import ninjascode.mysteryriddles.app.activities.fragments.MainFragment;
import ninjascode.mysteryriddles.app.common.AppService;
import ninjascode.mysteryriddles.app.common.FragmentService;
import ninjascode.mysteryriddles.app.common.GlobalConstants;
import ninjascode.mysteryriddles.app.common.UiService;

public class MainActivity extends AppCompatActivity {
    private static final String MAIN_FRAGMENT_TAG = "mainFragmentTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AppService.setToolbarLogo(this);
        AppService.setToolbarTitle(this, toolbar);

        if (savedInstanceState == null) {
            FragmentService.getFragment(this, R.id.container, new MainFragment(), MAIN_FRAGMENT_TAG);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}