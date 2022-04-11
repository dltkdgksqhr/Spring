package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigPart1;
import config.ConfigPart2;
import config.ConfigPartMain;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class MainTwoConfs2 {

	public static void main(String[] args) {
	 ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigPartMain.class);
	 
	 MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
	 MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter",MemberInfoPrinter.class);

	 RegisterRequest regReq = new RegisterRequest();
	 regReq.setEmail("madvirus@naver.com");
	 regReq.setName("최범균");
	 regReq.setPassword("1234");
	 regReq.setConfirmPassword("1234");
	 regSvc.regist(regReq);
	 
	 infoPrinter.printMemberInfo("madvirus@naver.com");
	}

}
