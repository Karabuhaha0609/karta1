package ru.kartanerud.buba.karta.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kartanerud.buba.karta.models.Order;
import ru.kartanerud.buba.karta.models.Voditel;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findByUserId (Long id);
 /*   List<Order> findByOrderDetailsId (Long orderDetailsId);
    List<Order> findByStroiObjectId (Long stroiObjectId);
    List<Order> findBySchebenId (Long schebenId);*/
}
