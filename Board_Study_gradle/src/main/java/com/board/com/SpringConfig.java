package com.board.com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.board.com.repository.MemberRepository;
import com.board.com.repository.MemoryMemberRepository;
import com.board.com.service.MemberService;

@Configuration
public class SpringConfig {
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
		
	}

	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
		
	}
}
