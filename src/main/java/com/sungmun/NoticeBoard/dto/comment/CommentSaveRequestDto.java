package com.sungmun.NoticeBoard.dto.comment;

import com.sungmun.NoticeBoard.domain.comment.Comment;
import com.sungmun.NoticeBoard.domain.notice.Notice;
import com.sungmun.NoticeBoard.domain.user.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentSaveRequestDto {
	private String contents;
	private Notice notice;
	private User user;
	
	public Comment toEntity() {
		return Comment.builder()
				.contents(contents)
				.notice(notice)
				.user(user)
				.build();
	}
}
