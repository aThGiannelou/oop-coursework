package com.google.booksapi.model.volumes.volume_sub_classes.get_volume;

import lombok.Data;

import java.util.List;

@Data
public class SaleInfo {
    private String country;
    private String saleability;
    private Boolean isEbook;
    private Price listPrice;
    private Price retailPrice;
    private String buyLink;
    private List<Offer> offers;
}
