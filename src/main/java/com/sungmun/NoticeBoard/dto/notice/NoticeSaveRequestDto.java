package com.sungmun.NoticeBoard.dto.notice;

import com.sungmun.NoticeBoard.domain.member.Member;
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
	private String member;
	private String contents;
	
	public Notice toEntity() {
		return Notice.builder()
				.title(title)
				.count(count)
				.member(Member.builder().id(member).build())
				.contents(contents)
				.build();
	}
}
