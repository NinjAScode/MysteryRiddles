package ninjascode.mysteryriddles.app.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import ninjascode.mysteryriddles.R;
import ninjascode.mysteryriddles.app.activities.fragments.RiddleDetailsFragment;
import ninjascode.mysteryriddles.app.common.AppService;
import ninjascode.mysteryriddles.app.common.FragmentService;
import ninjascode.mysteryriddles.app.common.GlobalConstants;
import ninjascode.mysteryriddles.app.common.UiService;

public class RiddlesActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String RIDDLE_DETAILS_FRAGMENT_TAG = "randomRiddleDetailsFragmentTag";

    private RiddlesActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddles);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AppService.setToolbarLogo(this);
        AppService.setToolbarTitle(this, toolbar);

        if (savedInstanceState == null) {
            this.getFragment(new RiddleDetailsFragment(), RIDDLE_DETAILS_FRAGMENT_TAG);
        }

        this.context = this;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fab) {
            this.getNewRandomActivity();
        }
    }

    public void getFragment(Fragment fragment, String fragmentTag) {
        FragmentService.getFragment(this, R.id.container, fragment, fragmentTag);
    }

    private void getNewRandomActivity() {
        // TODO: remove this?
        FragmentService.clearBackStack(context);

        // TODO: add animation
        this.getFragment(new RiddleDetailsFragment(), RIDDLE_DETAILS_FRAGMENT_TAG);

//        // load data without creating a new fragment every time
//        String visibleFragmentName = FragmentService.getLatestBackStackEntryName(context);
//        if (!visibleFragmentName.equals(RIDDLE_DETAILS_FRAGMENT_TAG)) {
//            FragmentService.clearBackStack(context);
//            getFragment(new RiddleDetailsFragment(), RIDDLE_DETAILS_FRAGMENT_TAG);
//        } else{
//            RiddleDetailsFragment fragment = (RiddleDetailsFragment) getFragmentManager().findFragmentByTag(RIDDLE_DETAILS_FRAGMENT_TAG);
//            fragment.loadPageData();
//        }
    }
}