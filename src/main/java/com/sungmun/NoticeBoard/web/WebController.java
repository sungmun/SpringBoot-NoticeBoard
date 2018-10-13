package com.sungmun.NoticeBoard.web;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sungmun.NoticeBoard.dto.comment.CommentReadResponseDto;
import com.sungmun.NoticeBoard.dto.comment.CommentSaveRequestDto;
import com.sungmun.NoticeBoard.service.CommentService;
import com.sungmun.NoticeBoard.service.NoticeService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {
	private NoticeService noticeService;
	private CommentService commentService;

	@GetMapping("/")
	public String main(Model model,
			@PageableDefault(sort = { "num" }, direction = Direction.DESC, size = 20, page=0) Pageable pageable) {
		model.addAttribute("notice", noticeService.findAll(pageable));
		model.addAttribute("pagecount", noticeService.pageCount(pageable));
		model.addAttribute("nowpage", pageable.getPageNumber());
		return "index";
	}

	@GetMapping("/notice")
	public String readNotice(Model model, @RequestParam long num) {
		model.addAttribute("notice", noticeService.findById(num));
		model.addAttribute("comment", commentService.findByid(num));
		return "notice/read";
	}

	@ResponseBody
	@GetMapping("/comment/read")
	public List<CommentReadResponseDto> readComment(@RequestParam long num) {
		return commentService.findByid(num);
	}
	
	@ResponseBody
	@GetMapping("/comment/write")
	public Long saveComment(@RequestBody CommentSaveRequestDto comment) {
		return commentService.save(comment);
	}

}
