package ru.kartanerud.buba.karta.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ClientStroy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_stroy_id")
    private Long id;
}
