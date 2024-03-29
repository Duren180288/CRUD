package testgroup.filmography.dao;

import org.springframework.stereotype.Repository;
import testgroup.filmography.model.Film;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class FilmDAOImpl  implements FilmDAO{
    private static final AtomicInteger AUTO_ID = new AtomicInteger(1);
    private static Map<Integer, Film> films = new HashMap<>();

    static {
        Film film1 = new Film();
        film1.setId(AUTO_ID.getAndIncrement());
        film1.setTitle("Inception");
        film1.setYear(2010);
        film1.setGenre("sci-fi");
        film1.setWatched(true);
        films.put(film1.getId(), film1);

        Film film2 = new Film();
        film2.setId(AUTO_ID.getAndIncrement());
        film2.setTitle("Terminator");
        film2.setYear(1986);
        film2.setGenre("sci-fi");
        film2.setWatched(true);
        films.put(film2.getId(), film2);


// + film2, film3, film4, ...

    }
        @Override
    public List<Film> allFilms() {
        return new ArrayList<>(films.values());
    }

    @Override
    public void add(Film film) {
        film.setId(AUTO_ID.getAndIncrement());
        films.put(film.getId(), film);

    }

    @Override
    public void delete(Film film) {
        films.remove(film.getId());

    }

    @Override
    public void edit(Film film) {
        films.put(film.getId(),film);

    }

    @Override
    public Film getById(int id) {
        return films.get(id);
    }
}
