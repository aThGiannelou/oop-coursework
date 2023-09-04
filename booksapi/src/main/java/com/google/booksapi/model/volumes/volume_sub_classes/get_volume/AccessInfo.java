package com.google.booksapi.model.volumes.volume_sub_classes.get_volume;

import lombok.Data;

@Data
public class AccessInfo {
    private String country;
    private String viewability;
    private Boolean embeddable;
    private Boolean publicDomain;
    private String textToSpeechPermission;
    private Epub epub;
    private Pdf pdf;
    private String webReaderLink;
    private String accessViewStatus;
    private Boolean quoteSharingAllowed;
}
