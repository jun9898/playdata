package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.model.CommentEntity;
import org.example.model.CommentReqeustDTO;
import org.example.repository.CommentRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// private final이 추가된 멤버를 이용해서 생성자를 만들고 자동으로 injection 해준다.
@Repository
@RequiredArgsConstructor
public class CommentDAOImpl implements CommentDAO{

    private final CommentRepository commentRepository;

    @Override
    public void write(CommentReqeustDTO commentRequest) {
        // request로 넘어온 DTO를 Entity로 변환
        CommentEntity entity = new CommentEntity(commentRequest.getWriter(),
                                                commentRequest.getContent(),
                                                commentRequest.getRank());
        commentRepository.save(entity);
    }

    @Override
    public List<CommentEntity> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public CommentEntity findByCommentNo(Long id) {
        CommentEntity comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
        return comment;
    }

    @Override
    @Transactional
    public CommentEntity update(Long commentNo, CommentReqeustDTO comment) {
        // 1. 업데이트할 레코드를 조회한다.
        // 2. 조회한 레코드의 setter 메소드를 호출해서 변경할 내용을 처리
        // 데이터가 있으면 해당 데이터를 조회해서 리턴하지만 없으면 오류를 발생시키기
        // JPA가 rs를 파싱해서 엔티티로 만들어 리턴
        // 조회한 엔티티는 영속화 => 영속성 컨텍스트의 캐시에 이 엔티티가 등록
        // 등록될때 기본키로 엔티티가 등록되면서 최초의 객체의 상태가 스냅샷으로 저장
        CommentEntity updateComment = commentRepository.findById(commentNo)
                .orElseThrow(() -> new IllegalArgumentException("번호를 확인하세요"));
        // setter 메소드는 이와 같은 이유로 신중하게 설정해야함
        // setter 메소드에 의해서 엔티티의 값이 변경되고 트랜잭션이 끝나면 최초 저장된 스냅샷과 엔티티를 비교해서
        // 변화가 있는 모든 엔티티 객체를 db에 반영해준다. - Dirty Checking
        // 기본적으로 모든 필드를 업데이트
        updateComment.setContent(comment.getContent());
        updateComment.setRank(comment.getRank());
        return updateComment;
    }

    @Override
    public String delete(Long commentNo) {
        // ok가 리턴됐다는 의미는 정상 처리됐다는 의미
        commentRepository.deleteById(commentNo);
        return "ok";
    }
}
