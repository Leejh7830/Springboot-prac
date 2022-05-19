package board;

import java.time.LocalDateTime;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("boardtail")
public class BoardTailController {
	
	@Autowired
	SqlSessionTemplate sql;
	
	@GetMapping("insert")
	public String insert(BoardTail boardtail) {
		System.out.println(boardtail);
		boardtail.setWdate(LocalDateTime.now().toString());
		sql.insert("boardtail.insert",boardtail);
		
		return "redirect:/board/view?id="+boardtail.getFk_id();
	}
}
