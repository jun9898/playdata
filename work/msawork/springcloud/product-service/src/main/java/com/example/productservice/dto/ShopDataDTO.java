package com.example.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDataDTO {

    private String lastBuildDate;
    private String total;
    private String start;
    private String display;
    // json의 키값과 변수명이 같아야 매핑된다
    private List<ItemDTO> items = new ArrayList<>();


}
