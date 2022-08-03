package ru.kartanerud.buba.karta.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.security.Principal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Voditel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voditel_id")
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String phoneNumber;
    private String putevoyList;
    private String instruktazh;
    private String grafikRabota;
    private String email;
    @ManyToOne
    @JoinColumn(name = "perevozhik_id")
    private Perevozhik perevozhik;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reis> reises;

    public  Voditel(Principal principal) {
    }


    public void setUsername(String username) {
    }
}
