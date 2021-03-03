package movie.tickets.controller;

import movie.tickets.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class MainController {
    @Autowired
    private MainService mainService;


}
