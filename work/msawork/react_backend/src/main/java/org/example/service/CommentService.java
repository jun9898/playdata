package org.example.service;

import org.example.model.CommentEntity;
import org.example.model.CommentReqeustDTO;
import org.example.model.CommentResponseDTO;

import java.util.List;

public interface CommentService {
    void write(CommentReqeustDTO comment);
    List<CommentResponseDTO> findAll();
    CommentResponseDTO findByCommentNo(Long commentNo);
    CommentResponseDTO update(Long commentNo, CommentReqeustDTO comment);
    String delete(Long commentNo);
}

