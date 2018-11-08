package com.example.fafoo.listedesfilms.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Movie implements Serializable {

    //values from API
    private String title;
    private String overview;
    private String posterpath;
    private String backdropPath;
    private Double voteAverage;

    //initialize from JSON data
    public Movie(JSONObject object) throws JSONException {
        title = object.getString("title");
        overview = object.getString("overview");
        posterpath = object.getString("poster_path");
        backdropPath = object.getString("backdrop_path");
        voteAverage = object.getDouble("vote_average");
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

    public Double getVoteAverage() {
        return voteAverage;
    }

}
