package com.google.booksapi.model.volumes.volume_sub_classes.volume;

import com.google.booksapi.model.volumes.volume_sub_classes.volume.access_info.Availability;
import com.google.booksapi.model.volumes.volume_sub_classes.volume.access_info.Pdf;
import lombok.Data;

@Data
public class AccessInfo {
    private String country;
    private String viewability;
    private Boolean embeddable;
    private Boolean publicDomain;
    private String textToSpeechPermission;
    private Availability epub;
    private Pdf pdf;
    private String webReaderLink;
    private String accessViewStatus;
    private Boolean quoteSharingAllowed;
}
