package study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("study")
public class StudyController {
	
	@Autowired
	StudyService studyService;

	@GetMapping("step1")
	public String step1() {
		return "study/step1";
	}
	
	@PostMapping("step2")
	public String step2( @RequestParam(name = "agree", defaultValue = "false") boolean agree,
			Model model) {
		System.out.println("agree : "+agree);
		if(agree) {
			StudyForm sf = new StudyForm();
			sf.setName("nameanem");
			sf.setEmail("emailasdfasdf");
			sf.setPassword("password");
			model.addAttribute("studyForm",sf);
			return "study/step2";
		}
		else
			return "study/step1";
	}
	
	@PostMapping("step3")
	public String step3(StudyForm studyForm,Model model) {
		try {
			studyService.regist(studyForm);// 등록해달라
		} catch (Exception e) {
			System.out.println(e.toString());
			model.addAttribute("error", "password");
			return "study/step2";
		}
		return "study/step3";
	}
}









