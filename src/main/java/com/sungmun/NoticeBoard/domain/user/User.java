package com.sungmun.NoticeBoard.domain.user;

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
public class User extends BaseTimeEntity{
	@Id
	@Column(name="user_id",nullable = false,length = 20)
	private String id;

	@Column(name="user_password",length = 25, nullable = false)
	private String password;
	@Column(name="user_firstname",length = 5, nullable = false)
	private String firstName;
	@Column(name="user_secondname",length = 10, nullable = false)
	private String secondName;
	@Column(name="user_phone",length = 12, nullable = false)
	private String phone;
	@Column(name="user_email",length = 50, nullable = false)
	private String email;
	@Column(name="user_image",length=150)
	private String image;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Notice> noticeList=new ArrayList<>();
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Comment> commentList=new ArrayList<>();
	
	@Builder
	public User(String id, String password, String firstName, String secondName, String phone, String email,String image) {
		this.id=id;
		this.password=password;
		this.firstName=firstName;
		this.secondName=secondName;
		this.email=email;
		this.phone=phone;
		this.image=image;
	}
	
}