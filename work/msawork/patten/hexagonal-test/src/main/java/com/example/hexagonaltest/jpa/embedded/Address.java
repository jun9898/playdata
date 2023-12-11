package com.example.hexagonaltest.jpa.embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class Address {
    private String city;
    private String addr1;
    private String addr2;
    private String zipcode;
}
