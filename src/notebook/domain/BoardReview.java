package notebook.domain;

public class BoardReview {
	private int reviewNo;
	private String userId;
	private String imgName;
	private String createDate;
	private String content;
	private String serialNum;
	private int grade;
	
	
	public BoardReview(int reviewNo, String userId, String imgName, String createDate, String content, String serialNum,
			int grade) {
		super();
		this.reviewNo = reviewNo;
		this.userId = userId;
		this.imgName = imgName;
		this.createDate = createDate;
		this.content = content;
		this.serialNum = serialNum;
		this.grade = grade;
	}
	public BoardReview() {
		super();
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
