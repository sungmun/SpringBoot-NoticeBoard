package com.sungmun.NoticeBoard.web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sungmun.NoticeBoard.dto.member.MemberSaveRequestDto;
import com.sungmun.NoticeBoard.service.MemberService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/member")
public class MemberController {
	MemberService service;
	
	@PostMapping("/create")
	public String create(@RequestBody MemberSaveRequestDto dto) {
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		service.save(dto);
		return "redirect:/";
	}
}
