package com.example.fafoo.listedesfilms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.fafoo.listedesfilms.models.Config;
import com.example.fafoo.listedesfilms.models.GlideApp;
import com.example.fafoo.listedesfilms.models.Movie;


public class FlicksActivity extends AppCompatActivity {
    ImageView ivDetail;
    Toolbar toolbar;
    TextView tvTitle;
    RatingBar rbVoteAverage;
    TextView tvOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flicks);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvTitle = findViewById(R.id.tvTitle);
        rbVoteAverage = findViewById(R.id.rbVoteAverage);
        tvOverview = findViewById(R.id.tvOverview);
        ivDetail = findViewById(R.id.image_view_detail);

        String url ="https://image.tmdb.org/t/p/w342";

        Movie movie = (Movie) getIntent().getSerializableExtra("movie");

        String Title = movie.getTitle();
        String Overview = movie.getOverview();
        float voteAverage = movie.getVoteAverage().floatValue();

        // set the title and overview
        tvTitle.setText(Title);
        tvOverview.setText(Overview);
        // vote average is 0..10, convert to 0..5 by dividing by 2
        rbVoteAverage.setRating(voteAverage / 2);

        GlideApp.with(getApplicationContext())
                .load(url+movie.getBackdropPath())
                .fitCenter().into(ivDetail);
    }

}

