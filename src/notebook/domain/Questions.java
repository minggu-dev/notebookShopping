package notebook.domain;

public class Questions {
	private int queNo; //질문번호
	private String question; //질문내용
	public Questions(int queNo, String question) {
		super();
		this.queNo = queNo;
		this.question = question;
	}
	public int getQueNo() {
		return queNo;
	}
	public void setQueNo(int queNo) {
		this.queNo = queNo;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
}
