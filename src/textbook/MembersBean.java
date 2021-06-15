package textbook;

import java.io.Serializable;

public class MembersBean implements Serializable {
	private int id;
	private String family_name;
	private String first_name;
	private String postal;
	private String address;
	private String tel;
	private String email;
	private String birthday;
	private String password;
	private String year;
	private String month;
	private String day;




	public String birthday(String year, String month, String day) {
		this.year = year;
		this.month = month;
		this.day = day;
		return year + month + day;
	}

	public MembersBean(int id, String family_name, String first_name, String postal, String address, String tel,
			String email, String birthday, String password) {
		super();
		this.id = id;
		this.family_name = family_name;
		this.first_name = first_name;
		this.postal = postal;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.birthday = birthday;
		this.password = password;
	}
	public MembersBean(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public MembersBean() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFamily_name() {
		return family_name;
	}
	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
