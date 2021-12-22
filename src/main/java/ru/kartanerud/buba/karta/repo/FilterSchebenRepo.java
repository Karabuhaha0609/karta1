package ru.kartanerud.buba.karta.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kartanerud.buba.karta.models.Scheben;
import ru.kartanerud.buba.karta.models.enamy.scheben.*;

import java.util.List;

public interface FilterSchebenRepo extends JpaRepository<Scheben, Long> {
    List<Scheben> findAllByFrakcia(Frakcia frakcia);
    List<Scheben> findAllByMarkaProchnosti(MarkaProchnosti markaProchnosti);
    List<Scheben> findAllByVidScheben(VidScheben vidScheben);
    List<Scheben> findAllByRadioaktivnost(Radioaktivnost radioaktivnost);

    List<Scheben> findAllByGost(Gost gost);
    List<Scheben> findAllByLeshadnost(Leshadnost leshadnost);
    List<Scheben> findAllByMarkaPoIsteraemosti(MarkaPoIsteraemosti markaPoIsteraemosti);
    List<Scheben> findAllByMorozostoikost(Morozostoikost morozostoikost);

}
