package com.sungmun.NoticeBoard.domain.user;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import com.sungmun.NoticeBoard.service.LocalDatePersistenceConverter;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
	@Id
	@Column(name="user_id",length = 20)
	private String id;

	@Column(name="user_password",length = 25, nullable = false)
	private String password;
	@Column(name="user_firstname",length = 5, nullable = false)
	private String firstName;
	@Column(name="user_secondname",length = 10, nullable = false)
	private String secondName;
	@Column(name="joindate")
	private LocalDateTime joindate;
	@Column(name="user_phone",length = 12, nullable = false)
	private String phone;
	@Column(name="user_email",length = 50, nullable = false)
	private String email;
	@Column(name="user_image",length=150)
	private String image;
	
}
