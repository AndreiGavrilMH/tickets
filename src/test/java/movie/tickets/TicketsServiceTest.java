package movie.tickets;

import movie.tickets.model.Movies;
import movie.tickets.model.Tickets;
import movie.tickets.repository.TicketsRepo;
import movie.tickets.service.TicketsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TicketsServiceTest {

    @InjectMocks
    private TicketsService ticketsService;

    @Mock
    private TicketsRepo ticketsRepo;

    @Test
    @DisplayName("Getting price for a director")
    public void priceForDirector(String director){
        //arrange
        director = "Christopher Nolan";
        when(ticketsRepo.priceForDirector(director)).thenReturn(
                100
        );
        //act
        Integer price = ticketsRepo.priceForDirector(director);
        //assert
        assertEquals(price, 100);
    }

    @Test
    @DisplayName("Add tickets to movie to repo")
    public void addTicketsToMovie(){
        //arrange
        Tickets ticket = new Tickets(2, "Inception",10,LocalDate.of(2021,1,15),LocalTime.of(17,50),null);
        when(ticketsRepo.addTicketsToMovie(ticket)).thenReturn(anyList());

        //act
        List<Movies> result = ticketsService.addTicketsToMovie(ticket);

        //assert

    }
}
