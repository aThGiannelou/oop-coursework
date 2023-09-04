package com.google.booksapi.controllers;

import com.google.booksapi.model.BookshelfList;
import com.google.booksapi.model.PublicBookshelfContents;
import com.google.booksapi.model.volumes.VolumeList;
import com.google.booksapi.model.volumes.volume_sub_classes.get_volume.Volume;
import com.google.booksapi.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/books")
public class GoogleBooksAPIController {
    private final BooksService bookService;

    @Autowired
    public GoogleBooksAPIController(BooksService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search")
    public VolumeList searchBooks(@RequestParam String query, @RequestParam Map<String, String> params) {
        return bookService.searchBooks(query, params);
    }


    @GetMapping("/books/{volumeId}")
    public Volume getVolumeById(@PathVariable String volumeId) {
        return bookService.getVolumeById(volumeId);
    }

    @GetMapping("/{userId}/bookshelves")
    public BookshelfList getUserPublicBookshelves(@PathVariable("userId") String userId) {
        return bookService.getPublicBookSelves(userId);
    }

    @GetMapping("id/{bookshelfId}/bookshelf")
    public PublicBookshelfContents getBookshelfById(@PathVariable("bookshelfId") String bookshelfId) {
        return bookService.getBookshelfById(bookshelfId);
    }

    @GetMapping("/bookshelves/{bookshelfId}/volumes")
    public VolumeList getBookshelfVolumes(@PathVariable String bookshelfId) {
        return bookService.getBookshelfVolumes(bookshelfId);
    }
}
