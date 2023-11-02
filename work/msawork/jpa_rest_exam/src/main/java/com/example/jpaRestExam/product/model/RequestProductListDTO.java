package com.example.jpaRestExam.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestProductListDTO {
    List<RequestProductDTO> list;
}
