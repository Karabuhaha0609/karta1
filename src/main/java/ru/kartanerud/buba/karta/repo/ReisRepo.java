package ru.kartanerud.buba.karta.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kartanerud.buba.karta.models.Reis;

import java.util.List;

public interface ReisRepo extends JpaRepository<Reis, Long> {
    List<Reis> findByUserId (Long id);

}
