package com.sungmun.NoticeBoard.domain.notice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.h2.command.Command;

import com.sungmun.NoticeBoard.domain.comment.Comment;
import com.sungmun.NoticeBoard.domain.user.User;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access=AccessLevel.PROTECTED)
public class Notice {
	@Id
	@GeneratedValue
	@Column(name="notice_num",nullable=false)
	private Long num;
	@Column(name="notice_title",length=50,nullable=false)
	private String title;
	@Column(name="notice_date",nullable=true)
	private LocalDateTime date;
	@Column(name="notice_count",length=16,nullable=false)
	private int count;

	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="member_id",nullable=false)
	private User user;
	
	@OneToMany(mappedBy="notice",cascade=CascadeType.ALL)
	private List<Comment> commentList=new ArrayList<>();
}
