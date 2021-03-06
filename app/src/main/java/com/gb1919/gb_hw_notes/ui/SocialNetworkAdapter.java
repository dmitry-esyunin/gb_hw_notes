package com.gb1919.gb_hw_notes.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gb1919.gb_hw_notes.R;
import com.gb1919.gb_hw_notes.repository.CardData;
import com.gb1919.gb_hw_notes.repository.CardSource;

public class SocialNetworkAdapter extends RecyclerView.Adapter<SocialNetworkAdapter.MyViewHolder> {

    private CardSource cardSource;

    OnItemClickListener onItemClickListener;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    public void setData(CardSource cardSource) {
        this.cardSource = cardSource;
        notifyDataSetChanged(); // команда адаптеру отрисовать все(!) полученные данные
    }

    SocialNetworkAdapter(CardSource cardSource){
        this.cardSource = cardSource;
    }
    SocialNetworkAdapter(){
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MyViewHolder(layoutInflater.inflate(R.layout.fragment_social_network_cardview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindContentWithLayout(cardSource.getCardData(position));
    }

    @Override
    public int getItemCount() {
        return cardSource.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewTitle;
        private TextView textViewDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = (TextView) itemView.findViewById(R.id.title);
            textViewDescription = (TextView) itemView.findViewById(R.id.description);

        }
            // связываем контент с макетом
        public void bindContentWithLayout(CardData content){

            textViewTitle.setText(content.getTitle());
            textViewDescription.setText(content.getDescription());

        }

    }

}
