package webadv.s16204215.demo.beans;

import java.util.Date;

public class Fee {
	private int owner_id;
	private int water_fee;
	private int elec_fee;
	private int service_fee;
	private int parking_fee;
	private int fix_fee;
	private int total_fee;
	private int status;
	private Date time;
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public int getWater_fee() {
		return water_fee;
	}
	public void setWater_fee(int water_fee) {
		this.water_fee = water_fee;
	}
	public int getElec_fee() {
		return elec_fee;
	}
	public void setElec_fee(int elec_fee) {
		this.elec_fee = elec_fee;
	}
	public int getService_fee() {
		return service_fee;
	}
	public void setService_fee(int service_fee) {
		this.service_fee = service_fee;
	}
	public int getParking_fee() {
		return parking_fee;
	}
	public void setParking_fee(int parking_fee) {
		this.parking_fee = parking_fee;
	}
	public int getFix_fee() {
		return fix_fee;
	}
	public void setFix_fee(int fix_fee) {
		this.fix_fee = fix_fee;
	}
	public int getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getDatetime() {
		return time;
	}
	public void setDatetime(Date time) {
		this.time = time;
	}
	

}
