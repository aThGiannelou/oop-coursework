package com.google.booksapi.model;

import lombok.Data;

@Data
public class Bookshelf {
    private String kind;
    private int id;
    private String title;
    private String access;
    private String updated;
    private String created;
    private int volumeCount;
    private String volumesLastUpdated;
}