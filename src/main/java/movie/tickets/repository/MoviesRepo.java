package movie.tickets.repository;

import movie.tickets.model.Movies;
import movie.tickets.query.MoviesQuerys;
import movie.tickets.query.TicketsQuerys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MoviesRepo {

    @Autowired
    public JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Movies> getMovies() {
        return jdbcTemplate.query(MoviesQuerys.GET_ALL_MOVIES, new BeanPropertyRowMapper<>(Movies.class));
    }

    public List<Movies> orderMoviesByDate() {
        return jdbcTemplate.query(MoviesQuerys.GET_ALL_ORDERED_MOVIES_BY_DATE, new BeanPropertyRowMapper<>(Movies.class));
    }

    public List<Movies> orderMoviesByName() {
        return jdbcTemplate.query(MoviesQuerys.GET_ALL_ORDERED_MOVIES_BY_NAME, new BeanPropertyRowMapper<>(Movies.class));
    }

    public List<Movies> getMoviesByDate(LocalDate date) {
        return jdbcTemplate.queryForStream(MoviesQuerys.GET_MOVIES_BY_DATE, new BeanPropertyRowMapper<>(Movies.class), date)
                .collect(Collectors.toList());
    }

    public Movies addMovie(Movies m) {
        try {
            GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
            Map<String, String> parameters = new HashMap<>();
            parameters.put("id", null);
            parameters.put("title", m.getTitle());
            parameters.put("genre", m.getGenre());
            parameters.put("director", m.getDirector());
            parameters.put("start", Date.valueOf(m.getStart()).toString());
            parameters.put("time", m.getTime().toString());
            SqlParameterSource sqlParameterSource = new MapSqlParameterSource(parameters);
            namedParameterJdbcTemplate.update(MoviesQuerys.ADD_JUST_MOVIE_SQL, sqlParameterSource, generatedKeyHolder);
            jdbcTemplate.update(TicketsQuerys.INSERT_TICKETS_SQL, 0, m.getTitle(), m.getPrice(), m.getStart(), m.getTime(), generatedKeyHolder.getKey().intValue());

            for (int i = 1; i <= 30; i++) { //30 e numarul maxim de locuri din cinema (2 sali de 15 locuri)
                jdbcTemplate.update(MoviesQuerys.CONNECT_MOVIES_TO_CIMENAS, i, generatedKeyHolder.getKey().intValue());
            }

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Movies addMovieWithTickets(Movies m) {
        try {
            GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
            Map<String, String> parameters = new HashMap<>();
            parameters.put("id", null);
            parameters.put("title", m.getTitle());
            parameters.put("genre", m.getGenre());
            parameters.put("director", m.getDirector());
            parameters.put("start", Date.valueOf(m.getStart()).toString());
            parameters.put("time", m.getTime().toString());
            SqlParameterSource sqlParameterSource = new MapSqlParameterSource(parameters);
            namedParameterJdbcTemplate.update(MoviesQuerys.ADD_JUST_MOVIE_SQL, sqlParameterSource, generatedKeyHolder);
            jdbcTemplate.update(TicketsQuerys.INSERT_TICKETS_SQL, m.getnoOfTickets(), m.getTitle(), m.getPrice(), generatedKeyHolder.getKey().intValue());

            for (int i = 1; i <= 30; i++) { //30 e numarul maxim de locuri din cinema (2 sali de 15 locuri)
                jdbcTemplate.update(MoviesQuerys.CONNECT_MOVIES_TO_CIMENAS, i, generatedKeyHolder.getKey().intValue());
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Movies> deleteMovieForAllDates(String title) {
        try {
            jdbcTemplate.update(MoviesQuerys.DELETE_MOVIE_SQL, title);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Movies> deleteMovieOnDate(String title, LocalDate date) {
        try {
            jdbcTemplate.update(MoviesQuerys.DELETE_MOVIE_ON_DATE_SQL, title, date);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}