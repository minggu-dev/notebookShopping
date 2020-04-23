package notebook.domain;

public class BoardAnswer {
	private int ansNo;
	private String content;
	private String createDate;
	
	public BoardAnswer(int ansNo, String content, String createDate) {
		super();
		this.ansNo = ansNo;
		this.content = content;
		this.createDate = createDate;
	}

	public int getAnsNo() {
		return ansNo;
	}

	public void setAnsNo(int ansNo) {
		this.ansNo = ansNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	

}
