package study;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class AA implements InitializingBean,DisposableBean{
	public void send() {
		System.out.println("AA send");
	}

	@Override // InitializingBean 객체 담을 때
	public void afterPropertiesSet() throws Exception {
		System.out.println("AA 처음 만들 때 호출");
	}

	@Override // DisposableBean 객체 뺄 때
	public void destroy() throws Exception {
		System.out.println("AA 뺄 때 호출");
	}
}
