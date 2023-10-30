package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.model.CommentEntity;
import org.example.model.CommentReqeustDTO;
import org.example.repository.CommentRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

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
}
