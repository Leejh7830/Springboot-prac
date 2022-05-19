package study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import studybean.A;
import studybean.AA;
import studybean.ADao;
import studybean.AService;

public class Main { // spring5 132p

	public static void main(String[] args) {
		AnnotationConfigApplicationContext
		acac = new AnnotationConfigApplicationContext(MyConf.class);
		
		AA aa = acac.getBean(AA.class);
		aa.doAA();
		
		A a = acac.getBean(A.class);
		a.doA();

		ADao adao = acac.getBean(ADao.class);
		adao.doInsert();
		
		AService aservice = acac.getBean(AService.class);
		aservice.doservice();
		
		acac.close();
	}
}
