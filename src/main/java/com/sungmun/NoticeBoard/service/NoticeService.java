package com.sungmun.NoticeBoard.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sungmun.NoticeBoard.domain.notice.NoticeRepository;
import com.sungmun.NoticeBoard.dto.notice.NoticeMainResponseDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class NoticeService {
	private NoticeRepository noticeRepository;
	
	@Transactional(readOnly=true)
	public List<NoticeMainResponseDto> findAll(Pageable pageable){
		return noticeRepository.findAll(pageable)
				.stream()
				.map(NoticeMainResponseDto::new)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public int pageCount(Pageable pageable) {
		return noticeRepository.findAll(pageable).getTotalPages();
	}
}
