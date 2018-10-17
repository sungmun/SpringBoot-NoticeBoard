package com.sungmun.NoticeBoard.web;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
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
	public String main(Model model,
			@PageableDefault(sort = { "num" }, direction = Direction.DESC, size = 20, page=0) Pageable pageable) {
		model.addAttribute("notice", noticeService.findAll(pageable));
		model.addAttribute("pagecount", noticeService.pageCount(pageable));
		model.addAttribute("nowpage", pageable.getPageNumber());
		return "index";
	}

}
