package com.example.exprj.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exprj.R;

import java.util.List;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.ViewHolder> {

    List<News> listNews;

    public AdapterNews(List<News> listNews) {
        this.listNews = listNews;
    }


    @NonNull
    @Override
    public AdapterNews.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_news, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNews.ViewHolder holder, int position) {
        holder.tvTitle.setText(listNews.get(position).getTitle());
        holder.tvDate.setText(listNews.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title_news);
            tvDate = itemView.findViewById(R.id.tv_date_news);
        }
    }
}
