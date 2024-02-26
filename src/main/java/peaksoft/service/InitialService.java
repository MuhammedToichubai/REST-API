package peaksoft.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.models.Developer;
import peaksoft.repository.DeveloperRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Mukhammed Asantegin
 */
@Service
@RequiredArgsConstructor
public class InitialService {
    private final DeveloperRepository developerRepo;


    @PostConstruct
    private void initMethod(){
        List<Developer> developers = List.of(
                new Developer("Baktygul", "baktygul@gmail.com", "Java", BigDecimal.valueOf(1500)),
                new Developer("Aiturgan", "aiturgan@gmail.com", "JS", BigDecimal.valueOf(1700)),
                new Developer("Gulumkan", "gulumkan@gmail.com", "C#", BigDecimal.valueOf(1800)),
                new Developer("Myrzaiym", "myrzaiym@gmail.com", "C++", BigDecimal.valueOf(2000)),
                new Developer("Nurislam", "nur@gmail.com", "Java", BigDecimal.valueOf(1400)),
                new Developer("Nurtaazim", "nurtaziim@gmail.com", "Java", BigDecimal.valueOf(1200))
        );
       developerRepo.saveAll(developers);
    }



}
