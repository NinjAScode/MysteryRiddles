package ninjascode.mysteryriddles.app.activities.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import ninjascode.mysteryriddles.R;
import ninjascode.mysteryriddles.app.activities.RiddlesActivity;
import ninjascode.mysteryriddles.app.common.GlobalConstants;
import ninjascode.mysteryriddles.app.common.UiService;
import ninjascode.mysteryriddles.app.data.contracts.IUpdatePageData;
import ninjascode.mysteryriddles.app.tasks.GetRandomRiddleTask;
import ninjascode.mysteryriddles.app.viewModels.RiddleViewModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class RiddleAnswerFragment extends Fragment implements View.OnClickListener {
    static Button btnGoBack;
    static TextView txtTitle, txtAnswer;
    static ProgressBar progressBar;

    RiddlesActivity riddlesActivity;
    Context context;
    RiddleViewModel riddle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_riddle_answer, container,
                false);

        this.context = container.getContext();
        this.riddlesActivity = (RiddlesActivity) this.context;

        Bundle bundle = this.getArguments();
        riddle = bundle.getParcelable(RiddleDetailsFragment.RIDDLE_ANSWER_KEY);

        txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtAnswer = (TextView) view.findViewById(R.id.txtAnswer);

        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        btnGoBack = (Button) view.findViewById(R.id.btnGoBack);
        btnGoBack.setOnClickListener(this);

        UiService.setTypeface(context, GlobalConstants.TITLE_FONT_PATH, txtTitle);
        UiService.setTypeface(context, GlobalConstants.CONTENT_FONT_PATH, txtAnswer, btnGoBack);

        loadPageData();

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnGoBack) {
            getFragmentManager().popBackStack();
        }
    }

    public void loadPageData() {
        txtAnswer.setText(riddle.getAnswer());
        progressBar.setVisibility(View.GONE);
    }
}
