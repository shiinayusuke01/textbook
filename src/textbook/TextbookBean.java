package textbook;

import java.io.Serializable;

public class TextbookBean implements Serializable {
	private int id;
	private String title;
	private int category;
	private String author;
	private String status;
	private int price;
	private String info;
	private int userId;
	private int stock;
	private int buyer;
	private String categoryname;





	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public TextbookBean(String title, int category, String author, String status, int price, String info, int userId, String categoryname) {
		super();
		this.title = title;
		this.category = category;
		this.author = author;
		this.status = status;
		this.price = price;
		this.info = info;
		this.userId = userId;
		this.categoryname = categoryname;
	}

	public TextbookBean(int id, String title, int category, String author, String status, int price, String info,
			int userId, String categoryname) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.author = author;
		this.status = status;
		this.price = price;
		this.info = info;
		this.userId = userId;
		this.categoryname = categoryname;
	}

	public TextbookBean(int id, String title, int category, String author, String status, int price, String info,
			int userId, int stock, String categoryname) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.author = author;
		this.status = status;
		this.price = price;
		this.info = info;
		this.userId = userId;
		this.stock = stock;
		this.categoryname = categoryname;
	}

	public TextbookBean(int id, String title, String author, String status, int price, String info, int userId,
			String categoryname) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.status = status;
		this.price = price;
		this.info = info;
		this.userId = userId;
		this.categoryname = categoryname;
	}

	public TextbookBean(int id, String title, int category, String author, String status, int price, String info,
			int userId, int stock, int buyer, String categoryname) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.author = author;
		this.status = status;
		this.price = price;
		this.info = info;
		this.userId = userId;
		this.stock = stock;
		this.buyer = buyer;
		this.categoryname = categoryname;
	}

	public TextbookBean(int id, String title, int category, String author, String status, int price, String info,
			int userId, int stock, int buyer) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.author = author;
		this.status = status;
		this.price = price;
		this.info = info;
		this.userId = userId;
		this.stock = stock;
		this.buyer = buyer;
	}

	public TextbookBean(int id, String title, int category, String author, String status, int price, String info,
			int userId, int stock) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.author = author;
		this.status = status;
		this.price = price;
		this.info = info;
		this.userId = userId;
		this.stock = stock;
	}

	public TextbookBean(int id, String title, String author, int category, String status, int price,  String info, int userId) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.status = status;
		this.price = price;
		this.info = info;
		this.userId = userId;
	}

	public TextbookBean(String title, String author, int category, String status, int price, String info) {
		super();
		this.title = title;
		this.category = category;
		this.author = author;
		this.status = status;
		this.price = price;
		this.info = info;
	}



	public TextbookBean(String title, String author, int category, String status, int price, String info, int userId) {
		super();
		this.title = title;
		this.category = category;
		this.author = author;
		this.status = status;
		this.price = price;
		this.info = info;
		this.userId = userId;
	}


	public TextbookBean(String title, String author, String status, String info) {
		super();
		this.title = title;
		this.author = author;
		this.status = status;
		this.info = info;
	}

	public TextbookBean() {
		super();
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


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserId(String userId) {
		// TODO ?????????????????????????????????????????????

	}



	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getBuyer() {
		return buyer;
	}

	public void setBuyer(int buyer) {
		this.buyer = buyer;
	}

	public String replaceAll(String a, String b) {
		a = b;
		return a;
	}
}
