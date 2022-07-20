package ru.kartanerud.buba.karta.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import ru.kartanerud.buba.karta.util.EntityIdResolver;

import javax.persistence.*;

@Data
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        scope = Mark.class,
        resolver = EntityIdResolver.class,
        property = "id"
)
public class Mark implements ComboListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private VoditelWeb voditelWeb;
}
