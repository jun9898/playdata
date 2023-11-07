package com.example.springsecuritytest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SampleDTO2 {

    private String id;
    private String pass;
    private String name;
    private String addr;
    private String memo;

}
