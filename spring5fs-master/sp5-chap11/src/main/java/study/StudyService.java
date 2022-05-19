package study;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudyService {
	
	@Autowired
	StudyDao studydao;
	
	public String regist(StudyForm studyForm) throws Exception {
		if (studyForm.getPassword().equals(studyForm.getConfirmpassword())) {
			studyForm.setRegdate(LocalDateTime.now().toString());
			studydao.insert(studyForm);
		} else {
			throw new Exception("password not equal");
		}
		
		return "ok";
	}
}
