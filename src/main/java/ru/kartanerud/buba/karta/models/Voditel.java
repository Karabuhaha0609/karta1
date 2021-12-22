package ru.kartanerud.buba.karta.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Voditel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String putevoyList;
    private String instruktazh;
    private String grafikRabota;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "car",
            joinColumns = @JoinColumn(name = "voditel_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    private List<Car> cars;
}
