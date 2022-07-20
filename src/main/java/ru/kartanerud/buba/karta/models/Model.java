package ru.kartanerud.buba.karta.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import ru.kartanerud.buba.karta.util.EntityIdResolver;

import javax.persistence.*;

@Entity
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        scope = Model.class,
        resolver = EntityIdResolver.class,
        property = "id"
)
public class Model implements ComboListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private Mark mark;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private VoditelWeb voditelWeb;

    @Override
    @JsonIgnore
    public String getRepr() {
        return String.format("%s %s", mark.getName(), name);
    }
}
