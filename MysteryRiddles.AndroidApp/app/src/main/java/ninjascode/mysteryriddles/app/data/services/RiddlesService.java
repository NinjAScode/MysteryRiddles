package ninjascode.mysteryriddles.app.data.services;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
/**
 * Created by svetla.ivanova on 10.7.2016 г..
 */
public class RiddlesService {
    protected OkHttpClient client;

    public RiddlesService(){
        this.client = new OkHttpClient();
    }

    public void getRandom(String url, Callback callback) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();

        this.client.newCall(request).enqueue(callback);
    }
}


