package com.google.booksapi.services;

import com.google.booksapi.model.BookshelfList;
import com.google.booksapi.model.PublicBookshelfContents;
import com.google.booksapi.model.volumes.VolumeList;
import com.google.booksapi.model.volumes.volume_sub_classes.get_volume.Volume;

import java.util.Map;

public interface BooksService {
    VolumeList searchBooks(String query, Map<String, String> params);

    Volume getVolumeById(String volumeId);

    BookshelfList getPublicBookSelves(String userId);

    PublicBookshelfContents getBookshelfById(String bookshelfId);

    VolumeList getBookshelfVolumes(String bookshelfId);
}
