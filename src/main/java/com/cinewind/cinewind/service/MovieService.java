package com.cinewind.cinewind.service;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
@Service
public class MovieService {

   @Value("${TMDB_API_KEY}")
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

    String encodedQuery =
        URLEncoder.encode(query, StandardCharsets.UTF_8);

String url =
        "https://api.themoviedb.org/3/search/movie?api_key="
                + apiKey
                + "&query="
                + encodedQuery;
    System.out.println(url);

    try {
    return restTemplate.getForObject(url, String.class);
} catch (Exception e) {
    return "TMDB Error: " + e.getMessage();
}
}
public String getMovieDetails(Long movieId) {

    String url =
            "https://api.themoviedb.org/3/movie/"
                    + movieId
                    + "?api_key="
                    + apiKey;

    return restTemplate.getForObject(url, String.class);
}
public String getMovieTrailers(Long movieId) {

    String url =
            "https://api.themoviedb.org/3/movie/"
                    + movieId
                    + "/videos?api_key="
                    + apiKey;

    return restTemplate.getForObject(url, String.class);
}
public String getRecommendations(Long movieId) {

    String url =
            "https://api.themoviedb.org/3/movie/"
                    + movieId
                    + "/recommendations?api_key="
                    + apiKey;

    return restTemplate.getForObject(url, String.class);
}
}
