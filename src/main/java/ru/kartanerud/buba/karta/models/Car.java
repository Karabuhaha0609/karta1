package ru.kartanerud.buba.karta.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kartanerud.buba.karta.models.enamy.VidCar;

import javax.persistence.*;
import java.security.Principal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;
    private String markaCar;
    private String nomerCar;
    private int obiemKuzova;
    @Enumerated(EnumType.STRING)
    private VidCar vidCar;
    private String probeg;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "perevozhik_id")
    private Perevozhik perevozhik;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reis> reises;


    public Car(Principal principal) {
    }
}
