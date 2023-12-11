package com.example.hexagonaltest.jpa.embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class Item {
    private Long id;
    private LocalDate createDate;
    private boolean state;
}
