package ru.kartanerud.buba.karta.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kartanerud.buba.karta.models.Karier;

@Repository
public interface KarierRepo extends JpaRepository<Karier, Long> {

}
