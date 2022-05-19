package board;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("board")
public class BoardController {

	@Autowired
	SqlSessionTemplate sql;
	
	@GetMapping("insert")
//	@ResponseBody	// @RestController
	public String insert(Model model) {
//		sql.insert("board.insert");
		model.addAttribute("board", new Board());
		return "board/insert";
	}
	
	@GetMapping("view")
	public String view(Model model, @RequestParam int id) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("id",id);
		
		Board board = sql.selectOne("board.selectone",map);
		
		map.put("fk_id", id);
		List<BoardTail> boardtaillist = sql.selectList("boardtail.selectall",map);
		model.addAttribute("boardtaillist", boardtaillist);
		model.addAttribute("board", board);
		return "board/view";
	}
	
	@PostMapping("insert")
	public String insert(@ModelAttribute Board board) {
		board.setWdate(LocalDateTime.now().toString());
		sql.insert("board.insert",board);
		return "redirect:selectall";
	}

	@GetMapping("home")
	public String home(Model model) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("row", 0);
		map.put("rowcount", 3);
		List<Board> list = sql.selectList("board.selectall", map);
		model.addAttribute("list", list);
		return "board/home";
	}
	
	@GetMapping("selectall")
	public String selectall(Model model,
			@RequestParam(required=false,defaultValue = "1") int pagenum) {
		System.out.println("pageNum:"+pagenum);
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int pagecnt = sql.selectOne("pagecnt");
		int row = 0;
		if(pagenum > 1) {
			row = (pagenum-1) * 10;
		}
		
		map.put("row", row);
		map.put("rowcount", 10);
		List<Board> list = sql.selectList("board.selectall", map);
		model.addAttribute("list", list);
		model.addAttribute("pagecnt", pagecnt);
		return "board/selectall";
	}
}
