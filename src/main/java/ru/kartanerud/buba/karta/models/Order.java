package ru.kartanerud.buba.karta.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.kartanerud.buba.karta.models.enamy.OrderStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private BigDecimal sum;
    private String address;
    @OneToMany(mappedBy = "orders", cascade = CascadeType.REFRESH)
    private List<OrderDetails> orderDetails = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @ManyToMany(mappedBy = "orders")
    private List <Perevozhik> perevozhiks = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reis> reises;
    @ManyToMany(mappedBy = "orders")
    private List <StroiObject> stroiObjects = new ArrayList<>();
    private Long Objem;
    @ManyToMany(mappedBy = "orders")
    private List <Scheben> schebens = new ArrayList<>();

    public void addStroiObjectToOrder(StroiObject stroiObject) {
        stroiObject.setOrders((List<Order>) this);
        stroiObjects.add(stroiObject);}

}
