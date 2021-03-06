package com.example.fafoo.listedesfilms.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Movie {

    //values from API
    private String title;
    private String overview;
    private String posterpath;
    private String backdropPath;

    //initialize from JSON data
    public Movie(JSONObject object) throws JSONException {
        title = object.getString("title");
        overview = object.getString("overview");
        posterpath = object.getString("poster_path");
        backdropPath = object.getString("backdrop_path");
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterpath() {
        return posterpath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }
}
