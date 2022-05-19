package board;

public class BoardTail {
	private int id;
	private String name;
	private String tcontent;
	private String wdate;
	private int fk_id;
	
	public BoardTail() {}
	public BoardTail(int id, String name, String tcontent, String wdate, int fk_id) {
		super();
		this.id = id;
		this.name = name;
		this.tcontent = tcontent;
		this.wdate = wdate;
		this.fk_id = fk_id;
	}
	
	@Override
	public String toString() {
		return "BoardTail [id=" + id + ", name=" + name + ", tcontent=" + tcontent + ", wdate=" + wdate + ", fk_id="
				+ fk_id + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTcontent() {
		return tcontent;
	}
	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public int getFk_id() {
		return fk_id;
	}
	public void setFk_id(int fk_id) {
		this.fk_id = fk_id;
	}
	
	
}
