package com.sungmun.NoticeBoard.domain.comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sungmun.NoticeBoard.domain.BaseTimeEntity;
import com.sungmun.NoticeBoard.domain.member.Member;
import com.sungmun.NoticeBoard.domain.notice.Notice;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@AllArgsConstructor
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTimeEntity {
	@Id
	@GeneratedValue
	@Column(name = "comment_num", nullable = false)
	private Long num;
	@Column(name = "comment_contents", nullable = false)
	private String contents;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "notice_id", nullable = false)
	private Notice notice;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;
}
