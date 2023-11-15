package com.example.productservice.service;

import com.example.productservice.dto.ItemDTO;
import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ShopDataDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommunicationServiceImpl implements CommunicationService{

    private final RestTemplate restTemplate;

    @Override
    public List<ProductRequest> getProductList(){
        URI uri = UriComponentsBuilder.fromUriString("https://openapi.naver.com")
                .path("/v1/search/shop.json")
                .queryParam("query", "곰탕")
                .queryParam("display", 10)
                .queryParam("start", 1)
                .queryParam("sort", "sim")
                .encode()
                .build()
                .toUri();

        // 헤더를 직접 설정하는 방법
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        headers.add("X-Naver-Client-Id", "_nKgKitXwFuXqG3zh1ns");
        headers.add("X-Naver-Client-Secret", "LPdmqV5GKH");

        ResponseEntity<ShopDataDTO> response = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), ShopDataDTO.class);
        log.info(response.getBody().toString());

//        ModelMapper의 기능을 이용해서 작업
        ModelMapper mapper = new ModelMapper();
        PropertyMap<ItemDTO, ProductRequest> propertyMap = new PropertyMap<ItemDTO, ProductRequest>() {
            @Override
            protected void configure() {
//                map() 은 ProductRequets객체를 리턴하므로 ProductRequest 객체의 setter를 호출해서 ItemDTO의 값으로 셋팅하도록 코드를 구현
//                원본 객체를 source 객체로 지정
                map().setProductName(source.getTitle());
                map().setPrice(source.getLprice());
                map().setInfo(source.getBrand());
                map().setImage(source.getImage());
            }
        };
        // 변환정보를 담은 PropertyMap을 ModelMapper에 등록
        mapper.addMappings(propertyMap);
//        mapper.addMappings(propertyMap);
        // List에 담긴 데이터를 Stream으로 변환한 후 ModelMapper를 이용해서 데이터의 타입을 ItemDTO -> ProductRequest로 전환
        List<ProductRequest> list = response.getBody().getItems().stream()
                .map(item -> mapper.map(item, ProductRequest.class)) //map 메소드는 스트림에서 객체를 하나씩 꺼내서 변경작업을 수행
                .collect(Collectors.toList()); // 변환되어 저장된 스트림 객체를 List로 변환
        log.info(response.getBody().toString());

        return list;
    }
}
