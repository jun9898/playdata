package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.CommentDAO;
import org.example.model.CommentEntity;
import org.example.model.CommentReqeustDTO;
import org.example.model.CommentResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentDAO dao;

    // 메소드가 종료될때 rollback을 할지 commit을 할지 결정하겠다는 의미
    @Override
    @Transactional
    public void write(CommentReqeustDTO comment) {
        dao.write(comment);
    }

    // 클라이언트에게 엔티티를 response하지 않도록
    // 서비스에서 엔티티를 response할 dto로 변환하는 작업을 수행
    @Override
    public List<CommentResponseDTO> findAll() {
        return dao.findAll().stream()
                .map(CommentResponseDTO::from)
                .collect(Collectors.toList());
    }

    // 한건을 조회하는 기능이므로 트랜잭션 처리는 필요없지만
    // JPA 내부에 있는 기능을 끄기 위해서 사용
    // JPA에는 변경감지라는 내부 기능을 사용하지 않겠다는 의미
    // 변경감지 : 엔티티가 변경이 됐는지 안됐는지를 JPA 내부에서 계속 감시한다,
    // 그 후 변경이 되었다면 커밋을 하는 시점에서 자동으로 update를 날린다
    @Transactional(readOnly = true)
    @Override
    public CommentResponseDTO findByCommentNo(Long commentNo) {
        return CommentResponseDTO
                .from(dao.findByCommentNo(commentNo));
    }

    @Override
    public CommentResponseDTO update(Long commentNo, CommentReqeustDTO comment) {
        CommentEntity update = dao.update(commentNo, comment);
        return CommentResponseDTO.from(update);
    }

    @Override
    public String delete(Long commentNo) {
        return dao.delete(commentNo);
    }
}
