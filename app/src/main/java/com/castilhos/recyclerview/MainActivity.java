package com.castilhos.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

class Movie {
    private String title;
    private String director;
    private String year;

    public Movie(String title, String director, String year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getYear() {
        return year;
    }
}

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewMovies;
    private List<Movie> movies = Arrays.asList(
            new Movie("Título 01", "Diretor 01", "Ano 01"),
            new Movie("Título 02", "Diretor 02", "Ano 02"),
            new Movie("Título 03", "Diretor 03", "Ano 03"),
            new Movie("Título 04", "Diretor 04", "Ano 04")
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewMovies = findViewById(R.id.recyclerViewMovies);

        // ADAPTER
        MoviesAdapter moviesAdapter = new MoviesAdapter(movies);

        // MANAGER
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getApplicationContext()
        );

        recyclerViewMovies.setLayoutManager(manager);
        recyclerViewMovies.setAdapter(moviesAdapter);
        recyclerViewMovies.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerViewMovies,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item: " + movies.get(position).getTitle(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Long Item: " + movies.get(position).getTitle(),
                                        Toast.LENGTH_LONG
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }
}
