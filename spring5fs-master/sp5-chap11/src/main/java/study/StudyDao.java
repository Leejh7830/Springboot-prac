package study;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudyDao {
	
	@Autowired
	SqlSessionTemplate sql;
	
	public boolean insert(StudyForm studyForm) {
		sql.insert("cumember.insert",studyForm);
		return true;
	}
}
