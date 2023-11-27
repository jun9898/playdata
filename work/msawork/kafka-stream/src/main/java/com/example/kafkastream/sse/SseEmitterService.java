package com.example.kafkastream.sse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Slf4j
public class SseEmitterService {
    // SSE 작업을 하면서 SseEmitter 객체를 생성하는 경우 비동기 요청이 완료되거나 타임아웃이 발생하면 콜백을 통해 이 상황을 관리할 수 있다.
    // SseEmitter를 관리하는 쓰레드는 다른 쓰레드에서 실행
    // SseEmitter를 저장하는 자료구조는 thread-safe한 자료  구조를 사용해야 한다.
    // 그렇지 않은 경우는 Exception이 발생한다.
    // Thread-safe 한 자료구조를 이용해서 작업
    // Map
    // private final Map<Long, SseEmitter> emitters = new ConcurrentHashMap<>();
    // List
    private final List<SseEmitter> emmiters = new CopyOnWriteArrayList<>();
    //모든 클라이언트가 공유해서 사용할 값이 저장된 변수 - thread-safe가 지원되는 타입
    private static final AtomicLong value = new AtomicLong();

    public SseEmitter add(SseEmitter clientEmitter) {
        this.emmiters.add(clientEmitter);
        // 콜백메소드를 처리할 수 있도록 작업
        clientEmitter.onCompletion(() -> {
            // 처리가 완료되면 리스트에서 제거
            log.info("===============onCompletion==================");
            this.emmiters.remove(clientEmitter);

        });
        clientEmitter.onTimeout(() -> {
            // 타임아웃이 되면 제거할 수 있도록 메소드 호출
            log.info("===============onTimeout==================");
            clientEmitter.complete();
        });
        return clientEmitter;
    }

    // 모든 클라이언트가 공유하는 데이터를 변경하고 변경된 값을 연결된 모든 클라이언트에 전송
    // long형의 데이터를 정의하고 정의한 값을 공유해서 한 클라이언트가 변경하면 모든 클라이언트에서 확인할 수 있도록 작업
    public void change() {
        long changeVal = value.incrementAndGet(); // 값을 증가시키고 증가시킬 결과값을 long으로 반환
        // 변경된 값을 모든 구독신청한 클라이언트에 전송
        log.info("연결된 클라이언트 => {}", emmiters.size());
        // for문을 이용해서 작업 - forEach를 지원하므로
        emmiters.forEach(sseEmitter -> {
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
}
