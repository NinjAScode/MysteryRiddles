package ninjascode.mysteryriddles.app.activities.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ninjascode.mysteryriddles.R;
import ninjascode.mysteryriddles.app.activities.MainActivity;
import ninjascode.mysteryriddles.app.activities.RiddlesActivity;
import ninjascode.mysteryriddles.app.common.GlobalConstants;
import ninjascode.mysteryriddles.app.common.UiService;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    static Button btnGetRandom;
    static TextView txtTitle, txtDescription;

    MainActivity mainActivity;
    Context context;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container,
                false);

        this.context = container.getContext();
        this.mainActivity = (MainActivity) this.context;

        btnGetRandom = (Button) view.findViewById(R.id.btnGetRandom);
        btnGetRandom.setOnClickListener(this);

        txtTitle = (TextView)view.findViewById(R.id.txtTitle);
        txtDescription = (TextView)view.findViewById(R.id.txtDescription);

        UiService.setTypeface(context, GlobalConstants.TITLE_FONT_PATH, txtTitle);
        UiService.setTypeface(context, GlobalConstants.CONTENT_FONT_PATH, txtDescription, btnGetRandom);

        return view;
        //return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnGetRandom) {
            context.startActivity(new Intent(context, RiddlesActivity.class));
//            this.riddlesActivity.getFragment(new RiddleDetailsFragment());
        }
    }
}
