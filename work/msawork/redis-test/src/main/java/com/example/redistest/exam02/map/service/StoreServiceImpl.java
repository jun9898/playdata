package com.example.redistest.exam02.map.service;

import com.example.redistest.exam02.map.dao.StoreDAO;
import com.example.redistest.exam02.map.dto.StoreResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{

    private final StoreDAO dao;
    private final MapRedisService redisService;

    @Override
    public List<StoreResponseDTO> getStoreList() {
        ModelMapper mapper = new ModelMapper();
        List<StoreResponseDTO> storelist = dao.getStoreList()
                .stream()
                .map(store -> mapper.map(store, StoreResponseDTO.class))
                .collect(Collectors.toList());
        return storelist;
    }

    @Override
    public List<StoreResponseDTO> getStoreFilter(double latitude, double longitude) {
        ModelMapper mapper = new ModelMapper();
        List<StoreResponseDTO> storelist = dao.getStoreList()
                .stream()
                .map(store ->
                {
                    store.setDistance(calculateDistance(latitude, longitude,
                            store.getLatitude(), store.getLongitude()));
                    return mapper.map(store, StoreResponseDTO.class);
                })
                .filter(store -> store.getDistance() < 2)
                .collect(Collectors.toList());
        System.out.println("=====================================");
        System.out.println("storelist = " + storelist);
        System.out.println("=====================================");
        return storelist;
    }

    // redis에서 데이터를 조회하나 redis에서 문제가 발생한 경우 데이터베이스에서 데이터를 조회
    @Override
    public List<StoreResponseDTO> getRedisStoreFilter() {
        ModelMapper mapper = new ModelMapper();
        List<StoreResponseDTO> storeList = redisService.redisFindAll();
        // 오류가 발생하면 빈 리스트를 리턴하도록 했기 때문에 리스트가 empty가 아니라는 것은 정상처리
        if (!storeList.isEmpty()){
            return storeList;
        } else {
            System.out.println("=====================================");
            System.out.println("storelist = " + storeList);
            System.out.println("=====================================");
            // redis에 오류가 발생되면 장애의 이유 - 디비에서 조회해서 리턴
            return dao.getStoreList()
                    .stream()
                    .map(store -> mapper.map(store, StoreResponseDTO.class))
                    .collect(Collectors.toList());
        }
    }

    //최단거리 구하기, 하버사인 공식(Haversine Formula)
    // Haversine formula
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        double earthRadius = 6371; //Kilometers - 지구의 반지름
        return earthRadius * Math.acos(Math.sin(lat1) * Math.sin(lat2)
                + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
    }
}
