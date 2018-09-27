package com.sungmun.NoticeBoard.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class BaseTimeDto {
	protected String createDate;
	public BaseTimeDto(LocalDateTime dateTime) {
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-mm-dd");
		createDate= Optional.ofNullable(dateTime)
				.map(formatter::format)
				.orElse("");
	}
}
