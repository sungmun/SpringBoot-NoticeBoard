package com.sungmun.NoticeBoard.service;


import java.util.List;
import java.util.stream.Collectors;

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
	public List<NoticeMainResponseDto> findAll(){
		return noticeRepository.findAll()
				.stream()
				.map(NoticeMainResponseDto::new)
				.collect(Collectors.toList());
	}
}
