package com.sungmun.NoticeBoard.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sungmun.NoticeBoard.dto.comment.CommentReadResponseDto;
import com.sungmun.NoticeBoard.dto.comment.CommentSaveRequestDto;
import com.sungmun.NoticeBoard.service.CommentService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/comment")
public class CommentController {
	CommentService service;
	
	@ResponseBody
	@GetMapping("/read")
	public List<CommentReadResponseDto> read(@RequestParam long num) {
		return service.findByid(num);
	}
	
	@ResponseBody
	@GetMapping("/write")
	public Long save(@RequestBody CommentSaveRequestDto comment) {
		return service.save(comment);
	}
}
