package ru.kartanerud.buba.karta.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kartanerud.buba.karta.models.enamy.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Perevozhik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String inn;
    private String BasaCoordinata;
    private String grafikRabota;
    private String LawFace;
    private String lawAddress;
    private String email;
    private Role role;
    private String phoneNumber;
    private String phoneNumberDispetcher;
    private String phoneNumberMehanik;
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Car> cars = new ArrayList<>();
    @OneToMany(mappedBy = "voditel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Voditel> voditels = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_order",
            joinColumns = @JoinColumn(name = "perevozhik_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders;


}
