package movie.tickets.service;

import movie.tickets.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    @Autowired
    private MainRepository mainRepository;

     /*
     query->repo->service->controller

cand adaug film adaug si 0 tickete cu pret 0 si
cu data si timpul din request

    Functionalitatea aplicatiei este de a cumpara bilete la diverse filme
    POST
    xVreau sa adaug un film nou cu/fara bilete
    xVreau sa adaug bilete la un film existent
    xVreau sa adaug cumparatori diferiti
    Comenzi cu diferiti cumparatori
    xAfisarea filmelor alfabetic/dupa startdate.
    xPretul biletelor pentru un director.

    GET
    xVreau sa vad toate filmele din BD
    xToate filmele din aceeasi data
    xVreau sa vad room&seats valabile la toate filmele dintr-o anumita zi/ora GET PARAMETRU
    xVreau sa vad room&seats valabile pt un film indiferent de zile GET PARAMETRU
    xNr de locuri disponibile pt un film.GET PARAMETRU


    DELETE
    xVreau sa sterg un film  - pentru toate datele
                            - pentru o anumita data
    xVreau sa sterg bilete pedntru un film
    Vreau sa sterg(anulez) o comanda


     */
}
