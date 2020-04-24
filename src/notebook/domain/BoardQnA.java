package notebook.domain;

public class BoardQnA {
	private int qnaNo;
	private String userId;
	private String subject;
	private String content;
	private String createDate;
	private String password;
	private int viewCnt;
	private int answerState;
	private Product product;
	public BoardQnA() {
		super();
	}
	public BoardQnA(int qnaNo, String userId, String subject, String content, String createDate, String password,
			int viewCnt, int answerState, Product product) {
		super();
		this.qnaNo = qnaNo;
		this.userId = userId;
		this.subject = subject;
		this.content = content;
		this.createDate = createDate;
		this.password = password;
		this.viewCnt = viewCnt;
		this.answerState = answerState;
		this.product = product;
	}
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public int getAnswerState() {
		return answerState;
	}
	public void setAnswerState(int answerState) {
		this.answerState = answerState;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
