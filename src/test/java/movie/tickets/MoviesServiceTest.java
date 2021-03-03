package movie.tickets;

import movie.tickets.model.Movies;
import movie.tickets.repository.MoviesRepo;
import movie.tickets.service.MoviesService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class MoviesServiceTest {
    @InjectMocks
    private MoviesService moviesService;
    @Mock
    private MoviesRepo moviesRepo;

    @Test
    @DisplayName("Get all movies")
    public void getMovies(){
        //arrange
        when(moviesRepo.getMovies()).thenReturn(
                Arrays.asList(
                        new Movies("Interstellar","SF","Nolan", LocalDate.of(2021,01,15),10,10, LocalTime.of(17,50)),
                        new Movies("Inception","SF","Nolan", LocalDate.of(2021,01,15),10,10, LocalTime.of(17,50))
                )
        );
        //act
        List<Movies> result = moviesService.getMovies();

        //assert
        Movies m = result.get(0);
        assertEquals(result.size(), 2);
        assertEquals(m.getnoOfTickets(), 10);
        assertEquals(m.getPrice(), 10);
    }


}

