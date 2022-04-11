package spring;

public class MemberPrinter {
	public void print(Member member) {
<<<<<<< HEAD
		System.out.printf(
				"회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
				member.getId(), member.getEmail(),
				member.getName(), member.getRegisterDate());
=======
		System.out.printf("회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n", 
		                 member.getId(),member.getEmail(), member.getName(), member.getRegisterDate());
>>>>>>> branch 'master' of http://github.com/dltkdgksqhr/spring.git
	}
}
