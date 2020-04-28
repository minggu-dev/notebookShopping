package notebook.domain;

public class BoardAnswer {
	private int ansNo;
	private int qnaNo;
	private String content;
	private String createDate;
	

	public BoardAnswer(int ansNo, int qnaNo, String content, String createDate) {
		super();
		this.ansNo = ansNo;
		this.qnaNo = qnaNo;
		this.content = content;
		this.createDate = createDate;
	}

	public BoardAnswer() {
		super();
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

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	
	

}
