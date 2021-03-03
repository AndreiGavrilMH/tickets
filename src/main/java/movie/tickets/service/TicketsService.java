package movie.tickets.service;

import movie.tickets.dto.AllSeatsDateTime;
import movie.tickets.dto.AllSeatsForMovie;
import movie.tickets.model.Movies;
import movie.tickets.model.Tickets;
import movie.tickets.query.TicketsQuerys;
import movie.tickets.repository.TicketsRepo;
import movie.tickets.utils.ModifyTicketException;
import movie.tickets.utils.NoParamException;
import movie.tickets.utils.ReturnListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class TicketsService {
    @Autowired
    private TicketsRepo ticketsRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Movies> addTicketsToMovie(Tickets tickets) {
        try {
            if (tickets.getTime() == null) {
                throw new NoParamException("Please add a time to the movie");
            } else if (tickets.getDate() == null) {
                throw new NoParamException("Please add a date to the movie");
            } else {

                int checkTitle = jdbcTemplate.queryForObject(TicketsQuerys.CHECK_TITLE_SQL, new Object[]{tickets.getMovieName()}, Integer.class);
                int checkTitleDate = jdbcTemplate.queryForObject(TicketsQuerys.CHECK_TITLE_DATE_MOVIES_SQL, new Object[]{tickets.getMovieName(), tickets.getDate()}, Integer.class);
                int checkTitleTime = jdbcTemplate.queryForObject(TicketsQuerys.CHECK_TITLE_TIME_MOVIES_SQL, new Object[]{tickets.getMovieName(), tickets.getTime()}, Integer.class);
                int checkMovie = jdbcTemplate.queryForObject(TicketsQuerys.CHECK_MOVIES_SQL, new Object[]{tickets.getMovieName(), tickets.getDate(), tickets.getTime()}, Integer.class);

                if (checkTitle == 0) {
                    throw new ModifyTicketException("No movie found with that title");
                } else if (checkTitle != 0 && checkTitleDate != 0 && checkTitleTime == 0) {
                    throw new ModifyTicketException("There is a movie on that date but at a different time");
                } else if (checkTitle != 0 && checkTitleTime != 0 && checkTitleDate == 0) {
                    throw new ModifyTicketException("There is a movie on that time but at a different date");
                } else if (checkMovie == 0) {
                    throw new ModifyTicketException("No movie found on the date and time provided");
                } else {
                    ticketsRepo.addTicketsToMovie(tickets);
                }
            }
        } catch (
                NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Movies> removeTicketsFromMovie(Tickets tickets) {
        try {
            if (tickets.getTime() == null) {
                throw new NoParamException("Please add a time to the movie");
            } else if (tickets.getDate() == null) {
                throw new NoParamException("Please add a date to the movie");
            } else {

                int checkTitle = jdbcTemplate.queryForObject(TicketsQuerys.CHECK_TITLE_SQL, new Object[]{tickets.getMovieName()}, Integer.class);
                int checkTitleDate = jdbcTemplate.queryForObject(TicketsQuerys.CHECK_TITLE_DATE_MOVIES_SQL, new Object[]{tickets.getMovieName(), tickets.getDate()}, Integer.class);
                int checkTitleTime = jdbcTemplate.queryForObject(TicketsQuerys.CHECK_TITLE_TIME_MOVIES_SQL, new Object[]{tickets.getMovieName(), tickets.getTime()}, Integer.class);
                int checkMovie = jdbcTemplate.queryForObject(TicketsQuerys.CHECK_MOVIES_SQL, new Object[]{tickets.getMovieName(), tickets.getDate(), tickets.getTime()}, Integer.class);

                if (checkTitle == 0) {
                    throw new ModifyTicketException("No movie found with that title");
                } else if (checkTitle != 0 && checkTitleDate != 0 && checkTitleTime == 0) {
                    throw new ModifyTicketException("There is a movie on that date but at a different time");
                } else if (checkTitle != 0 && checkTitleTime != 0 && checkTitleDate == 0) {
                    throw new ModifyTicketException("There is a movie on that time but at a different date");
                } else if (checkMovie == 0) {
                    throw new ModifyTicketException("No movie found on the date and time provided");
                } else {
                    ticketsRepo.removeTicketsFromMovie(tickets);
                }
            }
        } catch (
                NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer priceForDirector(String director) {
        if (director == null) {
            throw new NoParamException("Please provide a name");
        }
        int checkDirector = jdbcTemplate.queryForObject(TicketsQuerys.SEE_ALL_MOVIES_TITLE_SQL, new Object[]{director}, Integer.class);

        if (checkDirector == 0) {
            throw new ReturnListException("There are no movies with that director");
        }

        return ticketsRepo.priceForDirector(director);
    }

    public List<AllSeatsForMovie> allSeatsForMovie(String title) {
        return ticketsRepo.allSeatsForMovie(title);
    }

    public List<AllSeatsDateTime> allSeatsForDate(LocalDate date, LocalTime time) {
        return ticketsRepo.allSeatsForDate(date, time);
    }
}
