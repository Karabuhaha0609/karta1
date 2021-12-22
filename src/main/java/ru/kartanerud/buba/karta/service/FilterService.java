package ru.kartanerud.buba.karta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kartanerud.buba.karta.models.Scheben;
import ru.kartanerud.buba.karta.models.enamy.scheben.*;
import ru.kartanerud.buba.karta.repo.FilterSchebenRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FilterService {

    @Autowired
    private final FilterSchebenRepo filterSchebenRepo;


    public List<Scheben> filterFrakcia(Frakcia frakcia){
        return filterSchebenRepo.findAllByFrakcia(frakcia);
    }

         public List<Scheben> filterMarkaProchnosti(MarkaProchnosti markaProchnosti){
       return filterSchebenRepo.findAllByMarkaProchnosti(markaProchnosti);
       }

    public List<Scheben> filterVidScheben(VidScheben vidScheben){
       return filterSchebenRepo.findAllByVidScheben(vidScheben);
    }
      public List<Scheben> filterGost(Gost gost){
       return filterSchebenRepo.findAllByGost(gost);
    }
    public List<Scheben> filterRadioaktivnost(Radioaktivnost radioaktivnost){
        return filterSchebenRepo.findAllByRadioaktivnost(radioaktivnost);
    }
    public List<Scheben> filterLeshadnost(Leshadnost leshadnost){
        return filterSchebenRepo.findAllByLeshadnost(leshadnost);
    }
    public List<Scheben> filterMarkaPoIsteraemosti(MarkaPoIsteraemosti markaPoIsteraemosti){
        return filterSchebenRepo.findAllByMarkaPoIsteraemosti(markaPoIsteraemosti);
    }
    public List<Scheben> filterMorozostoikost(Morozostoikost morozostoikost){
        return filterSchebenRepo.findAllByMorozostoikost(morozostoikost);
    }

    public List<Scheben> findAll() {
        return filterSchebenRepo.findAll();
    }
}
