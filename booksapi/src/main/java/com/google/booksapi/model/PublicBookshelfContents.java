package com.google.booksapi.model;

import com.google.gson.Gson;
import lombok.Data;

import lombok.Data;

@Data
public class PublicBookshelfContents {
    private String kind;
    private int totalItems;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }


}

