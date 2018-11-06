package com.example.fafoo.listedesfilms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fafoo.listedesfilms.models.Movie;

import java.lang.invoke.MethodType;

public class FlicksActivity extends AppCompatActivity {

    ImageView ivImageDetail;
    TextView tvTitle_Detail;
    TextView tvOverview_Detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flicks);

        ivImageDetail = findViewById(R.id.ivImageDetail);
        tvTitle_Detail = findViewById(R.id.tvTitle_Detail);
        tvOverview_Detail = findViewById(R.id.tvOverview_Detail);

       Movie movie = (Movie) getIntent().getSerializableExtra("movie");


      String Title = movie.getTitle();
      String Overview = movie.getOverview();

      tvTitle_Detail.setText(Title);
      tvOverview_Detail.setText(Overview);
    }
}
