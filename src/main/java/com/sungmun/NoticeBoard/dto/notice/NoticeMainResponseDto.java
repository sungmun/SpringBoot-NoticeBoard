package com.sungmun.NoticeBoard.dto.notice;

import com.sungmun.NoticeBoard.domain.notice.Notice;
import com.sungmun.NoticeBoard.dto.BaseTimeDto;

import lombok.Getter;

@Getter
public class NoticeMainResponseDto extends BaseTimeDto{
	private Long num;
	private String title;
	private String user;
	
	public NoticeMainResponseDto(Notice entity) {
		super(entity.getCreateDate());
		num=entity.getNum();
		title=entity.getTitle();
		user=entity.getUser().getId();
	}
}
