package com.sungmun.NoticeBoard.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sungmun.NoticeBoard.dto.member.MemberSaveRequestDto;
import com.sungmun.NoticeBoard.service.MemberService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/member")
public class MemberController {
	MemberService service;

	@GetMapping("/login")
	public String login(HttpServletRequest request) {
		request.getSession().setAttribute("prevPage", request.getHeader("Referer"));
		return "member/login";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}

	@GetMapping("/register")
	public String register() {
		return "member/register";
	}

	@PostMapping("/create")
	public String create(MemberSaveRequestDto dto) {
		dto.setRole("BASIC");
		service.save(dto);
		return "redirect:/";
	}
}
