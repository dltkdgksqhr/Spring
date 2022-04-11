package spring;

import java.util.Collection;

public class MemberListPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;
<<<<<<< HEAD

	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}

	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		for (Member m : members) {
			printer.print(m);
		}
	}
=======
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
	 for(Member m : members) {
		 printer.print(m);
	 }
	}
	
>>>>>>> branch 'master' of http://github.com/dltkdgksqhr/spring.git
}
