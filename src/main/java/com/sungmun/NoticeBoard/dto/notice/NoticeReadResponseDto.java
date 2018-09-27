package com.sungmun.NoticeBoard.dto.notice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sungmun.NoticeBoard.domain.notice.Notice;
import com.sungmun.NoticeBoard.dto.BaseTimeDto;
import com.sungmun.NoticeBoard.dto.comment.CommentReadResponseDto;

import lombok.Getter;

@Getter
public class NoticeReadResponseDto extends BaseTimeDto{
	private Long num;
	private String title;
	private String contents;
	private String fileName;
	private String user;
	private List<CommentReadResponseDto> commentList=new ArrayList<>();
	
	public NoticeReadResponseDto(Notice entity) {
		super(entity.getCreateDate());
		this.num=entity.getNum();
		this.title=entity.getTitle();
		this.contents=entity.getContents();
		this.fileName=entity.getFileName();
		this.user=entity.getUser().getId();
		this.commentList=entity.getCommentList()
				.stream()
				.map(CommentReadResponseDto::new)
				.collect(Collectors.toList());
	}
	
}
