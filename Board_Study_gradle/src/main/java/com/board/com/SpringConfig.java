package com.board.com;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.board.com.aop.TimeTraceAop;
import com.board.com.repository.JdbcTemplateMemberRepository;
import com.board.com.repository.JpaMemberRepository;
import com.board.com.repository.MemberRepository;
import com.board.com.service.MemberService;

@Configuration
public class SpringConfig {
	
	private final MemberRepository memberRepository;
	
	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
		
	}
	

//	@Bean
//	public MemberRepository memberRepository() {
//		return new MemoryMemberRepository();
//		return new JdbcMemberRepository(dataSource);
//		return new JdbcTemplateMemberRepository(dataSource);
//		return new JpaMemberRepository(em);
		
//	}
}
