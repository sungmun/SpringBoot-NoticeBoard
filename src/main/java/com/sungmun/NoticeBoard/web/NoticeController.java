package com.sungmun.NoticeBoard.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import com.sungmun.NoticeBoard.dto.comment.CommentReadResponseDto;
import com.sungmun.NoticeBoard.service.CommentService;
import com.sungmun.NoticeBoard.service.NoticeService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class NoticeController {
	NoticeService noticeService;
	CommentService commentService;
	
	@GetMapping("/notice/read")
	@ResponseBody
	public String read(@RequestParam long num) throws IOException {
		TemplateLoader templateLoader = new ClassPathTemplateLoader();
        templateLoader.setPrefix("/templates");
        templateLoader.setSuffix(".hbs");
 
        Handlebars handlebarsEngine = new Handlebars(templateLoader);
 
        Template view = handlebarsEngine.compile("notice/readLayout");
        Template InfoLayer = handlebarsEngine.compile("notice/read");
        Template commentLayer = handlebarsEngine.compile("notice/comment/read");
        Template topLayer=handlebarsEngine.compile("common/topbar");
        
        Map<String, String> model = new HashMap<String, String>();
        model.put("commentTemplate", commentLayer.text());
        model.put("topbar", topLayer.apply(""));
        model.put("notice", InfoLayer.apply(noticeService.findById(num)));
        model.put("readComment",commentLayer.apply(commentService.findByid(num)));
        return view.apply(model);
	}	
	
}
