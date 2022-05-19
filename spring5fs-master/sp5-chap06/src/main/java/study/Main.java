package study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext 
			acac = new AnnotationConfigApplicationContext(MyConf.class);
		AA aa = acac.getBean(AA.class);
		aa.send();
		
		BB bb = acac.getBean(BB.class);
		bb.send();
		
		
		acac.close();
	}
}
// AA나 BB나 같은 방법임, 주로 B 방법 사용