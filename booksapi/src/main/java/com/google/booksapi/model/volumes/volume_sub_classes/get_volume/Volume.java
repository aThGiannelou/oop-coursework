package com.google.booksapi.model.volumes.volume_sub_classes.get_volume;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import lombok.Data;

import java.util.List;

@Data
public class Volume {
    private String kind;
    private String id;
    private String etag;
    private String selfLink;
    private VolumeInfo volumeInfo;
    private LayerInfo layerInfo;
    private SaleInfo saleInfo;
    private AccessInfo accessInfo;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}

