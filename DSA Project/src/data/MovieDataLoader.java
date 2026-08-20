package data;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

import model.Movie;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieDataLoader {

    public static List<Movie> loadMovies(String filePath) {

        List<Movie> movies = new ArrayList<>();

        try (FileReader reader = new FileReader(filePath)) {

            Gson gson = new Gson();

            // Read the entire JSON file
            JsonArray movieArray = gson.fromJson(reader, JsonArray.class);

            // Process each movie
            for (JsonElement element : movieArray) {

                JsonObject data = element.getAsJsonObject();

                try {

                    int id = data.get("id").getAsInt();

                    String title = getString(data, "title");
                    String originalTitle = getString(data, "original_title");
                    String overview = getString(data, "overview");

                    String genres = getString(data, "genres");
                    String keywords = getString(data, "keywords");

                    String originalLanguage =
                            getString(data, "original_language");

                    String releaseDate =
                            getString(data, "release_date");

                    String runtime =
                            getString(data, "runtime");

                    String popularity =
                            getString(data, "popularity");

                    String voteAverage =
                            getString(data, "vote_average");

                    String voteCount =
                            getString(data, "vote_count");

                    String budget =
                            getString(data, "budget");

                    String revenue =
                            getString(data, "revenue");

                    String status =
                            getString(data, "status");

                    String tagline =
                            getString(data, "tagline");


                    Movie movie = new Movie(
                            id,
                            title,
                            originalTitle,
                            overview,
                            genres,
                            keywords,
                            originalLanguage,
                            releaseDate,
                            runtime,
                            popularity,
                            voteAverage,
                            voteCount,
                            budget,
                            revenue,
                            status,
                            tagline
                    );

                    movies.add(movie);

                } catch (Exception e) {

                    System.out.println(
                            "Skipping invalid movie: " + e.getMessage()
                    );
                }
            }

        } catch (IOException e) {

            System.out.println(
                    "Error reading JSON file: " + e.getMessage()
            );
        }

        return movies;
    }


    // Safely get a JSON value as String
    private static String getString(JsonObject data, String key) {

        if (!data.has(key) || data.get(key).isJsonNull()) {
            return "";
        }

        return data.get(key).toString();
    }


    // Display one movie
    private static void displayMovieDetails(Movie movie) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("             MOVIE DETAILS");
        System.out.println("========================================");

        System.out.println("ID               : " + movie.getId());
        System.out.println("Title            : " + movie.getTitle());
        System.out.println("Original Language: " + movie.getOriginalLanguage());

        System.out.println("----------------------------------------");

        System.out.println("Genres           : " + movie.getGenres());
        System.out.println("Keywords         : " + movie.getKeywords());

        System.out.println("----------------------------------------");

        System.out.println("Overview         : " + movie.getOverview());

        System.out.println("----------------------------------------");

        System.out.println("Release Year     : " + movie.getReleaseYear());
        System.out.println("Runtime          : " + movie.getRuntime() + " minutes");

        System.out.println("----------------------------------------");

        System.out.println("Vote Average     : " + movie.getVoteAverage());
        System.out.println("Vote Count       : " + movie.getVoteCount());

        System.out.println("========================================");
    }


    public static void main(String[] args) {

        String filePath = "DSA Project/data/movies_dsa.json";

        List<Movie> movies = loadMovies(filePath);

        System.out.println("Movies loaded: " + movies.size());

        if (!movies.isEmpty()) {

            Movie firstMovie = movies.get(0);

            displayMovieDetails(firstMovie);
        }
    }
}
