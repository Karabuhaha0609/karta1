package ru.kartanerud.buba.karta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListItemDto {
    private Long id;
    private String value;
}
