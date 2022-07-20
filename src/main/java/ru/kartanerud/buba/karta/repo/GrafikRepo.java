package ru.kartanerud.buba.karta.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.kartanerud.buba.karta.models.Grafik;

public interface GrafikRepo extends JpaRepository<Grafik, Long> {
    @Override
    @EntityGraph(attributePaths = {"model.mark"})
    Page<Grafik> findAll(Pageable pageable);
}
