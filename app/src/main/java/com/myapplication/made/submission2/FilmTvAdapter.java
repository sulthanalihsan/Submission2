package com.myapplication.made.submission2;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class FilmTvAdapter extends RecyclerView.Adapter<FilmTvAdapter.ListViewHolder> {
    private ArrayList<FilmTvModel> listFilmTv;

    public FilmTvAdapter(ArrayList<FilmTvModel> list) {
        this.listFilmTv = list;
    }

    @NonNull
    @Override
    public FilmTvAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_film_tv, viewGroup, false);
        return new ListViewHolder(view);
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onBindViewHolder(@NonNull final FilmTvAdapter.ListViewHolder holder, int i) {
        FilmTvModel filmTvModel = listFilmTv.get(i);

        Glide.with(holder.itemView.getContext())
                .load(filmTvModel.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.tvTitle.setText(filmTvModel.getTitle());
        holder.tvOverview.setText(filmTvModel.getOverview());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listFilmTv.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listFilmTv.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitle, tvOverview;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_photo);
            tvTitle = itemView.findViewById(R.id.txt_filmtv_title);
            tvOverview = itemView.findViewById(R.id.txt_filmtv_overview);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(FilmTvModel filmTvModel);
    }

}
