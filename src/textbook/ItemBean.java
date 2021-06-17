package textbook;

import java.io.Serializable;

public class ItemBean implements Serializable {
	private String title;
	private String author;
	private int price;
	private String status;
	private String quantity;

public ItemBean(String title, String author, int price,String status,String quantity) {
	this.title=title;
	this.author=author;
	this.price=price;
	this.status=status;
	this.quantity=quantity;
}
	public String gettitle() {
		return title;
	}
	public void title(String title) {
		this.title = title;
	}
	public String getauthor() {
		return author;
	}
	public void setautor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getstatus() {
		return status;
	}
	public void setstayuss(String status) {
		this.status = status;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}



}
