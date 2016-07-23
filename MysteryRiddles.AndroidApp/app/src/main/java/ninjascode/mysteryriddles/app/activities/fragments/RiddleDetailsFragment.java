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
import ninjascode.mysteryriddles.app.common.DateTimeService;
import ninjascode.mysteryriddles.app.common.GlobalConstants;
import ninjascode.mysteryriddles.app.common.UiService;
import ninjascode.mysteryriddles.app.data.contracts.IUpdatePageData;
import ninjascode.mysteryriddles.app.tasks.GetRandomRiddleTask;
import ninjascode.mysteryriddles.app.viewModels.RiddleViewModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class RiddleDetailsFragment extends Fragment implements IUpdatePageData<RiddleViewModel>, View.OnClickListener {
    public static final String RIDDLE_ANSWER_KEY = "riddleAnswerTip";
    private static final String RIDDLE_ANSWER_FRAGMENT_TAG = "randomRiddleAnswerFragmentTag";

    static Button btnGetAnswer;
    static TextView txtTitle, txtDescription, txtCreatedOn, txtAuthor;
    static ProgressBar progressBar;

    RiddlesActivity riddlesActivity;
    RiddleViewModel riddle;
    Context context;

    //FloatingActionButton fab;

    public RiddleDetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_riddle_details, container,
                false);

        this.context = container.getContext();
        this.riddlesActivity = (RiddlesActivity) this.context;

//        fab = (FloatingActionButton) view.findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loadPageData();
//            }
//        });

        txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtDescription = (TextView) view.findViewById(R.id.txtDescription);
        txtCreatedOn = (TextView) view.findViewById(R.id.txtCreatedOn);
        txtAuthor = (TextView) view.findViewById(R.id.txtAuthor);

        btnGetAnswer = (Button) view.findViewById(R.id.btnGetAnswer);
        btnGetAnswer.setOnClickListener(this);

        progressBar = (ProgressBar) view.findViewById(R.id.progressBarTips);

        UiService.setTypeface(context, GlobalConstants.TITLE_FONT_PATH, txtTitle);
        UiService.setTypeface(context, GlobalConstants.CONTENT_FONT_PATH, txtDescription, txtCreatedOn, txtAuthor, btnGetAnswer);

        loadPageData();

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnGetAnswer) {
            this.getAnswer();
        }
    }

    @Override
    public void updatePageData(RiddleViewModel data) {
        this.riddle = data;
        txtTitle.setText(data.getTitle());
        txtDescription.setText(data.getDescription());
        txtCreatedOn.setText(DateTimeService.getShortDateFormatter().format(data.getCreatedOn()));
        txtAuthor.setText("от " + data.getAuthor());
        btnGetAnswer.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    public void loadPageData() {
        GetRandomRiddleTask getRandomRiddleTask = new GetRandomRiddleTask(context, this);
        getRandomRiddleTask.execute();
    }

    private void getAnswer(){
        // http://stackoverflow.com/questions/7149802/how-to-transfer-some-data-to-another-fragment
        RiddleAnswerFragment fragment = new RiddleAnswerFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(RIDDLE_ANSWER_KEY, riddle);
        fragment.setArguments(bundle);
        riddlesActivity.getFragment(fragment, RIDDLE_ANSWER_FRAGMENT_TAG);
    }
}
