package com.sungmun.NoticeBoard.web;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import com.sungmun.NoticeBoard.dto.comment.CommentReadResponseDto;
import com.sungmun.NoticeBoard.dto.comment.CommentSaveRequestDto;
import com.sungmun.NoticeBoard.dto.notice.NoticeSaveRequestDto;
import com.sungmun.NoticeBoard.service.CommentService;
import com.sungmun.NoticeBoard.service.MemberService;
import com.sungmun.NoticeBoard.service.NoticeService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class NoticeController {
	NoticeService noticeService;
	CommentService commentService;
	MemberService memberService;

	@GetMapping("/notice/read")
	public String read(Model model, @RequestParam long num) throws IOException {
		TemplateLoader loader = new ClassPathTemplateLoader();
		loader.setPrefix("/templates");
		loader.setSuffix(".hbs");

		Handlebars handlebarsEngine = new Handlebars(loader);

		Template commentLayer = handlebarsEngine.compile("/notice/comment/read");

		model.addAttribute("commentTemplate", commentLayer.text());
		model.addAttribute("notice", noticeService.findById(num));
		model.addAttribute("comment", commentService.findByid(num));
		return "/notice/readLayout";
	}

	@GetMapping("/notice/write")
	public String write() {
		return "notice/write";
	}

	@PostMapping("/notice/write")
	public String saveNotice(Principal principal, NoticeSaveRequestDto dto) {
		dto.setMember(principal.getName());
		noticeService.save(dto);
		return "notice/write";
	}

	@GetMapping("/comment/read")
	@ResponseBody
	public List<CommentReadResponseDto> commentRead(@RequestParam long num) {
		return commentService.findByid(num);
	}

	@PostMapping("/comment/write")
	@ResponseBody
	public List<CommentReadResponseDto> commentWrite(Principal principal, @RequestBody CommentSaveRequestDto dto) {
		dto.setMember(principal.getName());
		commentService.save(dto);

		return commentService.findByid(dto.getNotice());
	}
}
