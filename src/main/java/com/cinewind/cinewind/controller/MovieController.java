package com.cinewind.cinewind.controller;

import org.springframework.web.bind.annotation.*;
import com.cinewind.cinewind.service.MovieService;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin("*")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/trending")
    public String trendingMovies() {
        return movieService.getTrendingMovies();
    }

    @GetMapping("/search")
    public String searchMovies(@RequestParam String query) {
        return movieService.searchMovies(query);
    }

    @GetMapping("/test")
    public String test() {
        return "Backend Working!";
    }
    @GetMapping("/{id}")
public String movieDetails(@PathVariable Long id) {
    return movieService.getMovieDetails(id);
}
@GetMapping("/{id}/trailers")
public String getTrailers(@PathVariable Long id) {
    return movieService.getMovieTrailers(id);
}
@GetMapping("/{id}/recommendations")
public String recommendations(@PathVariable Long id) {
    return movieService.getRecommendations(id);
}
}
