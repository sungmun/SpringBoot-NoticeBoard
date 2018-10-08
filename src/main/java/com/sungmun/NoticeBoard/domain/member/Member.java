package com.sungmun.NoticeBoard.domain.member;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sungmun.NoticeBoard.domain.BaseTimeEntity;
import com.sungmun.NoticeBoard.domain.comment.Comment;
import com.sungmun.NoticeBoard.domain.notice.Notice;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity{
	@Id
	@Column(name="member_id",nullable = false,length = 20)
	private String id;

	@Column(name="member_password",length = 25, nullable = false)
	private String password;
	@Column(name="member_firstname",length = 5, nullable = false)
	private String firstName;
	@Column(name="member_secondname",length = 10, nullable = false)
	private String secondName;
	@Column(name="member_phone",length = 12, nullable = false)
	private String phone;
	@Column(name="member_email",length = 50, nullable = false)
	private String email;
	@Column(name="member_image",length=150)
	private String image;
	
	@OneToMany(mappedBy="member",cascade=CascadeType.ALL)
	private List<Notice> noticeList=new ArrayList<>();
	
	@OneToMany(mappedBy="member",cascade=CascadeType.ALL)
	private List<Comment> commentList=new ArrayList<>();
	
	@Builder
	public Member(String id, String password, String firstName, String secondName, String phone, String email,String image) {
		this.id=id;
		this.password=password;
		this.firstName=firstName;
		this.secondName=secondName;
		this.email=email;
		this.phone=phone;
		this.image=image;
	}
	
}