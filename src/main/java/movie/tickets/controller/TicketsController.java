package movie.tickets.controller;

import movie.tickets.model.Movies;
import movie.tickets.model.Tickets;
import movie.tickets.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketsController {

    @Autowired
    private TicketsService ticketsService;

    @PostMapping("/addTicketsToMovie")
    public List<Movies> addTicketsToMovie(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Tickets tickets) {
        return ticketsService.addTicketsToMovie(tickets);
    }

    @PostMapping("/removeTickets")
    public List<Movies> removeTicketsFromMovie(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Tickets tickets) {
        return ticketsService.removeTicketsFromMovie(tickets);
    }

    @GetMapping("/priceForDirector")
    public ResponseEntity<?> priceForDirector(@RequestParam String director) {
        return ResponseEntity.ok().body(ticketsService.priceForDirector(director));
    }

    @GetMapping("/seatsForMovie")
    public ResponseEntity<?> allSeatsForMovie(@RequestParam String title) {
        return ResponseEntity.ok().body(ticketsService.allSeatsForMovie(title));
    }

    @GetMapping("/seatsForDateOrTime")
    public ResponseEntity<?> allSeatsForDate(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime time) {
        return ResponseEntity.ok().body(ticketsService.allSeatsForDate(date, time));
    }
}
