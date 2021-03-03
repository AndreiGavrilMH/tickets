package movie.tickets.config;

import movie.tickets.aspects.LoggerAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class AopConfig {
    @Bean
    public LoggerAspect loggerAspect (){
        return new LoggerAspect();
    }
}
