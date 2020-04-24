package notebook.domain;

public class Users {
	private String userId;//	아이디
	private String pwd;//	비밀번호
	private String name;//	이름
	private String addr;//	주소
	private String phone;//	전화번호
	private String answer;//	답변내용
	private Questions question;//	질문
	private int state;//	상태값
	public Users() {
		super();
	}
	public Users(String userId, String pwd, String name, String addr, String phone, String answer, Questions question,
			int state) {
		super();
		this.userId = userId;
		this.pwd = pwd;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
		this.answer = answer;
		this.question = question;
		this.state = state;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Questions getQuestion() {
		return question;
	}
	public void setQuestion(Questions question) {
		this.question = question;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
