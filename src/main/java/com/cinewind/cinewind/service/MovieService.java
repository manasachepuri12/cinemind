package com.cinewind.cinewind.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    @Value("${tmdb.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getTrendingMovies() {

        String url =
                "https://api.themoviedb.org/3/trending/movie/day?api_key="
                        + apiKey;

        try {
    return restTemplate.getForObject(url, String.class);
} catch (Exception e) {
    return "TMDB Error: " + e.getMessage();
}
    }
public String searchMovies(String query) {

    String url =
            "https://api.themoviedb.org/3/search/movie?api_key="
                    + apiKey
                    + "&query="
                    + query.replace(" ", "%20");

    System.out.println(url);

    try {
    return restTemplate.getForObject(url, String.class);
} catch (Exception e) {
    return "TMDB Error: " + e.getMessage();
}
}
}
