package com.google.booksapi.model.volumes.volume_sub_classes.volume;

import com.google.booksapi.model.volumes.volume_sub_classes.volume.sale_info.ListPrice;
import com.google.booksapi.model.volumes.volume_sub_classes.volume.sale_info.RetailPrice;
import lombok.Data;

import java.util.List;

@Data
public class SaleInfo {
    private String country;
    private String saleability;
    private Boolean isEbook;
    private ListPrice listPrice;
    private RetailPrice retailPrice;
    private String buyLink;
    private List<Offer> offers;
}
