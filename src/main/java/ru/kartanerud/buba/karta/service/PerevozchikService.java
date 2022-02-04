package ru.kartanerud.buba.karta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kartanerud.buba.karta.models.Perevozhik;
import ru.kartanerud.buba.karta.models.Voditel;
import ru.kartanerud.buba.karta.repo.PerevozchikRepo;
import ru.kartanerud.buba.karta.repo.VoditelRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PerevozchikService {


    private final PerevozchikRepo perevozchikRepo;
    private final VoditelRepo voditelRepo;

    public List<Perevozhik> getPerevozhiks() {
        return perevozchikRepo.findAll();
    }

    public Perevozhik addPerevozhik(Perevozhik perevozhik) {
        return perevozchikRepo.save(perevozhik);
    }

    public Optional<Perevozhik> getPerevozhik(Long id) {
        return perevozchikRepo.findById(id);
    }

    public Perevozhik voditelToPerevozshik(Long perevozhikId, Long voditelId){
        Perevozhik perevozhik = perevozchikRepo.findById(perevozhikId).get();
        Voditel voditel = voditelRepo.findById(voditelId).get();
        perevozhik.voditelToPerevozchik(voditel);
        return perevozchikRepo.save(perevozhik);

    }
}


