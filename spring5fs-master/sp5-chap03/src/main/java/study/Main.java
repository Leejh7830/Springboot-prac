package study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
/*		
		// 1. 어노테이션방식 (spring5)
		// 객체담는 통(ACAC)
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(MyConf.class);
		
		// adao를 insert, insert 두번..
		AService aservice = acac.getBean(AService.class);
		aservice.reg(new A("a11","b11"));
		aservice.reg(new A("a22","b22"));
		
		// adao를 select..
		aservice.select();
		
		acac.close();
*/		
		// 2. XML(spring3)
		// 2-1. 생성자     2-2.     
		GenericXmlApplicationContext gxac = new GenericXmlApplicationContext("study/MyConf.xml");
		
		ADao adao1 = gxac.getBean(ADao.class);
		ADao adao2 = gxac.getBean(ADao.class);
		System.out.println(adao1);
		System.out.println(adao2);
		
		AService aservice = gxac.getBean(AService.class);
		System.out.println(aservice);
		
		aservice.reg(new A("a11","b11"));
		aservice.reg(new A("a22","b22"));
		aservice.reg(new A("a33","b33"));
		aservice.select();
		
		gxac.close();
	}
}
