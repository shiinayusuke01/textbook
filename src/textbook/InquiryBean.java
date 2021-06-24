package textbook;

public class InquiryBean {
	private int id;
	private String content;
	private int userId;
	private String user;
	private String email;
	InquiryBean(int id, String content, int userId, String user, String email){
		this.id = id;
		this.content = content;
		this.userId = userId;
		this.user = user;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
