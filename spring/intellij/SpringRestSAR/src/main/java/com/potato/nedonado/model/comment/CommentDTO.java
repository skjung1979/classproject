package com.potato.nedonado.model.comment;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CommentDTO {

    private long commentIdx;
    private long boardIdx;
    private long userIdx;
    private String nickname;
    private String content;
    private long writeDate;

    public CommentViewInfo toCommentView(){
        return new CommentViewInfo(commentIdx, boardIdx, userIdx, nickname, content, Util.convertLongTimestampToString(writeDate));
    }

}
