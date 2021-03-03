package movie.tickets.utils;

import org.springframework.http.ResponseEntity;

public class ReturnListException extends RuntimeException{
    public ReturnListException(String message) {
        super(message);
    }
}
