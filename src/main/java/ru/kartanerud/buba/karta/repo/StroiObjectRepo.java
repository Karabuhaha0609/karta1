package ru.kartanerud.buba.karta.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kartanerud.buba.karta.models.StroiObject;

import java.util.List;

public interface StroiObjectRepo extends JpaRepository<StroiObject, Long> {
    List<StroiObject> findByUserId (Long id);
}
