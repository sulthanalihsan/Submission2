package com.myapplication.made.submission2;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
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
public class TvFragment extends Fragment {

    private String[] dataTitle, dataReleaseDate, dataDuration, dataLanguage, dataUserScore, dataRating, dataRevenue, dataGenre, dataOverview;
    private TypedArray dataPhoto;
    private FilmTvAdapter adapter;
    private ArrayList<FilmTvModel> listFilmTv;
    private RecyclerView rvTv;


    public TvFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv, container, false);

        prepare();
        addItem();

        rvTv = view.findViewById(R.id.rv_tv);
        rvTv.setHasFixedSize(true);
        rvTv.setLayoutManager(new LinearLayoutManager(getActivity()));
//        rvTv.setItemAnimator(new DefaultItemAnimator());
        rvTv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        FilmTvAdapter filmTvAdapter = new FilmTvAdapter(listFilmTv);
        rvTv.setAdapter(filmTvAdapter);

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
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo_tv);
        dataTitle = getResources().getStringArray(R.array.data_title_tv);
        dataReleaseDate = getResources().getStringArray(R.array.data_release_date_tv);
        dataDuration = getResources().getStringArray(R.array.data_duration_tv);
        dataLanguage = getResources().getStringArray(R.array.data_language_tv);
        dataUserScore = getResources().getStringArray(R.array.data_user_score_tv);
        dataRating = getResources().getStringArray(R.array.data_rating_tv);
        dataRevenue = getResources().getStringArray(R.array.data_revenue_tv);
        dataGenre = getResources().getStringArray(R.array.data_genre_tv);
        dataOverview = getResources().getStringArray(R.array.data_overview_tv);
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
