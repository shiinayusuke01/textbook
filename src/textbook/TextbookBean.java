package textbook;

import java.io.Serializable;

public class TextbookBean implements Serializable {
	private String title;
	private String autor;
	private String category;
	private String price;
	private String status;
	private String info;

	public TextbookBean(String title, String author, String category, String price, String status, String info) {
		this.title = title;
		this.title = author;
		this.category = category;
		this.price = price;
		this.status = status;
		this.info = info;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}}
