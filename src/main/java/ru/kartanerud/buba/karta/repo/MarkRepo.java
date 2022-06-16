package ru.kartanerud.buba.karta.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kartanerud.buba.karta.models.Mark;

public interface MarkRepo extends JpaRepository<Mark, Long> {
}
