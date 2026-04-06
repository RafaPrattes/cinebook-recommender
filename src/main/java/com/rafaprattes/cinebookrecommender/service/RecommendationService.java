package com.rafaprattes.cinebookrecommender.service;

import com.rafaprattes.cinebookrecommender.model.Movie;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    private final List<Movie> movies = Arrays.asList(
            new Movie(1L, "Inception", "Sci-Fi", "A thief who steals corporate secrets through the use of dream-sharing technology."),
            new Movie(2L, "The Dark Knight", "Action", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham."),
            new Movie(3L, "The Hangover", "Comedy", "Three buddies wake up from a bachelor party in Las Vegas, with no memory of the previous night."),
            new Movie(4L, "Pride & Prejudice", "Romance", "Sparks fly when spirited Elizabeth Bennet meets single, rich, and proud Mr. Darcy."),
            new Movie(5L, "Interstellar", "Sci-Fi", "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.")
    );

    public List<Movie> suggestByGenre(String genre) {
        return movies.stream()
                .filter(m -> m.genre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }
}