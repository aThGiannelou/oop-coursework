package com.google.booksapi.model.volumes.volume_sub_classes.volume.access_info;

import lombok.Data;

@Data
public class Availability {
    private Boolean isAvailable;
    private String acsTokenLink;
}
