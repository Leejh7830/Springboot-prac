package study;

import java.util.Collection;

public class AService {

	private ADao adao;
	
	public ADao getAdao() {
		return adao;
	}

	public void setAdao(ADao adao) {
		this.adao = adao;
	}

	public AService() {}
	
	public AService(ADao adao) {
		this.adao = adao;
	}
	
	public void reg(A a) {
		adao.insert(a);
	}
	
	public void select() {
		Collection<A> collection = adao.select();
		collection.forEach((a)->{
			System.out.println("a = "+a);
		});
	}
	
	

}
