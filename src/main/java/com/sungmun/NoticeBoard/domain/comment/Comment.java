package com.sungmun.NoticeBoard.domain.comment;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sungmun.NoticeBoard.domain.BaseTimeEntity;
import com.sungmun.NoticeBoard.domain.notice.Notice;
import com.sungmun.NoticeBoard.domain.user.User;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access=AccessLevel.PROTECTED)
public class Comment extends BaseTimeEntity{
	@Id
	@GeneratedValue
	@Column(name="comment_num",nullable=false)
	private Long num;
	@Column(name="comment_contents",nullable=false)
	private String contents;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="notice_id",nullable=false)
	private Notice notice;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="member_id",nullable=false)
	private User user;
	
	@Builder
	public Comment(String contents,Long reCommentGroup,Notice notice,User user) {
		this.contents=contents;
		this.reCommentGroup=reCommentGroup;
		this.notice=notice;
		this.user=user;
	}
}
