package com.google.booksapi.model.volumes.volume_sub_classes.get_volume;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Epub {
    @JsonProperty("isAvailable")
    private Boolean isAvailable;
    @JsonProperty("acsTokenLink")
    private String acsTokenLink;
}
