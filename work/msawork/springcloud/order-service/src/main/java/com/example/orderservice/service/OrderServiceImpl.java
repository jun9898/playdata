package com.example.orderservice.service;

import com.example.orderservice.dao.OrderDAO;
import com.example.orderservice.dao.OrderProductDAO;
import com.example.orderservice.domain.OrderEntity;
import com.example.orderservice.domain.OrderProductEntity;
import com.example.orderservice.domain.OrderRequestDTO;
import com.example.orderservice.domain.OrderResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderDAO dao; // 주문의 일반적인 내용
    private final OrderProductDAO orderProductDAO; // 주문한 상품에 대한 정보

    @Override
    @Transactional
    public void save(OrderRequestDTO orderRequest) {
        ModelMapper mapper = new ModelMapper();
        List<OrderProductEntity> detaillist = orderRequest.getOrderDetailDTOList().stream()
                .map((detailDTO) -> {
                    return mapper.map(detailDTO, OrderProductEntity.class);
                })
                .collect(Collectors.toList());
        log.info("orderdetaillist ======================================> {}", detaillist);
        OrderEntity orderEntity = OrderEntity.makeOrderEntity(orderRequest.getAddr(),orderRequest.getCustomerId(),detaillist);
        dao.save(orderEntity);
    }

//    @Override
//    @Transactional
//    public void progress(OrderRequest orderRequest) {
//        ModelMapper mapper = new ModelMapper();
//        OrderEntity entity = mapper.map(orderRequest,OrderEntity.class);
//
//        List<OrderProductEntity> orderProductEntityList = orderRequest.getOrderProductRequestList().stream()
//                .map((item) -> {
//                    item.setMyorder(entity);
//                    return  mapper.map(item,OrderProductEntity.class);
//                }).collect(Collectors.toList());
//        OrderEntity entity1 = OrderEntity.makeOrderEntity(entity.getAddr(),entity.getCustomerId(),orderProductEntityList);
//        dao.progressOrder(entity1);
//        orderProductDAO.progressOrderProduct(orderProductEntityList);
//    }

    @Override
    public OrderResponseDTO findById(Long orderId) {
        return null;
    }

    @Override
    public List<OrderResponseDTO> findAllByCustomerId(Long customerId) {
        return null;
    }
}
