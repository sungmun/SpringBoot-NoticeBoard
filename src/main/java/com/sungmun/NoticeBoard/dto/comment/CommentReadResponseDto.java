package com.sungmun.NoticeBoard.dto.comment;

import com.sungmun.NoticeBoard.domain.comment.Comment;
import com.sungmun.NoticeBoard.dto.BaseTimeDto;

import lombok.Getter;

@Getter
public class CommentReadResponseDto extends BaseTimeDto{
	private Long num;
	private Long reCommentGroup;
	private String contents;
	private String user;
	public CommentReadResponseDto(Comment entity) {
		super(entity.getCreateDate());
		this.num=entity.getNum();
		this.reCommentGroup=entity.getReCommentGroup();
		this.contents=entity.getContents();
		this.user=entity.getUser().getId();
	}
}
