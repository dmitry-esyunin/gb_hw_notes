package com.gb1919.gb_hw_notes.repository;

import android.content.res.Resources;
import android.content.res.TypedArray;

import com.gb1919.gb_hw_notes.R;

import java.util.ArrayList;
import java.util.List;

public class LocalRepositoryImpl implements CardSource {

    private List<CardData> dataSource;
    private Resources resources;


    public LocalRepositoryImpl(Resources resources) {
        dataSource = new ArrayList<CardData>();
        this.resources = resources;
    }

    public LocalRepositoryImpl init() {
        String[] titles = resources.getStringArray(R.array.titles);
        String[] descriptions = resources.getStringArray(R.array.descriptions);


        for (int i = 0; i < titles.length; i++) {
            dataSource.add(new CardData(titles[i], descriptions[i]));
        }
        return this;
    }

    @Override
    public int size() {
        return dataSource.size();
    }

    @Override
    public List<CardData> getAllCardsData() {
        return dataSource;
    }

    @Override
    public CardData getCardData(int position) {
        return dataSource.get(position);
    }
}
