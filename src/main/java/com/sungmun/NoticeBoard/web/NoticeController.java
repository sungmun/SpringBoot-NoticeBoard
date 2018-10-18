package com.sungmun.NoticeBoard.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sungmun.NoticeBoard.service.NoticeService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/notice")
public class NoticeController {
	NoticeService service;
	
	@GetMapping("/read")
	public String read(Model model, @RequestParam long num) {
		model.addAttribute("notice", service.findById(num));
		return "notice/read";
	}
}
