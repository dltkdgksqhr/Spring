package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.Member;
import spring.MemberDao;

public class MainForMemberDao {
	
	private static MemberDao memberDao;

	public static void main(String[] args) {
	AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
	
	memberDao = ctx.getBean("memberDao", MemberDao.class);
	
	selectAll();
	updateMember();
	insertMember();
	
	ctx.close();
	}
	
	private static void selectAll() {
		System.out.println("----selectAll");
		int total = memberDao.count();
		System.out.println("전체 데이터 " + total);
		List<Member> members = memberDao.selectAll();
		for(Member m : members) {
			System.out.println(m.getId() + ":" + m.getEmail() + ":" + m.getName());
			
		}
	}
	
	private static void updateMember() {
		System.out.println("----updateMember");
		Member member = memberDao.selectByEmail("madvirus@naver.com");  // Email이 칼럼 값이 "madvirus@naver.com인 Member 객체를 구한다.
		String oldPw = member.getPassword();
		String newPw = Double.toHexString(Math.random());
		member.changePassword(oldPw, newPw);  //임의의 새로운 암호를 생성한다.
		
		memberDao.update(member);  //변경 내역을 DB에 반영한다.
		System.out.println("암호 변경: " + oldPw + ">" + newPw);
	}
	
	private static void insertMember() {
		System.out.println("---- insertMember");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
		String prefix = dateFormat.format(new Date());
		Member member = new Member(prefix + "@test.com", prefix, prefix, new Date());
		memberDao.insert(member);
		System.out.println(member.getId() + "데이터 추가");
	}
	

}
