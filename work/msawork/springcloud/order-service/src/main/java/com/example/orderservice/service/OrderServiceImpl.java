package com.example.orderservice.service;

import com.example.orderservice.dao.OrderDAO;
import com.example.orderservice.dao.OrderProductDAO;
import com.example.orderservice.domain.OrderEntity;
import com.example.orderservice.domain.OrderProductEntity;
import com.example.orderservice.domain.OrderRequestDTO;
import com.example.orderservice.domain.OrderResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderDAO dao; // 주문의 일반적인 내용
    private final OrderProductDAO orderProductDAO; // 주문한 상품에 대한 정보

    @Override
    public void save(OrderRequestDTO orderRequest) {
        ModelMapper mapper = new ModelMapper();
        List<OrderProductEntity> detaillist = orderRequest.getOrderDetailDTOList().stream()
                .map((detailDTO) -> {
                    return mapper.map(detailDTO, OrderProductEntity.class);
                })
                .collect(Collectors.toList());
        log.info("orderdetaillist ======================================> {}", detaillist);
        OrderEntity orderEntity = OrderEntity.makeOrderEntity(orderRequest.getAddr(),orderRequest.getCustomerId(),detaillist);
        // 양방향 관계인 경우 부모 테이블과 자실 테이블의 데이터를 모두 영속화 시켜주는 작업을 처리하면서
        // 부모 테이블에 레코드를 저장할 때 자식 테이블의 레코드를 한번에 같이 진행할 수 있다
        // 테이블에 cascade = CascadeType.ALL 이라는 옵션을 정의해 주어야 한다
        dao.save(orderEntity);
        orderProductDAO.save(orderEntity.getOrderProductList());
    }

    @Override
    public OrderResponseDTO findById(Long orderId) {
        return null;
    }

    @Override
    public List<OrderResponseDTO> findAllByCustomerId(Long customerId) {
        // dao의 메소드를 호출하고 데이터를 변환
        List<OrderResponseDTO> collect = dao.findAllByCustomerId(customerId).stream()
                .map(OrderResponseDTO::entityToDTO)
                .collect(Collectors.toList());
        for (OrderResponseDTO orderResponseDTO : collect) {
            log.info(orderResponseDTO.toString());
        }
        return collect;
    }
}
