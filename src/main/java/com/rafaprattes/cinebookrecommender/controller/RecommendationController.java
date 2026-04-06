package com.rafaprattes.cinebookrecommender.controller;

import com.rafaprattes.cinebookrecommender.model.Movie;
import com.rafaprattes.cinebookrecommender.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/sample")
    public Movie getSampleMovie() {
        return new Movie(1L, "Inception", "Sci-Fi", "Dream-sharing heist.");
    }

    @GetMapping
    public List<Movie> getSuggestions(@RequestParam String genre) {
        return recommendationService.suggestByGenre(genre);
    }
}