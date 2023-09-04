package com.google.booksapi.model.volumes;

import com.google.booksapi.model.volumes.volume_sub_classes.Volume;
import com.google.gson.Gson;
import lombok.Data;

import java.util.List;

@Data
public class VolumeList {
    private String kind;
    private Integer totalItems;
    private List<Volume> items;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}