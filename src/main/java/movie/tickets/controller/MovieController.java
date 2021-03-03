package movie.tickets.controller;

import movie.tickets.model.Movies;
import movie.tickets.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping("/getMovies")
    public List<Movies> getMovies() {
        return moviesService.getMovies();
    }
    @GetMapping("/orderMoviesByDate")
    public List<Movies> orderMoviesByDate() {
        return moviesService.orderMoviesByDate();
    }
    @GetMapping("/orderMoviesByName")
    public List<Movies> orderMoviesByName() {
        return moviesService.orderMoviesByName();
    }
    @GetMapping("/getMoviesByDate")
    public ResponseEntity<?> getMovieByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return ResponseEntity.ok().body(moviesService.getMoviesByDate(date));
    }

    @PostMapping("/addMovieNoTickets")
    public ResponseEntity<?> addMovie(@RequestBody @Valid Movies movie) {
        try{
            return ResponseEntity.ok().body(moviesService.addMovie(movie));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/addMovieWithTickets")
    public ResponseEntity<?> addMovieWithTickets(@RequestBody @Valid Movies movie) {
        try{
            return ResponseEntity.ok().body(moviesService.addMovieWithTickets(movie));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteMovieAll")
    public List<Movies> deleteMovieForAllDates(@RequestParam String title){
        return moviesService.deleteMovieForAllDates(title);
    }

    @DeleteMapping("/deleteMovieOn")
    public List<Movies> deleteMovieOnDate(@RequestParam String title, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return moviesService.deleteMovieOnDate(title, date);
    }
}
