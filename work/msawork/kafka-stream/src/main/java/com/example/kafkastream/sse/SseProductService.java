package com.example.kafkastream.sse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class SseProductService {

    private final Map<Long, SseEmitter> emitterMap = new ConcurrentHashMap();
    //모든 클라이언트가 공유해서 사용할 값이 저장된 변수 - thread-safe가 지원되는 타입
    public void add(SseEmitter clientEmitter, Long id) {
        this.emitterMap.put(id, clientEmitter);
        // 콜백메소드를 처리할 수 있도록 작업
        clientEmitter.onCompletion(() -> {
            // 처리가 완료되면 리스트에서 제거
            log.info("===============onCompletion==================");
            this.emitterMap.remove(clientEmitter);
        });
        clientEmitter.onTimeout(() -> {
            // 타임아웃이 되면 제거할 수 있도록 메소드 호출
            log.info("===============onTimeout==================");
            clientEmitter.complete();
        });
    }

    // 아이디에 해당하는 Emitter 삭제
    public void deleteById(Long id) {
        log.info("======================deleteById => {}===================", id);
        emitterMap.remove(id);
    }

    // 키로 저장된 Emitter 꺼내는 작업
    public SseEmitter get(Long id) {
        return emitterMap.get(id);
    }

    // 조건에 맞는 클라이언트에게 메시지 보내기
    // 구독신청하면 아이디와 함께 무조건 EmitterMap에 저장되는 구조
    // 추우에는 아이디에 해당하는 Emitter만 꺼내서 메시지 전송할 필요
    public void sendToClient(Object data) {
        // aLong == id
        // map에 저장된 모든 클라이언트에게 알림을 전송
        emitterMap.forEach((aLong, sseEmitter) -> {
            log.info("id ============> {}", aLong);
            log.info("emitter ============> {}", sseEmitter);
            SseEmitter clientEmitter = get(aLong);
            if (clientEmitter != null) {
                try {
                    clientEmitter.send(SseEmitter.event()
                            .id(String.valueOf(aLong))
                            .name("prd")
                            .data(data)
                    );
                } catch (IOException e) {
                    log.info("==================오류 발생===================");
                    deleteById(aLong);
                    sseEmitter.completeWithError(e);
                }
            }
        });
    }

/*
    public void change() {
        long changeVal = value.incrementAndGet(); // 값을 증가시키고 증가시킬 결과값을 long으로 반환
        // 변경된 값을 모든 구독신청한 클라이언트에 전송
        log.info("연결된 클라이언트 => {}", emitterMap.size());
        // for문을 이용해서 작업 - forEach를 지원하므로
        emitterMap.forEach(sseEmitter -> {
            try {
                sseEmitter.send(SseEmitter.event()
                        .name("valueChange")
                        .data(changeVal)
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
*/


}
