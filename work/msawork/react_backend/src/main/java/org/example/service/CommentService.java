package org.example.service;

import org.example.model.CommentReqeustDTO;
import org.example.model.CommentResponseDTO;

import java.util.List;

public interface CommentService {
    void write(CommentReqeustDTO comment);
    List<CommentResponseDTO> findAll();
    CommentResponseDTO findByCommentNo(Long commentNo);
}

