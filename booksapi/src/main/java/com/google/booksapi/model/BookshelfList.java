package com.google.booksapi.model;

import com.google.gson.Gson;
import lombok.Data;

import java.util.List;

@Data
public class BookshelfList {
    private String kind;
    private List<Bookshelf> items;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Kind: ").append(kind).append("\n");
        sb.append("Items: \n");
        items.forEach(item -> sb.append(item.toString()).append("\n"));
        sb.append("\nJSON Representation:\n");
        sb.append(new Gson().toJson(this));
        return sb.toString();
    }


}
