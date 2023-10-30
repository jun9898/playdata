package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.CommentDAO;
import org.example.model.CommentEntity;
import org.example.model.CommentReqeustDTO;
import org.example.model.CommentResponseDTO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentDAO dao;
    @Override
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

    public List<CommentResponseDTO> Test() {
        return dao.findAll().stream()
                .map(CommentResponseDTO::from)
                .collect(Collectors.toList());
    }

    @Override
    public CommentResponseDTO findByCommentNo(Long commentNo) {
        CommentEntity data = dao.findByCommentNo(commentNo);
         CommentResponseDTO comment = CommentResponseDTO.from(data);
        return comment;
    }
}
