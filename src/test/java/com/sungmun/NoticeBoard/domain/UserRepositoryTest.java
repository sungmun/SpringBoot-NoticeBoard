package com.sungmun.NoticeBoard.domain;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sungmun.NoticeBoard.domain.user.User;
import com.sungmun.NoticeBoard.domain.user.UserRepository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	@After
	public void cleanup() {
		userRepository.deleteAll();
	}
	
	@Test
	public void 유저추가하기() {
		User user=User.builder()
				.id("tjdans174")
				.password("dkrak174")
				.firstName("kang")
				.secondName("seungmun")
				.phone("01041606443")
				.email("tjdans174@naver.com")
				.build();
		userRepository.save(user);
		
		List<User> list=userRepository.findAll();
		
		user=list.get(0);
		assertThat(user.getId(), is("tjdans174"));
		assertThat(user.getPassword(), is("dkrak174"));
	}
}
