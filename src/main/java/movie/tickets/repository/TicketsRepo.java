package movie.tickets.repository;

import movie.tickets.dto.AllSeatsDateTime;
import movie.tickets.dto.AllSeatsForMovie;
import movie.tickets.model.Movies;
import movie.tickets.model.Tickets;
import movie.tickets.query.TicketsQuerys;
import movie.tickets.utils.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;

@Repository
public class TicketsRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Movies> addTicketsToMovie(Tickets tickets) {
        jdbcTemplate.update(TicketsQuerys.ADD_TICKETS_SQL, tickets.getTicketNumber(), tickets.getPrice(), tickets.getMovieName(), tickets.getDate(), tickets.getTime());
        return null;
    }

    public List<Movies> removeTicketsFromMovie(Tickets tickets) {
        try {
            jdbcTemplate.update(TicketsQuerys.REMOVE_TICKETS_SQL, tickets.getTicketNumber(), tickets.getPrice(), tickets.getMovieName(), tickets.getDate(), tickets.getTime());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer priceForDirector(String director) {
        Integer price = jdbcTemplate.queryForObject(TicketsQuerys.PRICE_FOR_DIRECTOR_SQL, new Object[]{director}, Integer.class);
        return price;
    }

    public List<AllSeatsForMovie> allSeatsForMovie(String title) {
        Integer limit = jdbcTemplate.queryForObject(TicketsQuerys.SET_LIMIT_SQL, new Object[]{title}, Integer.class);
        return jdbcTemplate.queryForStream(TicketsQuerys.ALL_AVAILABLE_SEATS_FOR_MOVIE_SQL, new BeanPropertyRowMapper<>(AllSeatsForMovie.class), title, limit)
                .collect(Collectors.toList());
    }

    public List<AllSeatsDateTime> allSeatsForDate(LocalDate date, LocalTime time) {
        if (date != null && time == null) {
            Integer limit = jdbcTemplate.queryForObject(TicketsQuerys.SET_LIMIT_DATE_SQL, new Object[]{date}, Integer.class);
            return jdbcTemplate.queryForStream(TicketsQuerys.ALL_AVAILABLE_SEATS_FOR_DATE_SQL, new BeanPropertyRowMapper<>(AllSeatsDateTime.class), date, limit)
                    .collect(Collectors.toList());
        } else if (date == null && time != null) {
            Integer limit = jdbcTemplate.queryForObject(TicketsQuerys.SET_LIMIT_TIME_SQL, new Object[]{time}, Integer.class);
            return jdbcTemplate.queryForStream(TicketsQuerys.ALL_AVAILABLE_SEATS_FOR_TIME_SQL, new BeanPropertyRowMapper<>(AllSeatsDateTime.class), time, limit)
                    .collect(Collectors.toList());
        } else if (date == null && time == null) {
            throw new ObjectNotFoundException("Please provide a date or time");
        } else {
            Integer limit = jdbcTemplate.queryForObject(TicketsQuerys.SET_LIMIT_DATETIME_SQL, new Object[]{date, time}, Integer.class);
            return jdbcTemplate.queryForStream(TicketsQuerys.ALL_AVAILABLE_SEATS_FOR_DATETIME_SQL, new BeanPropertyRowMapper<>(AllSeatsDateTime.class), date, time, limit)
                    .collect(Collectors.toList());
        }
    }
}


