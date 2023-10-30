package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CommentResponseDTO {
    private Long commentNo;
    private String writer;
    private String content;
    private int rank;
    private Date writeData;

    public static CommentResponseDTO from(CommentEntity entity) {
        return CommentResponseDTO.builder()
                .commentNo(entity.getCommentNo())
                .writer(entity.getWriter())
                .content(entity.getContent())
                .rank(entity.getRank())
                .writeData(entity.getWriteData())
                .build();
    }
}
