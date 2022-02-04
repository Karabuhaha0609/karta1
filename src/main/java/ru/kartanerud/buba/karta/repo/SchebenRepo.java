package ru.kartanerud.buba.karta.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kartanerud.buba.karta.models.Scheben;

import java.util.List;

public interface SchebenRepo extends JpaRepository<Scheben, Long> {
    Scheben findByKarierId(Long karierId);
    List<Scheben> findAllByKarierId(Long karierId);

}
