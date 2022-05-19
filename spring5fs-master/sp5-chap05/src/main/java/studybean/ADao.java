package studybean;

import org.springframework.stereotype.Component;

@Component
public class ADao {
	public void doInsert() {
		System.out.println("insert");
	}
}
