package ru.kartanerud.buba.karta.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kartanerud.buba.karta.models.Smena;

import java.util.List;

@Repository
public interface SmenaRepo extends JpaRepository<Smena, Long> {
    List<Smena> findByUserId (Long id);
}
