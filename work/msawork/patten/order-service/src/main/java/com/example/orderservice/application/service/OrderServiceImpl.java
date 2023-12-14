package com.example.orderservice.application.service;

import com.example.orderservice.adapter.in.web.dto.OrderRequestDTO;
import com.example.orderservice.adapter.in.web.dto.OrderResponseDTO;
import com.example.orderservice.application.port.in.OrderService;
import com.example.orderservice.application.port.out.KafkaEventOutputPort;
import com.example.orderservice.application.port.out.OrderDAO;
import com.example.orderservice.application.port.out.OrderProductDAO;
import com.example.orderservice.domain.entity.OrderEntity;
import com.example.orderservice.domain.entity.OrderProductEntity;
import com.example.orderservice.domain.kafka.KafkaSendDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderDAO dao; //주문의 일반적인 내용
    private final OrderProductDAO detaildao;//주문한 상품에 대한 정보
    private final KafkaEventOutputPort eventOutputPort;
    @Override
    @Transactional
    public void save(OrderRequestDTO orderrequest) {
        //  //주문한상품들에 대한 정보를 저장할 수 있도록 생성
        ModelMapper mapper = new ModelMapper();
        log.info("orderdetaillist=>{}",orderrequest);
        List<OrderProductEntity> detaillist = orderrequest.getOrderDetailDTOList().stream()
                                        .map((detailDTO) ->{
                                            return mapper.map(detailDTO,OrderProductEntity.class);
                                        }).collect(Collectors.toList());
        log.info("================================================");
        log.info("orderdetaillist=>{}",detaillist);
        log.info("================================================");
        //주문생성
        OrderEntity orderEntity =
                OrderEntity.makeOrderEntity(
                        orderrequest.getAddr(),orderrequest.getCustomerId(),detaillist);
        log.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        log.info("저장전:{}",orderEntity);
        //양방향관계인 경우 부모테이블과 자식테이블의 데이터를 모두 영속화시켜주는 작업을 처리하면서
        //부모테이블에 레코드를 저장할때 자식테이블의 레코드를 한 번에 같이 진행할 수 있다.
        //테이블에 cascade = CascadeType.ALL이라는 옵션을 정의해 주어야 한다.
        try {
            OrderEntity resultEntity = dao.save(orderEntity);
            //주문이 정상 완료 메시지를 카프카로 전송
            //기존 데이터를 이용해서 kafka로 전송할 메시지를 생성
            KafkaSendDTO kafkasenddata = mapper.map(orderEntity,KafkaSendDTO.class);
            System.out.println(kafkasenddata);
            //주문내용을 카프카로 전송
            eventOutputPort.orderEvent(kafkasenddata);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public OrderResponseDTO findById(Long orderId) {
        return null;
    }

    @Override
    public List<OrderResponseDTO> findAllByCustomerId(Long customerId) {
        //dao의 메소드를 호출하고 데이터를 변환
        List<OrderEntity> orders = dao.getOrders(customerId);
        //List<OrderEntity> -> List<OrderResponseDTO>
        ModelMapper mapper = new ModelMapper();
        List<OrderResponseDTO> orderlist = orders.stream()
                .map(dto ->
                        mapper.map(dto,OrderResponseDTO.class))
                .collect(Collectors.toList());
        return orderlist;
    }
}










