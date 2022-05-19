package chap10;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("member")
// @Controller는 jsp파일을 return
// @RestController 는 문자열을 return
public class MemberController {
	
	@Autowired
	SqlSessionTemplate sst;
	
	@GetMapping("select")
	public String select() {
		List<Member> list = sst.selectList("member.select");
		return list.toString();
	}
	
	@GetMapping("insert")
	public String insert(Member member) {
//		Member member = new Member();
//		member.setUsername("myname");
//		member.setPassword("mypass");
		sst.insert("member.insert",member);
		return "insert";
	}
	
	@GetMapping("update")
	public String update() {
		Member member = new Member();
		member.setUsername("myname");
		member.setPassword("mypass");
		member.setId(23);
		sst.update("member.update",member);
		return "update";
	}
	
	@GetMapping("delete")
	public String delete(int id) {
		sst.delete("member.delete",id);
		return "delete";
	}
	
}
