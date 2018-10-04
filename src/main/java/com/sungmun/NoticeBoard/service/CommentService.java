package com.sungmun.NoticeBoard.service;

import java.util.List;
import java.util.stream.Collectors;

import com.sungmun.NoticeBoard.domain.comment.CommentRepository;
import com.sungmun.NoticeBoard.dto.comment.CommentReadResponseDto;

public class CommentService {
	private CommentRepository repository;
	public List<CommentReadResponseDto> findByid(final long noticeId){
		return repository.findAll()
				.stream()
				.filter(comment->(comment.getNotice().getNum()==noticeId))
				.map(CommentReadResponseDto::new)
				.collect(Collectors.toList());
	}
}
