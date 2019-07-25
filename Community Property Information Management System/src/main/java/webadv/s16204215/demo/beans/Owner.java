package webadv.s16204215.demo.beans;

/**
 * @author jm
 *
 */
public class Owner {
	private int id;
	private String password;
	private String name;
	private String sex;
	private int age;
	private String phone;
	public Owner() {
	}
	public Owner(int id, String password, String name, String sex, int age, String phone) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
