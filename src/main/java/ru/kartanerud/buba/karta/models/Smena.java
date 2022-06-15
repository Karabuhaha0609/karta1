package ru.kartanerud.buba.karta.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import ru.kartanerud.buba.karta.models.enamy.DenNochSmena;
import ru.kartanerud.buba.karta.models.enamy.VidCar;

import javax.persistence.*;
import java.security.Principal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Smena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "smena_id")
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateSmena;
    private LocalTime denNachaloSmena;
    private LocalTime denKonecSmena;
    @Enumerated(EnumType.STRING)
    private DenNochSmena denNochSmena;
    private LocalTime nochNachaloSmena;
    private LocalTime nochKonecSmena;
    private Duration denSmenaPeriod;
    private Duration nochSmenaPeriod;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "voditel_id")
    private Voditel voditel;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Car> cars;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reis> reises;


    public Smena(Principal principal) {
    }
}
