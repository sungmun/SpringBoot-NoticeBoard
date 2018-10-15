package com.sungmun.NoticeBoard.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sungmun.NoticeBoard.domain.member.MemberRepository;
import com.sungmun.NoticeBoard.dto.member.MemberSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MemberService implements UserDetailsService {
	private MemberRepository repository;
	
	public String save(MemberSaveRequestDto dto) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		return repository.save(dto.toEntity()).getId();
	}

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
	}
}
