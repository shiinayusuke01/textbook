package textbook;

import java.io.Serializable;

public class TextbookBean implements Serializable {
	private String title;
<<<<<<< HEAD
	private String autor;
	private int category;
=======
	private String author;
	private String category;
	private String price;
>>>>>>> 3dc0214 (20210617)
	private String status;
	private int price;
	private String info;
	private int userId;

	public TextbookBean(String title, String author, int category, String status, int price,  String info, int userId) {
		this.title = title;
		this.autor = author;
		this.category = category;
		this.status = status;
		this.price = price;
		this.info = info;
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

<<<<<<< HEAD
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
//	@Override
//	public String toString(){
//		return new StringBuilder().append(thi)
//	}


}
=======
	public void setUserId(String userId) {
		// TODO 自動生成されたメソッド・スタブ

	}
	}
>>>>>>> 3dc0214 (20210617)
