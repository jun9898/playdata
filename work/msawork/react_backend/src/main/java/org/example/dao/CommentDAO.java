package org.example.dao;

import org.example.model.CommentEntity;
import org.example.model.CommentReqeustDTO;

import java.util.List;

public interface CommentDAO {
    void write(CommentReqeustDTO commentRequest);
    List<CommentEntity> findAll();
    CommentEntity findByCommentNo(Long commentNo);
    CommentEntity update(Long commentNo, CommentReqeustDTO comment);
    String delete(Long commentNo);
}
