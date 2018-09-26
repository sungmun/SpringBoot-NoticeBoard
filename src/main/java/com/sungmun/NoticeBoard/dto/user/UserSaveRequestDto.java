package com.sungmun.NoticeBoard.dto.user;

import com.sungmun.NoticeBoard.domain.user.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSaveRequestDto {
	private String id;
	private String password;
	private String firstName;
	private String secondName;
	private String phone;
	private String email;
	
	
	public User toEntity() {
		return User.builder()
				.id(id)
				.password(password)
				.firstName(firstName)
				.secondName(secondName)
				.phone(phone)
				.email(email)
				.build();
	}
}
