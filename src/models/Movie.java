package models;

import persistance.CsvSerilizable;

import java.time.LocalDateTime;

public class Movie implements CsvSerilizable, Comparable {
    public static int maxId = 0;
    private int id;
    private String name;
    private Coordinates coordinates;
    private LocalDateTime creationDate;
    private Long oscarsCount;
    private long totalBoxOffice;
    private long usaBoxOffice;
    private MovieGenre genre;
    private Person person;


    public Movie(int id, String name, Coordinates coordinates, LocalDateTime creationDate, Long oscarsCount, long totalBoxOffice, long usaBoxOffice, MovieGenre genre, Person person) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.oscarsCount = oscarsCount;
        this.totalBoxOffice = totalBoxOffice;
        this.usaBoxOffice = usaBoxOffice;
        this.genre = genre;
        this.person = person;
    }

    public Movie(String name, Coordinates coordinates, Long oscarsCount, long totalBoxOffice, long usaBoxOffice, MovieGenre genre, Person person) {
        this.id = ++maxId;
        this.creationDate = LocalDateTime.now();
        this.name = name;
        this.coordinates = coordinates;
        this.oscarsCount = oscarsCount;
        this.totalBoxOffice = totalBoxOffice;
        this.usaBoxOffice = usaBoxOffice;
        this.genre = genre;
        this.person = person;
    }

    @Override
    public String toString() {
        return String.format("Movie(id=%s, totalBoxOffice=%s)", id, totalBoxOffice);
    }

    @Override
    public int compareTo(Object o) {
        return (int) (totalBoxOffice - ((Movie) o).getTotalBoxOffice());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Long getOscarsCount() {
        return oscarsCount;
    }

    public void setOscarsCount(Long oscarsCount) {
        this.oscarsCount = oscarsCount;
    }

    public long getTotalBoxOffice() {
        return totalBoxOffice;
    }

    public void setTotalBoxOffice(long totalBoxOffice) {
        this.totalBoxOffice = totalBoxOffice;
    }

    public long getUsaBoxOffice() {
        return usaBoxOffice;
    }

    public void setUsaBoxOffice(long usaBoxOffice) {
        this.usaBoxOffice = usaBoxOffice;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setId(int id) {
        this.id = id;
    }
}
