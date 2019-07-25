package webadv.s16204215.demo.beans;

public class HouseProperty {
	private int hourse_id;
	private String owner_name;
	private int owner_id;
	private String address;
	private String type;
	private String price;
	private String buy_time;
	
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getHourse_id() {
		return hourse_id;
	}
	public void setHourse_id(int hourse_id) {
		this.hourse_id = hourse_id;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBuy_time() {
		return buy_time;
	}
	public void setBuy_time(String buy_time) {
		this.buy_time = buy_time;
	}
	
}
