package com.sungmun.NoticeBoard.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sungmun.NoticeBoard.dto.member.MemberSaveRequestDto;
import com.sungmun.NoticeBoard.service.MemberService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MemberController {
	MemberService service;

	@GetMapping("/login")
	public String login() {
		return "member/login";
	}

	@GetMapping("/register")
	public String register() {
		return "member/register";
	}

	@PostMapping("/member/create")
	public String create(MemberSaveRequestDto dto) {
		dto.setRole("BASIC");
		service.save(dto);
		return "redirect:/";
	}
}
