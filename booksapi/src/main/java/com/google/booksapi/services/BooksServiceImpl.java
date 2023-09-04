package com.google.booksapi.services;

import com.google.booksapi.model.BookshelfList;
import com.google.booksapi.model.PublicBookshelfContents;
import com.google.booksapi.model.volumes.VolumeList;
import com.google.booksapi.model.volumes.volume_sub_classes.get_volume.Volume;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

@Service
public class BooksServiceImpl implements BooksService{
    @Value("${google.books.api.key}")
    private String API_KEY;

    @Value("${google.books.api.userid}")
    private String userId;

    private static final String BASE_URL = "https://www.googleapis.com/books/v1";

    private final String USERS = "/users";
    private static final String VOLUME_URL_TEMPLATE = BASE_URL + "/volumes/%s?key=%s";
    private final RestTemplate restTemplate;

    public BooksServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public VolumeList searchBooks(String query, Map<String, String> params) {
        StringBuilder queryParams = new StringBuilder();
        params.forEach((k, v) -> queryParams.append("+" + k + ":" + v));
        String finalQuery = query + queryParams.toString();

        String url = BASE_URL + "/volumes?q=" + finalQuery + "&key=" + API_KEY;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                Gson gson = new Gson();
                return gson.fromJson(response.body().string(), VolumeList.class);
            } else {
                throw new RuntimeException("Failed to search books: " + response.code());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while making the request: " + e.getMessage(), e);
        }
    }


    @Override
    public Volume getVolumeById(String volumeId) {
        OkHttpClient client = new OkHttpClient();
        String volumeUrl = String.format(VOLUME_URL_TEMPLATE, volumeId, API_KEY);

        Request request = new Request.Builder()
                .url(volumeUrl)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String responseBody = response.body().string();
            Gson gson = new Gson();
            return gson.fromJson(responseBody, Volume.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch volume by ID: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public BookshelfList getPublicBookSelves(String userId) {
        OkHttpClient client = new OkHttpClient();

        String url = BASE_URL + USERS + "/" + userId + "/bookshelves";

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String responseBody = response.body().string();
            Gson gson = new Gson();
            return gson.fromJson(responseBody, BookshelfList.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch public bookshelves: " + e.getMessage());
        }
    }

    @Override
    public PublicBookshelfContents getBookshelfById(String bookshelfId) {
        OkHttpClient client = new OkHttpClient();

        String url = String.format(BASE_URL + "/users/%s/bookshelves/%s/volumes", userId, bookshelfId);

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String responseBody = response.body().string();
            return new Gson().fromJson(responseBody, PublicBookshelfContents.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch bookshelf by ID: " + e.getMessage());
        }
    }

    @Override
    public VolumeList getBookshelfVolumes(String bookshelfId) {
        OkHttpClient client = new OkHttpClient();

        String url = String.format("https://www.googleapis.com/books/v1/users/%s/bookshelves/%s/volumes?key=%s", userId, bookshelfId, API_KEY);

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String responseBody = response.body().string();
            return new Gson().fromJson(responseBody, VolumeList.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch volumes for the bookshelf: " + e.getMessage());
        }
    }

}
