import json

input_file = "tmdb_5000_movies.json"
output_file = "movies_dsa.json"

with open(input_file, "r", encoding="utf-8") as f:
    movies = json.load(f)

result = []

for movie in movies:

    # Extract release year
    release_date = movie.get("release_date", "")
    release_year = None

    if release_date:
        try:
            release_year = int(release_date[:4])
        except ValueError:
            release_year = None

    # Extract genre names
    genres = [
        genre["name"]
        for genre in movie.get("genres", [])
        if "name" in genre
    ]

    # Extract keyword names
    keywords = [
        keyword["name"]
        for keyword in movie.get("keywords", [])
        if "name" in keyword
    ]

    clean_movie = {
        "id": movie.get("id"),
        "title": movie.get("title"),
        "overview": movie.get("overview"),
        "genres": genres,
        "keywords": keywords,
        "originalLanguage": movie.get("original_language"),
        "releaseYear": release_year,
        "runtime": movie.get("runtime"),
        "voteAverage": movie.get("vote_average"),
        "voteCount": movie.get("vote_count")
    }

    result.append(clean_movie)

with open(output_file, "w", encoding="utf-8") as f:
    json.dump(result, f, indent=2, ensure_ascii=False)

print("Created:", output_file)
print("Movies:", len(result))