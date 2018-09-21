package com.sungmun.NoticeBoard.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sungmun.NoticeBoard.service.NoticeService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {
	private NoticeService noticeService;
	
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("notice",noticeService.findAll());
		return "index";
	}
}
