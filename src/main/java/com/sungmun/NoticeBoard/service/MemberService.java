package com.sungmun.NoticeBoard.service;

import org.springframework.stereotype.Service;

import com.sungmun.NoticeBoard.domain.member.MemberRepository;
import com.sungmun.NoticeBoard.dto.member.MemberSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MemberService {
	private MemberRepository repository;
	
	public String save(MemberSaveRequestDto dto) {
		return repository.save(dto.toEntity()).getId();
	}
}
