package com.sungmun.NoticeBoard.service.notice;

import com.sungmun.NoticeBoard.domain.notice.Notice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeSaveRequestDto {
	private String title;
	private int count;
	private String contents;
	
	public Notice toEntity() {
		return Notice.builder()
				.title(title)
				.count(count)
				.contents(contents)
				.build();
	}
}
