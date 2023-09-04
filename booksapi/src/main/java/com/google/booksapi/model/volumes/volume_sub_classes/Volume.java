package com.google.booksapi.model.volumes.volume_sub_classes;

import com.google.booksapi.model.volumes.volume_sub_classes.volume.AccessInfo;
import com.google.booksapi.model.volumes.volume_sub_classes.volume.SaleInfo;
import com.google.booksapi.model.volumes.volume_sub_classes.volume.SearchInfo;
import com.google.booksapi.model.volumes.volume_sub_classes.volume.VolumeInfo;
import lombok.Data;

@Data
public class Volume {
    private String kind;
    private String id;
    private String etag;
    private String selfLink;
    private VolumeInfo volumeInfo;
    private SaleInfo saleInfo;
    private AccessInfo accessInfo;
    private SearchInfo searchInfo;
}