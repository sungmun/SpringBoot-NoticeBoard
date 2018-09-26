package com.sungmun.NoticeBoard.dto.notice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.sungmun.NoticeBoard.domain.notice.Notice;

import lombok.Getter;

@Getter
public class NoticeMainResponseDto {
	private Long num;
	private String title;
	private String user;
	private String createDate;
	
	public NoticeMainResponseDto(Notice entity) {
		num=entity.getNum();
		title=entity.getTitle();
		user=entity.getUser().getId();
		createDate=toStringDateTime(entity.getCreateDate());
	}
	private String toStringDateTime(LocalDateTime dateTime) {
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-mm-dd");
		return Optional.ofNullable(dateTime)
				.map(formatter::format)
				.orElse("");
	}
}
