package com.google.booksapi.model.volumes.volume_sub_classes.volume;

import com.google.booksapi.model.volumes.volume_sub_classes.volume.sale_info.RetailPrice;
import lombok.Data;

@Data
public class Offer {
    private Integer finskyOfferType;
    private RetailPrice listPrice;
    private RetailPrice retailPrice;
}