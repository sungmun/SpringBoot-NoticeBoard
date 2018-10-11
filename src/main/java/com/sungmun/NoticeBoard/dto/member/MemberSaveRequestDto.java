package com.sungmun.NoticeBoard.dto.member;

import java.util.Arrays;

import com.sungmun.NoticeBoard.domain.member.Member;
import com.sungmun.NoticeBoard.domain.member.MemberRole;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberSaveRequestDto {
	private String id;
	private String password;
	private String firstName;
	private String secondName;
	private String phone;
	private String email;
	private String role;
	
	public Member toEntity() {
		return Member.builder()
				.id(id)
				.password(password)
				.firstName(firstName)
				.secondName(secondName)
				.phone(phone)
				.email(email)
				.roles(Arrays.asList(new MemberRole(role)))
				.build();
	}
}
