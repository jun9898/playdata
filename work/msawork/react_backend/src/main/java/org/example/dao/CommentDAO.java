package org.example.dao;

import org.example.model.CommentEntity;
import org.example.model.CommentReqeustDTO;

import java.util.List;

public interface CommentDAO {
    void write(CommentReqeustDTO commentRequest);
    List<CommentEntity> findAll();
    CommentEntity findByCommentNo(Long commentNo);
}
