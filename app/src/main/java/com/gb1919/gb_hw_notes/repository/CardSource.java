package com.gb1919.gb_hw_notes.repository;

import java.util.List;

public interface CardSource {
    int size();

    List<CardData> getAllCardsData();

    CardData getCardData(int position);
}
