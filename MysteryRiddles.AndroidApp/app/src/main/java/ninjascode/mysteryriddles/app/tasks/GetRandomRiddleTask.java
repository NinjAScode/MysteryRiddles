package ninjascode.mysteryriddles.app.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

import ninjascode.mysteryriddles.app.common.GlobalConstants;
import ninjascode.mysteryriddles.app.data.contracts.IUpdatePageData;
import ninjascode.mysteryriddles.app.data.services.RiddlesService;
import ninjascode.mysteryriddles.app.viewModels.RiddleViewModel;

/**
 * Created by svetla.ivanova on 10.7.2016 г..
 */
public class GetRandomRiddleTask {
    private RiddlesService service;
    private String getRandomResponse;
    private Context context;
    private IUpdatePageData page;
    RiddleViewModel model;

    public GetRandomRiddleTask(Context context, IUpdatePageData page){
        this.service = new RiddlesService();
        this.context = context;
        this.page = page;
    }

    public void execute(){
        Callback callback = new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                getRandomResponse = response.body().string();
                model = RiddleViewModel.FromModel(getRandomResponse);
                postToMainThread();
            }
        };

        try {
            service.getRandom(GlobalConstants.RANDOMRIDDLE, callback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void postToMainThread(){
        Handler mainHandler = new Handler(context.getMainLooper());

        Runnable updatePage = new Runnable() {
            @Override
            public void run() {
                page.updatePageData(model);
            }
        };

        mainHandler.post(updatePage);
    }
}
