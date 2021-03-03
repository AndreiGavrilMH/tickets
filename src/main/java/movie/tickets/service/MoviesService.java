package movie.tickets.service;

import movie.tickets.model.Movies;
import movie.tickets.query.TicketsQuerys;
import movie.tickets.repository.MoviesRepo;
import movie.tickets.utils.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MoviesService {
    @Autowired
    private MoviesRepo moviesRepo;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Movies> getMovies() {
        return moviesRepo.getMovies();
    }

    public List<Movies> orderMoviesByDate() {
        return moviesRepo.orderMoviesByDate();
    }

    public List<Movies> orderMoviesByName() {
        return moviesRepo.orderMoviesByName();
    }

    public List<Movies> getMoviesByDate(LocalDate date) {
        return moviesRepo.getMoviesByDate(date);
    }

    public Movies addMovie(Movies movie) {
        int checkMovie = jdbcTemplate.queryForObject(TicketsQuerys.CHECK_MOVIES_SQL, new Object[]{movie.getTitle(), movie.getStart(), movie.getTime()}, Integer.class);
        if (checkMovie == 1) {
            throw new ObjectNotFoundException("This exists in the database at the date and time provided");
        } else {
            return moviesRepo.addMovie(movie);
        }
    }

    public Movies addMovieWithTickets(Movies movie) {
        int checkMovie = jdbcTemplate.queryForObject(TicketsQuerys.CHECK_MOVIES_SQL, new Object[]{movie.getTitle(), movie.getStart(), movie.getTime()}, Integer.class);

        if (movie.getnoOfTickets() == null) {
            movie.setnoOfTickets(0);
        }
        if (movie.getPrice() == null) {
            movie.setPrice(0);
        }
        if (checkMovie == 1) {
            throw new ObjectNotFoundException("This exists in the database at the date and time provided");
        } else {
            return moviesRepo.addMovieWithTickets(movie);
        }
    }

    public List<Movies> deleteMovieForAllDates(String title) {
        return moviesRepo.deleteMovieForAllDates(title);
    }

    public List<Movies> deleteMovieOnDate(String title, LocalDate date) {
        return moviesRepo.deleteMovieOnDate(title, date);
    }
}
