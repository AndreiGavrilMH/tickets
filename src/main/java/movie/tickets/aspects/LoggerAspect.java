package movie.tickets.aspects;

import movie.tickets.query.LoggingQuerys;
import movie.tickets.repository.CustomerRepo;
import movie.tickets.repository.MoviesRepo;
import movie.tickets.repository.OrdersRepo;
import movie.tickets.repository.TicketsRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class LoggerAspect {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Pointcut(value = "execution (* movie.tickets.service.CustomerService.*(..))")
    public void operationCustomer() {
    }
    @Before("operationCustomer()")
    public void logPleaseCustomers(JoinPoint joinPoint) {
        System.out.println("Logging before - customer - " + joinPoint.getSignature().getName());
        Logger LOGGER = LoggerFactory.getLogger(CustomerRepo.class);

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", null);
        parameters.put("service", "Customer");
        parameters.put("info", "Logging before " + joinPoint.getSignature().getName() + "  in  " + LOGGER.getName());
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(parameters);
        namedParameterJdbcTemplate.update(LoggingQuerys.LOGGING_SQL, sqlParameterSource, generatedKeyHolder);
        LOGGER.info("============================" + generatedKeyHolder.getKey().intValue() + "================================");
        }

    @Pointcut("execution (* movie.tickets.service.MoviesService.*(..))")
    public void operationMovies() {
    }
    @Before("operationMovies()")
    public void logPleaseMovies(JoinPoint joinPoint) {
        System.out.println("Logging before - movies - " + joinPoint.getSignature().getName());
        Logger LOGGER = LoggerFactory.getLogger(MoviesRepo.class);

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", null);
        parameters.put("service", "Movies");
        parameters.put("info", "Logging before " + joinPoint.getSignature().getName() + "  in  " + LOGGER.getName());
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(parameters);
        namedParameterJdbcTemplate.update(LoggingQuerys.LOGGING_SQL, sqlParameterSource, generatedKeyHolder);
        LOGGER.info("============================" + generatedKeyHolder.getKey().intValue() + "================================");
        ;
    }

    @Pointcut("execution (* movie.tickets.service.TicketsService.*(..))")
    public void operationTickets() {
    }
    @Before("operationTickets()")
    public void logPleaseTickets(JoinPoint joinPoint) {
        System.out.println("Logging before - tickets - " + joinPoint.getSignature().getName());
        Logger LOGGER = LoggerFactory.getLogger(TicketsRepo.class);

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", null);
        parameters.put("service", "Tickets");
        parameters.put("info", "Logging before " + joinPoint.getSignature().getName() + "  in  " + LOGGER.getName());
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(parameters);
        namedParameterJdbcTemplate.update(LoggingQuerys.LOGGING_SQL, sqlParameterSource, generatedKeyHolder);
        LOGGER.info("============================" + generatedKeyHolder.getKey().intValue() + "================================");
    }

    @Pointcut("execution (* movie.tickets.service.OrderService.*(..))")
    public void operationOrder() {
    }
    @Before("operationOrder()")
    public void logPleaseOrder(JoinPoint joinPoint) {
        System.out.println("Logging before - order - " + joinPoint.getSignature().getName());
        Logger LOGGER = LoggerFactory.getLogger(OrdersRepo.class);

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", null);
        parameters.put("service", "Tickets");
        parameters.put("info", "Logging before " + joinPoint.getSignature().getName() + "  in  " + LOGGER.getName());
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(parameters);
        namedParameterJdbcTemplate.update(LoggingQuerys.LOGGING_SQL, sqlParameterSource, generatedKeyHolder);
        LOGGER.info("============================" + generatedKeyHolder.getKey().intValue() + "================================");
    }
}

