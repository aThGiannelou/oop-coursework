package com.google.booksapi.model.volumes.volume_sub_classes.volume;

import com.google.booksapi.model.volumes.volume_sub_classes.volume.volume_info.ImageLinks;
import com.google.booksapi.model.volumes.volume_sub_classes.volume.volume_info.IndustryIdentifier;
import com.google.booksapi.model.volumes.volume_sub_classes.volume.volume_info.PanelizationSummary;
import com.google.booksapi.model.volumes.volume_sub_classes.volume.volume_info.ReadingModes;
import lombok.Data;

import java.util.List;

@Data
public class VolumeInfo {
    private String title;
    private List<String> authors;
    private String publisher;
    private String publishedDate;
    private String description;
    private List<IndustryIdentifier> industryIdentifiers;
    private ReadingModes readingModes;
    private Integer pageCount;
    private String printType;
    private List<String> categories;
    private Double averageRating;
    private Integer ratingsCount;
    private String maturityRating;
    private Boolean allowAnonLogging;
    private String contentVersion;
    private PanelizationSummary panelizationSummary;
    private ImageLinks imageLinks;
    private String language;
    private String previewLink;
    private String infoLink;
    private String canonicalVolumeLink;
}
