package com.google.booksapi;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.google.booksapi.controllers.GoogleBooksAPIController;
import com.google.booksapi.model.BookshelfList;
import com.google.booksapi.model.PublicBookshelfContents;
import com.google.booksapi.model.volumes.VolumeList;
import com.google.booksapi.model.volumes.volume_sub_classes.get_volume.Volume;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class BooksapiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BooksapiApplication.class, args);
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Choose an option:" +
					"\n1: Search for books" +
					"\n2: Retrieve a specific volume" +
					"\n3: Retrieve user's public bookshelves" +
					"\n4: Retrieve public bookshelf by id" +
					"\n5: Retrieve a list of volumes on a public bookshelf" +
					"\n6: Exit");
			String input = scanner.nextLine();
			try {
				GoogleBooksAPIController googleBooksAPIController = context.getBean(GoogleBooksAPIController.class);
                switch (input) {
                    case "1" -> {
                        System.out.println("Enter query: (HINT -> flowers)");
                        String query = scanner.nextLine();
                        System.out.println("Enter field: (HINT -> keyes)");
                        String field = scanner.nextLine();
                        System.out.println("Enter value: (HINT -> keyes)");
                        String value = scanner.nextLine();
                        Map<String, String> params = new HashMap<>();
                        params.put(field, value);
                        VolumeList controllerResult = googleBooksAPIController.searchBooks(query, params);
                        System.out.println("Search Result: " + controllerResult.toString());
                    }
                    case "2" -> {
                        System.out.println("Enter volume ID: (HINT -> zyTCAlFPjgYC)");
                        String volumeId = scanner.nextLine();
                        Volume volumeData = googleBooksAPIController.getVolumeById(volumeId);
                        System.out.println("Volume Data: " + volumeData.toString());
                    }
                    case "3" -> {
                        System.out.println("Enter User ID: (HINT -> 102701940585560677579)");
                        String userId = scanner.nextLine();
                        BookshelfList userBookshelves = googleBooksAPIController.getUserPublicBookshelves(userId);
                        System.out.println("User's Public Bookshelves: " + userBookshelves.toString());
                    }
                    case "4" -> {
                        System.out.println("Enter Bookshelf ID: (HINT -> {0, 1001}");
                        String bookshelfId = scanner.nextLine();
                        PublicBookshelfContents bookshelfData = googleBooksAPIController.getBookshelfById(bookshelfId);
                        System.out.println("Bookshelf Data: " + bookshelfData.toString());
                    }
                    case "5" -> {
                        System.out.println("Enter Bookshelf ID for volume retrieval: (HINT -> {0, 1001}");
                        String bookshelfIdForVolumes = scanner.nextLine();
                        VolumeList bookshelfVolumes = googleBooksAPIController.getBookshelfVolumes(bookshelfIdForVolumes);
                        System.out.println("Volumes on Bookshelf: " + bookshelfVolumes.toString());
                    }
                    case "6" -> {
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid input. Try again.");
                }
			} catch (Exception e) {
				System.out.println("\nAn error occurred. Please try again.");
			}
		}
	}


	@Bean
	public Jackson2ObjectMapperBuilderCustomizer customizeJackson() {
		return builder -> builder.featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
