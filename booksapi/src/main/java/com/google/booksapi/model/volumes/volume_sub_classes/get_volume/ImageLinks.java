package com.google.booksapi.model.volumes.volume_sub_classes.get_volume;

import lombok.Data;

@Data
public class ImageLinks {
    private String smallThumbnail;
    private String thumbnail;
    private String small;
    private String medium;
    private String large;
    private String extraLarge;
}
