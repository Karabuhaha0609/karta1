package ru.kartanerud.buba.karta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kartanerud.buba.karta.exception.KarierNotFoundException;
import ru.kartanerud.buba.karta.models.Karier;
import ru.kartanerud.buba.karta.repo.KarierRepo;
import ru.kartanerud.buba.karta.repo.SchebenRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class KarierService {
    private final KarierRepo karierRepo;
    private final SchebenRepo schebenRepo;

    public List<Karier> getKariers() {
        return karierRepo.findAll();
    }

    public Karier addKarier(Karier karier) {
        return karierRepo.save(karier);

    }

    public Karier getKarier(Long id) {
        return karierRepo.findById(id).orElseThrow(() -> new KarierNotFoundException(id));
    }
    //пробный мэни то ван
   public Karier getSchebenToKarier(Long karierId) {
       Optional < Karier > karier1 = karierRepo.findById(karierId);
       return karier1.get();
   }


    @Transactional
    public Karier editKarier(Long id, Karier karier){
        Karier karierToEdit = getKarier(id);
        karierToEdit.setKarierName(karier.getKarierName());
        karierToEdit.setKarierAddress(karier.getKarierAddress());
        karierToEdit.setKarierLawFace(karier.getKarierLawFace());
        karierToEdit.setLawAddress(karier.getLawAddress());
        karierToEdit.setEmail(karier.getEmail());
        karierToEdit.setCoordinates(karier.getCoordinates());
        karierToEdit.setInn(karier.getInn());
        karierToEdit.setOblast(karier.getOblast());
        karierToEdit.setNomerLicenzia(karier.getNomerLicenzia());
        karierToEdit.setDataLicenzia(karier.getDataLicenzia());
        karierToEdit.setGrafikRabota(karier.getGrafikRabota());
        karierToEdit.setNalichieVesov(karier.getNalichieVesov());
        karierToEdit.setContactObshiy(karier.getContactObshiy());
        karierToEdit.setContactDiretor(karier.getContactDiretor());
        karierToEdit.setContactVesovaya(karier.getContactVesovaya());
        karierToEdit.setDopContact(karier.getDopContact());
        karierToEdit.setCommentOpen(karier.getCommentOpen());
        karierToEdit.setCommentClose(karier.getCommentClose());
        karierToEdit.setKodZhd(karier.getKodZhd());
        return karierToEdit;
    }

    public Karier deleteKarier(Long id) {
        Karier karier = getKarier(id);
        karierRepo.delete(karier);
        return karier;
    }
}




