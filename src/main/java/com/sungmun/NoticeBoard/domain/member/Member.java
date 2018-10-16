package com.sungmun.NoticeBoard.domain.member;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.sungmun.NoticeBoard.domain.BaseTimeEntity;
import com.sungmun.NoticeBoard.domain.comment.Comment;
import com.sungmun.NoticeBoard.domain.notice.Notice;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {
	@Id
	@Column(name = "member_id", nullable = false, length = 20)
	private String id;

	@Column(name = "member_password", nullable = false)
	private String password;
	@Column(name = "member_firstname", length = 15, nullable = false)
	private String firstName;
	@Column(name = "member_secondname", length = 20, nullable = false)
	private String secondName;
	@Column(name = "member_phone", length = 30, nullable = false)
	private String phone;
	@Column(name = "member_email", length = 50, nullable = false)
	private String email;
	@Column(name = "member_image", length = 150)
	private String image;

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	@Transient
	private List<Notice> noticeList = new ArrayList<>();
	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	@Transient
	private List<Comment> commentList = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	private List<MemberRole> roles;

	@Builder
	public Member(String id, String password, String firstName, String secondName, String phone, String email,
			String image, List<MemberRole> roles) {

		this.id = id;
		this.password = password;
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
		this.phone = phone;
		this.image = image;
		this.roles = roles;
	}

}
