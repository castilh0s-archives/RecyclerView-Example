package com.castilhos.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class MovieViewHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public TextView year;
    public TextView director;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.textViewTitle);
        year = itemView.findViewById(R.id.textViewYear);
        director = itemView.findViewById(R.id.textViewDirector);
    }
}

public class MoviesAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private List<Movie> movies;

    public MoviesAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View item = inflater.inflate(
                R.layout.adapter_movie,
                viewGroup,
                false
        );

        return new MovieViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        Movie movie = movies.get(i);

        movieViewHolder.title.setText(movie.getTitle());
        movieViewHolder.year.setText(movie.getYear());
        movieViewHolder.director.setText(movie.getDirector());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
