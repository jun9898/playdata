package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.CommentReqeustDTO;
import org.example.model.CommentResponseDTO;
import org.example.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {

    private final CommentService service;

    // @RequestBody 어노테이션을 param 값 앞에 붙혀주면 json데이터를 받아올 수 있다.
    // 해당 작업으로 받아온 request는 service단에서 Entity로 변환해주는 작업을 해줘야 한다.
    // 그 이유는 repository에 JPARepository를 상속할때 CommentEntity로 선언해놨기 때문이다.
    @PostMapping("/create")
    public ResponseEntity<?> createComment(@RequestBody CommentReqeustDTO request) {
        // 서비스의 write메소드를 호출해서 매개변수로 전달되는 request객체를 넘겨준다.
        service.write(request);
        // 작업이 성공하면 200번을 반환한다
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        List<CommentResponseDTO> alldata = service.findAll();
        return ResponseEntity.ok(alldata);
    }

    @GetMapping("/read/{commentNo}")
    public ResponseEntity<?> read(@PathVariable/* ("commentNo") 생략이 가능하다 */ Long commentNo) {
        return ResponseEntity.ok(service.findByCommentNo(commentNo));
    }

    @PutMapping("/update/{commentNo}")
    public ResponseEntity<?> update(@PathVariable Long commentNo, @RequestBody CommentReqeustDTO request){
        return ResponseEntity.ok(service.update(commentNo, request));
    }

    @DeleteMapping("/delete/{commentNo}")
    public ResponseEntity<?> delete(@PathVariable Long commentNo) {
        return ResponseEntity.ok(service.delete(commentNo));
    }
}
