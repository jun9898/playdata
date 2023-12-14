package com.example.productservice.application.service;

import com.example.productservice.adapter.in.web.dto.ItemDTO;
import com.example.productservice.adapter.in.web.dto.ProductRequest;
import com.example.productservice.adapter.in.web.dto.ShopDataDTO;
import com.example.productservice.application.port.in.CommunicationServiceInPort;
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

@Service
@RequiredArgsConstructor
@Slf4j
public class CommunicationServiceImpl implements CommunicationServiceInPort {
    private final RestTemplate restTemplate;
    @Override
    public List<ProductRequest> getProductList() {
        URI uri = UriComponentsBuilder.fromUriString("https://openapi.naver.com")
                .path("/v1/search/shop.json")
                .queryParam("query","원피스")
                .queryParam("display","10")
                .queryParam("start","1")
                .encode()
                .build()
                .toUri();
        //헤더정보를 셋팅할 수 있는 객체를 생성
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json",
                                            Charset.forName("UTF-8")));
        headers.add("X-Naver-Client-Id","6SNE0klYZDWPPhdN4Yc_");
        headers.add("X-Naver-Client-Secret","7F7By2RJnL");

        //응답정보를 받기
        ResponseEntity<ShopDataDTO> response = restTemplate.exchange(uri, HttpMethod.GET,
                                                new HttpEntity<>(headers),ShopDataDTO.class);
        //log.info(response.getBody());
        //ModelMapper의 기능을 이용해서 작업
        ModelMapper mapper = new ModelMapper();
        PropertyMap<ItemDTO,ProductRequest> propertyMap = new PropertyMap<ItemDTO, ProductRequest>() {
            @Override
            protected void configure() {
                //map()은 ProductRequest객체를 리턴하므로 ProductRequest객체의 setter를 호출해서
                //ItemDTO의 값으로 셋팅하도록 코드를 구현
                //원본객체를 source객체로 작업
                map().setProductName(source.getTitle());
                map().setPrice(source.getLprice());
                map().setInfo(source.getBrand());
                map().setImage(source.getImage());
            }
        };
        //변환정보를 담은 PropertyMap을 ModelMapper에 등록
        mapper.addMappings(propertyMap);
        //List에 담긴 데이터를 Stream으로 변환한 후 ModelMapper를 이용해서 데이터의 타입을 ItemDTO -> ProdctRequest로 변환
        List<ProductRequest> list = response.getBody().getItems().stream()   //스트림객체로 변환
                .map(item -> mapper.map(item,ProductRequest.class)) //map메소드는 스트림에서 객체를 하나씩 꺼내서
                                                                    //변경작업을 수행
                .collect(Collectors.toList());//변환되어 저장된 스트림객체를 List로 변환
        log.info("list=>{}",list);
        log.info("response=>{}",response);
        return list;
    }
}
