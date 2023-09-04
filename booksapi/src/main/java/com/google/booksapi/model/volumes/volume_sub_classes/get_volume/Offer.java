package com.google.booksapi.model.volumes.volume_sub_classes.get_volume;

import lombok.Data;

@Data
public class Offer {
    private Integer finskyOfferType;
    private Price listPrice;
    private Price retailPrice;
}
