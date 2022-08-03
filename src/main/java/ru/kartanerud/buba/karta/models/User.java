package ru.kartanerud.buba.karta.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kartanerud.buba.karta.models.enamy.Role;
import ru.kartanerud.buba.karta.models.enamy.Status;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String firstName;
    private String LastName;
    @Column(name = "password", length = 1000)
    private String password;
    @Column(name = "email", unique = true)
    private String email;
    private boolean active;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @OneToOne(cascade = CascadeType.REMOVE)
    private Bucket bucket;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    private String phoneNumber;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Voditel> voditels = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Car> cars = new ArrayList<>();
/*    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image avatar;*/
    private LocalDateTime dateOfCreate;
    /*инициализация локалдейт*/
    @PrePersist
    private void init(){
        dateOfCreate = LocalDateTime.now();
    }
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reis> reises;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StroiObject> stroiObjects = new ArrayList<>();


}
