package com.example.fafoo.listedesfilms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.fafoo.listedesfilms.models.Movie;

import java.lang.invoke.MethodType;


public class FlicksActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView tvTitle;
    RatingBar rbVoteAverage;
    TextView tvOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flicks);
        setSupportActionBar(toolbar);

        toolbar = findViewById(R.id.toolbar);
        tvTitle = findViewById(R.id.tvTitle);
        rbVoteAverage = findViewById(R.id.rbVoteAverage);
        tvOverview = findViewById(R.id.tvOverview);

       Movie movie = (Movie) getIntent().getSerializableExtra("movie");

      String Title = movie.getTitle();
      String Overview = movie.getOverview();
      float voteAverage = movie.getVoteAverage().floatValue();

        // set the title and overview
      tvTitle.setText(Title);
      tvOverview.setText(Overview);
        // vote average is 0..10, convert to 0..5 by dividing by 2
        rbVoteAverage.setRating(voteAverage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

}

