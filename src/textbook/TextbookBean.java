package textbook;

public class TextbookBean {
	private String title;
	private String category;
	private String price;
	private String grade;
	private String info;

	public TextbookBean(String title, String category, String price, String grade, String info) {
		this.title = title;
		this.category = category;
		this.price = price;
		this.grade = grade;
		this.info = info;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}


}
