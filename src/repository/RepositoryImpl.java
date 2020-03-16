package repository;

import models.Movie;
import persistance.CsvEncoder;
import persistance.MovieDecoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;

public class RepositoryImpl implements Repository {
    private HashSet<Movie> movies;
    private File in;
    private LocalDateTime initTime;

    public RepositoryImpl(File in) throws FileNotFoundException {
        this.movies = load(in);
        this.in = in;
    }

    private HashSet<Movie> load(File in) throws FileNotFoundException {
        MovieDecoder movieDecoder = new MovieDecoder(in);
        initTime = LocalDateTime.now();
        return movieDecoder.decode();
    }

    @Override
    public void add(Movie movie) {
        this.movies.add(movie);
    }

    @Override
    public void updateById(Movie movie, int id) {
        movies.removeIf(movie1 -> movie1.getId() == id);
        movie.setId(id);
        movies.add(movie);
    }

    @Override
    public void removeById(int id) {
        movies.removeIf(movie -> movie.getId() == id);
    }

    @Override
    public void clear() {
        movies.clear();
    }

    @Override
    public void save() throws IOException, IllegalAccessException {
        CsvEncoder csvEncoder = new CsvEncoder(in);
        csvEncoder.encode(movies.toArray());
    }

    @Override
    public void addIfMin(Movie movie) {
        Optional<Movie> minM = movies.stream().min(Movie::compareTo);
        if (minM.isPresent()) {
            movies.add(movie);
            return;
        }
        if (movie.compareTo(minM) < 0) {
            movies.add(movie);
        }
    }

    @Override
    public void removeLower(Movie movie) {
        movies.removeIf(movie1 -> movie1.compareTo(movie) < 0);
    }

    @Override
    public Optional<Movie> maxByTotalBoxOffice() {
        return movies.stream().max(Movie::compareTo);
    }

    @Override
    public Long countByTotalBoxOffice(Long target) {
        return movies.stream().filter(movie -> movie.getTotalBoxOffice() == target).count();
    }

    @Override
    public HashSet<Movie> filterContainsName(String name) {
        return (HashSet<Movie>) movies.stream().filter(movie -> movie.getName().contains(name));
    }

    @Override
    public String getInfoAboutCollection() {
        return String.format("размер коллекции: %s\nдата инициализации: %s", movies.size(), initTime);
    }
}
