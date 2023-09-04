package com.google.booksapi.model.volumes.volume_sub_classes.get_volume;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Pdf {
    @JsonProperty("isAvailable")
    private Boolean isAvailable;
}
