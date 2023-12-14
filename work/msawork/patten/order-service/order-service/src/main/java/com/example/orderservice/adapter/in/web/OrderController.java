package com.example.orderservice.adapter.in.web;

import com.example.orderservice.adapter.in.web.dto.OrderDetailDTO;
import com.example.orderservice.adapter.in.web.dto.OrderRequestDTO;
import com.example.orderservice.adapter.in.web.dto.OrderResponseDTO;
import com.example.orderservice.application.port.in.OrderService;
import com.example.orderservice.application.service.OrderStringProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService service;
    private final OrderStringProducer producer;
    @PostMapping("/create")
    public void create(@RequestBody OrderRequestDTO order){
        log.info("주문내역==>{}",order);
        service.save(order);//주문하기
        //주문을 한 후 주문에 대한 결과를 리턴 받아서 주문이 성공된 것을 확인하고
        //주문된 상품 정보를 리턴받아서 이 정보로 메시지를 보낸다.
        //리턴받은 주문내역
        List<OrderDetailDTO> orderProductlist = order.getOrderDetailDTOList();
        for(OrderDetailDTO product:orderProductlist){
            log.info("주문성공한 상품:{}",product);
            producer.sendMessage("ordercreate",product);
        }
    }
    @GetMapping("/getOrders/{customerId}")
    public List<OrderResponseDTO> getOrders(@PathVariable Long customerId){
        List<OrderResponseDTO> responselist =
                service.findAllByCustomerId(customerId);
        log.info("컨트롤러:주문내역==>{}",responselist);
        return  responselist;
    }
}

