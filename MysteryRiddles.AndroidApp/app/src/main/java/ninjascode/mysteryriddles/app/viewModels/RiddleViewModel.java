package ninjascode.mysteryriddles.app.viewModels;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import org.json.JSONObject;

import java.util.Date;

import ninjascode.mysteryriddles.app.common.Helper;

/**
 * Created by svetla.ivanova on 10.7.2016 г..
 */
public class RiddleViewModel implements Parcelable {
    private long id;
    private String title;
    private String description;
    private Date createdOn;
    private String author;
    private String answer;
    private int data;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String content) {
        this.description = content;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static RiddleViewModel FromModel(String json) {
        try {
            JSONObject jObject = new JSONObject(json);
            RiddleViewModel returnedModel = new RiddleViewModel(Parcel.obtain());

            returnedModel.id = jObject.getInt("Id");
            returnedModel.title = jObject.getString("Title");
            returnedModel.description = jObject.getString("Description");
            returnedModel.answer = jObject.getString("Answer");
            String authorName = jObject.getString("AuthorName");
            returnedModel.author = authorName == "null" ? "Анонимен" : authorName;
            String createdOnAsString = jObject.getString("CreatedOn");
            try {
                returnedModel.createdOn = Helper.getDateFormatter().parse(createdOnAsString);
            } catch (Exception e) {
                returnedModel.createdOn = Helper.getNoMsDateFormatter().parse(createdOnAsString);
            }

            return returnedModel;
        } catch (Exception e) {
            Log.v("tag", e.getMessage());
            return null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(data);
    }


    public static final Parcelable.Creator<RiddleViewModel> CREATOR
            = new Parcelable.Creator<RiddleViewModel>() {
        public RiddleViewModel createFromParcel(Parcel in) {
            return new RiddleViewModel(in);
        }

        public RiddleViewModel[] newArray(int size) {
            return new RiddleViewModel[size];
        }
    };

    /**
     * recreate object from parcel
     */
    private RiddleViewModel(Parcel in) {
        data = in.readInt();
    }
}
