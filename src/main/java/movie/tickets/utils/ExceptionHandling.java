package movie.tickets.utils;

import movie.tickets.query.LoggingQuerys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandling extends Throwable {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> contentValidation(MethodArgumentNotValidException exception) {
        Map<String, Object> body = new HashMap<>();
        List<ObjectError> errors = exception.getAllErrors();
        List<ErrorResponse> bodyResponse = errors.stream()
                .map(err -> new ErrorResponse(err.getDefaultMessage()))
                .collect(Collectors.toList());
        body.put("timestamp", LocalDate.now());
        body.put("errors", bodyResponse);
        //GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", null);
        parameters.put("service", "Excepions&Errors");
        parameters.put("info", exception.getMessage());
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(parameters);
        namedParameterJdbcTemplate.update(LoggingQuerys.LOGGING_SQL, sqlParameterSource);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ObjectNotFoundException.class})
    public ResponseEntity<Object> contentValidation(ObjectNotFoundException exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("errors", exception.getMessage());

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", null);
        parameters.put("service", "Excepions&Errors");
        parameters.put("info", exception.getMessage());
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(parameters);
        namedParameterJdbcTemplate.update(LoggingQuerys.LOGGING_SQL, sqlParameterSource, generatedKeyHolder);

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({NoParamException.class})
    public ResponseEntity<Object> contentValidation(NoParamException exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("errors", exception.getMessage());
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", null);
        parameters.put("service", "Excepions&Errors");
        parameters.put("info", exception.getMessage());
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(parameters);
        namedParameterJdbcTemplate.update(LoggingQuerys.LOGGING_SQL, sqlParameterSource, generatedKeyHolder);

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ModifyTicketException.class})
    public ResponseEntity<Object> contentValidation(ModifyTicketException exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("errors", exception.getMessage());
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", null);
        parameters.put("service", "Excepions&Errors");
        parameters.put("info", exception.getMessage());
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(parameters);
        namedParameterJdbcTemplate.update(LoggingQuerys.LOGGING_SQL, sqlParameterSource, generatedKeyHolder);

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({DataAccessException.class})
    public ResponseEntity<Object> contentValidation(DataAccessException exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("errors", exception.getMessage());
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", null);
        parameters.put("service", "Excepions&Errors");
        parameters.put("info", exception.getMessage());
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(parameters);
        namedParameterJdbcTemplate.update(LoggingQuerys.LOGGING_SQL, sqlParameterSource, generatedKeyHolder);

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<Object> contentValidation(NullPointerException exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("errors", exception.getMessage());
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", null);
        parameters.put("service", "Excepions&Errors");
        parameters.put("info", exception.getMessage());
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(parameters);
        namedParameterJdbcTemplate.update(LoggingQuerys.LOGGING_SQL, sqlParameterSource, generatedKeyHolder);

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> contentValidation(Exception exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("errors", exception.getMessage());
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", null);
        parameters.put("service", "Excepions&Errors");
        parameters.put("info", exception.getMessage());
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(parameters);
        namedParameterJdbcTemplate.update(LoggingQuerys.LOGGING_SQL, sqlParameterSource, generatedKeyHolder);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
