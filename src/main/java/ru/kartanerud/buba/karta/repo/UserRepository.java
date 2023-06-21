package ru.kartanerud.buba.karta.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kartanerud.buba.karta.models.Role;
import ru.kartanerud.buba.karta.models.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    List<User> findByRole(Role role);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.photo = :photo WHERE u.id = :id")
    void updatePhotoPath(@Param("id") Long id, @Param("photo") String photo);

}
