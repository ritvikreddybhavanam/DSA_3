package model;

public class Movie {

    private int id;
    private String title;
    private String overview;
    private String genres;
    private String keywords;
    private String originalLanguage;
    private int releaseYear;
    private String runtime;
    private String voteAverage;
    private String voteCount;

    public Movie(
            int id,
            String title,
            String overview,
            String genres,
            String keywords,
            String originalLanguage,
            int releaseYear,
            String runtime,
            String voteAverage,
            String voteCount) {

        this.id = id;
        this.title = title;
        this.overview = overview;
        this.genres = genres;
        this.keywords = keywords;
        this.originalLanguage = originalLanguage;
        this.releaseYear = releaseYear;
        this.runtime = runtime;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public Movie(int id, String title, String originalTitle, String overview, String genres, String keywords, String originalLanguage, String releaseDate, String runtime, String popularity, String voteAverage, String voteCount, String budget, String revenue, String status, String tagline) {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getGenres() {
        return genres;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public String getVoteCount() {
        return voteCount;
    }
}