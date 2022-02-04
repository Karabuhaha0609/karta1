package ru.kartanerud.buba.karta.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kartanerud.buba.karta.models.Bucket;

public interface BucketRepo extends JpaRepository<Bucket, Long> {
}
