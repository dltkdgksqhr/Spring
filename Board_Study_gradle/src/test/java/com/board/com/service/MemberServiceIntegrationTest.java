package com.board.com.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.board.com.domain.Member;
import com.board.com.repository.MemberRepository;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {
	//테스트는 한글로 사용가능
	// 테스트의 한해서 필드에 바로 자동주입해도 됨.
	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;

	@Test
	public void 회원가입() {
		//given 뭔가가 주어졌을 때
		Member member = new Member();
		member.setName("spring");
		
		//when 이것을 실행했을 때
		Long saveId = memberService.join(member);
		
		
		//then 결과가 나온다.
		Member findMember = memberService.findOne(saveId).get();
		Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
	}
	
	@Test
	public void 중복_회원_예외() {
		//given
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		//when
		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
	/*
		try {
			memberService.join(member2);
			fail();
		}catch(IllegalStateException e) {
			Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		}
		*/
		
		//then
	}

	
}
