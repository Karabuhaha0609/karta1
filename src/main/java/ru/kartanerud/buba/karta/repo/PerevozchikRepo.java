package ru.kartanerud.buba.karta.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kartanerud.buba.karta.models.Perevozhik;

import java.util.List;

@Repository
public interface PerevozchikRepo extends JpaRepository<Perevozhik, Long> {
   List<Perevozhik> findPerevozchikById (Long id);
}
