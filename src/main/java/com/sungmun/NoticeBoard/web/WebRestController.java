package com.sungmun.NoticeBoard.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sungmun.NoticeBoard.domain.user.UserRepository;
import com.sungmun.NoticeBoard.service.user.UserSaveRequestDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
	
	private UserRepository userRepository;
	
	@GetMapping("hello")
	public String hello() {
		return "HelloWold";
	}
	@PostMapping("/user")
	public void saveUser(@RequestBody UserSaveRequestDto dto) {
		userRepository.save(dto.toEntity());
	}
}
