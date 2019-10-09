package com.myapplication.made.submission2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class DetailFilmTvActivity extends AppCompatActivity {
    private TextView dtl_film_title, dtl_film_release_date, dtl_film_duration, dtl_film_language, dtl_film_user_score, dtl_film_rating, dtl_film_revenue, dtl_film_genre, dtl_film_overview;
    private ImageView dtl_imgPhoto;
    public static final String EXTRA_DATA = "extra_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film_tv);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail Film");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dtl_imgPhoto = findViewById(R.id.dtl_imgPhoto);
        dtl_film_title = findViewById(R.id.dtl_film_title);
        dtl_film_release_date = findViewById(R.id.dtl_film_release_date);
        dtl_film_duration = findViewById(R.id.dtl_film_duration);
        dtl_film_language = findViewById(R.id.dtl_film_language);
        dtl_film_user_score = findViewById(R.id.dtl_film_user_score);
        dtl_film_rating = findViewById(R.id.dtl_film_rating);
        dtl_film_revenue = findViewById(R.id.dtl_film_revenue);
        dtl_film_genre = findViewById(R.id.dtl_film_genre);
        dtl_film_overview = findViewById(R.id.dtl_film_overview);

        FilmTvModel filmTvModel = getIntent().getParcelableExtra(EXTRA_DATA);
        dtl_imgPhoto.setImageResource(filmTvModel.getPhoto());
        dtl_film_title.setText(filmTvModel.getTitle());
        dtl_film_release_date.setText(filmTvModel.getReleaseDate());
        dtl_film_duration.setText(filmTvModel.getDuration());
        dtl_film_language.setText(filmTvModel.getLanguage());
        dtl_film_user_score.setText(filmTvModel.getUserScore());
        dtl_film_rating.setText(filmTvModel.getRating());
        dtl_film_revenue.setText(filmTvModel.getRevenue());
        dtl_film_genre.setText(filmTvModel.getGenre());
        dtl_film_overview.setText(filmTvModel.getOverview());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
