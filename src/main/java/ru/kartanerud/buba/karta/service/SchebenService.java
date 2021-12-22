package ru.kartanerud.buba.karta.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kartanerud.buba.karta.exception.SchebenNotFoundException;
import ru.kartanerud.buba.karta.models.Scheben;
import ru.kartanerud.buba.karta.repo.SchebenRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SchebenService {
    private final SchebenRepo schebenRepo;


    public Scheben addScheben(Scheben scheben){
        return schebenRepo.save(scheben);
    }
    public List<Scheben> getSchebens(){
        return schebenRepo.findAll();
    }
    public Scheben getScheben(Long id) {
        return schebenRepo.findById(id).orElseThrow(() -> new SchebenNotFoundException(id));
    }
        public Scheben getSchebenKarierId(Long karierId){
            return schebenRepo.findByKarierId(karierId);
    }
    public Scheben deleteScheben(Long id){
        Scheben scheben = getScheben(id);
        schebenRepo.delete(scheben);
        return scheben;
    }
    @Transactional
    public Scheben editScheben(Long id, Scheben scheben){
        Scheben schebenToEdit = getScheben(id);
        schebenToEdit.setGost(scheben.getGost());
        schebenToEdit.setVidScheben(scheben.getVidScheben());
        schebenToEdit.setFrakcia(scheben.getFrakcia());
        schebenToEdit.setMarkaProchnosti(scheben.getMarkaProchnosti());
        schebenToEdit.setNasypnayaPlotnost(scheben.getNasypnayaPlotnost());
        schebenToEdit.setSoderzhanieIlistyh(scheben.getSoderzhanieIlistyh());
        schebenToEdit.setMorozostoikost(scheben.getMorozostoikost());
        schebenToEdit.setRadioaktivnost(scheben.getRadioaktivnost());
        schebenToEdit.setSlabyePorody(scheben.getSlabyePorody());
        schebenToEdit.setLeshadnost(scheben.getLeshadnost());
        schebenToEdit.setMarkaPoIsteraemosti(scheben.getMarkaPoIsteraemosti());
        schebenToEdit.setPrice(scheben.getPrice());
        return schebenToEdit;
    }
}
