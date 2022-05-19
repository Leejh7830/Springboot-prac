package studybean;

import org.springframework.stereotype.Component;

import studynobean.NoBean;

@Component
@NoBean
public class AService {
	
//	@NoBean
//	private int a = 10;
//	
//	@NoBean
//	public void doA() {
//		System.out.println("어노테이션 사용문법");
//	}
	
	public void doservice() {
		System.out.println("NoBean aservice");
	}
	
}
