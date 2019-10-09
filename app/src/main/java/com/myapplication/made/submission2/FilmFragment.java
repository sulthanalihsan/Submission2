package com.myapplication.made.submission2;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FilmFragment extends Fragment {

    private String[] dataTitle, dataReleaseDate, dataDuration, dataLanguage, dataUserScore, dataRating, dataRevenue, dataGenre, dataOverview;
    private TypedArray dataPhoto;
    private FilmTvAdapter adapter;
    private ArrayList<FilmTvModel> listFilmTv;
    private RecyclerView rvFilm;


    public FilmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_film, container, false);

        prepare();
        addItem();

        rvFilm = view.findViewById(R.id.rv_film);
        rvFilm.setHasFixedSize(true);
        rvFilm.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvFilm.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        FilmTvAdapter filmTvAdapter = new FilmTvAdapter(listFilmTv);
        rvFilm.setAdapter(filmTvAdapter);

        filmTvAdapter.setOnItemClickCallback(new FilmTvAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(FilmTvModel filmTvModel) {
                Toast.makeText(getActivity(), getResources().getString(R.string.toast_text) + " " + filmTvModel.getTitle(), Toast.LENGTH_SHORT).show();
                Intent moveWithObjectIntent = new Intent(getContext(), DetailFilmTvActivity.class);
                moveWithObjectIntent.putExtra(DetailFilmTvActivity.EXTRA_DATA, filmTvModel);
                startActivity(moveWithObjectIntent);

            }
        });

        return view;
    }


    private void prepare() {
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo_film);
        dataTitle = getResources().getStringArray(R.array.data_title_film);
        dataReleaseDate = getResources().getStringArray(R.array.data_release_date_film);
        dataDuration = getResources().getStringArray(R.array.data_duration_film);
        dataLanguage = getResources().getStringArray(R.array.data_language_film);
        dataUserScore = getResources().getStringArray(R.array.data_user_score_film);
        dataRating = getResources().getStringArray(R.array.data_rating_film);
        dataRevenue = getResources().getStringArray(R.array.data_revenue_film);
        dataGenre = getResources().getStringArray(R.array.data_genre_film);
        dataOverview = getResources().getStringArray(R.array.data_overview_film);
    }


    private void addItem() {
        listFilmTv = new ArrayList<FilmTvModel>();

        for (int i = 0; i < dataTitle.length; i++) {
            FilmTvModel filmTvModel = new FilmTvModel();
            filmTvModel.setPhoto(dataPhoto.getResourceId(i, -1));
            filmTvModel.setTitle(dataTitle[i]);
            filmTvModel.setReleaseDate(dataReleaseDate[i]);
            filmTvModel.setDuration(dataDuration[i]);
            filmTvModel.setLanguage(dataLanguage[i]);
            filmTvModel.setUserScore(dataUserScore[i]);
            filmTvModel.setRating(dataRating[i]);
            filmTvModel.setRevenue(dataRevenue[i]);
            filmTvModel.setGenre(dataGenre[i]);
            filmTvModel.setOverview(dataOverview[i]);
            listFilmTv.add(filmTvModel);
        }
        adapter = new FilmTvAdapter(listFilmTv);
    }

}
