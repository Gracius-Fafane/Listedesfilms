package com.example.fafoo.listedesfilms.models;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fafoo.listedesfilms.FlicksActivity;
import com.example.fafoo.listedesfilms.R;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    //list of movies
    static ArrayList<Movie> movies;
    //config needed for image url
    Config config;
    //context for rendering
    Context context;

    //initialize with list
    public MovieAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    //create and inflate a new view
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //get the context and create the inflater
       context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        //create the view using the item_movie layout
        View movieVew = inflater.inflate(R.layout.item_movie, parent, false);
        //return a new ViewHolder
        return new ViewHolder(movieVew);
    }

    //binds and inflate view a new item
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     //get the movie data at the specified position
     Movie movie = movies.get(position);
     //populate the view with the movie data
        holder.tvTitle.setText(movie.getTitle());
        holder.tvOverview.setText(movie.getOverview());

        //determine the current orientation
        boolean isPortrait = context.getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT;

        // build url for poster image
        String imageUrl = null;

        //if in portrait mode,load the poster image
        if(isPortrait) {
            imageUrl = config.getImageUrl(config.getPosterSize(), movie.getPosterpath());
        } else {
            //load the backdrop image
            imageUrl = config.getImageUrl(config.getBackdropSize(), movie.getBackdropPath());
        }

        //get the correct placeholder and image view for the current orientation
        int placeholderId = isPortrait ? R.drawable.flicks_movie_placeholder : R.drawable.flicks_backdrop_placeholder;
        ImageView imageView = isPortrait ? holder.ivPosterImage : holder.ivBackdropImage;

        //load image using glide
        int radius = 15; // corner radius, higher value = more rounded
        int margin = 5; // crop margin, set to 0 for corners with no crop
        GlideApp.with(context)
                .load(imageUrl)
                .transform(new RoundedCornersTransformation(radius, margin))
                .placeholder(placeholderId)
                .error(placeholderId)
                .into(imageView);
    }

    //returns the total number of items in the list
    @Override
    public int getItemCount() {
        return movies.size();
    }

    //create the ViewHolder as static inner class
    //extends RecyclerView.ViewHolder implements View.OnClickListener
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //track view objects
        ImageView ivPosterImage;
        ImageView ivBackdropImage;
        TextView tvTitle;
        TextView tvOverview;
        private Context context;


        public ViewHolder(View itemView) {
            super(itemView);
            //lookup view objects by id
            ivPosterImage = (ImageView) itemView.findViewById(R.id.ivPosterImage);
            ivBackdropImage = (ImageView) itemView.findViewById(R.id.ivBackdropImage);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvOverview = (TextView) itemView.findViewById(R.id.tvOverview);
            // Store the context
            this.context = itemView.getContext();
            // Attach a click listener to the entire row view
            itemView.setOnClickListener(this);
        }

        // Handles the row being being clicked
        @Override
        public void onClick(View view) {
            Log.d("MovieAdapter", "Item clicked at position " + getAdapterPosition());
            int position = getAdapterPosition(); // gets item position
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                Movie movie = movies.get(position);
                // We can access the data within the views
                System.out.println(""+movie.getTitle());
               // Toast.makeText(getA, movie.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, FlicksActivity.class);
                intent.putExtra("movie", movie);
                context.startActivity(intent);
                Log.d("MovieAdapter", "Item clicked at position " + getAdapterPosition());
            }
        }

    }


}
