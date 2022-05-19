package board;

public class Board {

	private int id;
	private String title;
	private String content;
	private String wdate;
	
	public Board() {}
	public Board(int id, String title, String content, String wdate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
	}
	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", content=" + content + ", wdate=" + wdate + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	
	
}
