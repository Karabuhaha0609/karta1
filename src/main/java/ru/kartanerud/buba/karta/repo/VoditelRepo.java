package ru.kartanerud.buba.karta.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kartanerud.buba.karta.models.Voditel;

import java.util.List;

@Repository
public interface VoditelRepo extends JpaRepository<Voditel, Long> {
    List<Voditel> findByUserId (Long id);
}
