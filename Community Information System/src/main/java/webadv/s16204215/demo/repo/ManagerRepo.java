package webadv.s16204215.demo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import webadv.s16204215.demo.beans.CarParking;
import webadv.s16204215.demo.beans.Fee;
import webadv.s16204215.demo.beans.FeeNotify;
import webadv.s16204215.demo.beans.HouseProperty;
import webadv.s16204215.demo.beans.Manager;
import webadv.s16204215.demo.beans.Owner;
import webadv.s16204215.demo.beans.Parking;
import webadv.s16204215.demo.beans.PublicProperty;
import webadv.s16204215.demo.beans.announcement_message;
import webadv.s16204215.demo.tools.TimeConverTools;

/**
 * @author Michael 管理员中与数据库接触所做的功能
 */
@Repository
public class ManagerRepo {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<announcement_message> list_annoucement() {
		String sql = "select title as title,content  as content ,time as time ,announcement_id as announcement_id from  625team.t_announcement ";
		RowMapper<announcement_message> rowMapper = new BeanPropertyRowMapper<announcement_message>(
				announcement_message.class);
		List<announcement_message> list = jdbcTemplate.query(sql, rowMapper);
		if (list != null && list.size() > 0) {
			return list;
		} else
			return null;
	}

	public int addAnnouncement(announcement_message announcement,int id) {
		String sql = "insert into 625team.t_announcement(manager_id,title,content,time) values(?,?,?,?)";
		int rows = jdbcTemplate.update(sql, id,announcement.getTitle(), announcement.getContent(), TimeConverTools.getCurTime());
		return rows;

	}

	/*
	 * 1.1显示所有业主信息
	 * 
	 */
	public List<Owner> listOwner() {
		String sql = "select owner_id as id,name  as name ,sex as sex,age  as age ,phone  as phone  from 625team.t_owner order by owner_id desc";
		RowMapper<Owner> rowMapper = new BeanPropertyRowMapper<Owner>(Owner.class);
		List<Owner> list = jdbcTemplate.query(sql, rowMapper);
		if (list != null && list.size() > 0) {
			return list;
		} else
			return null;
	}

	/*
	 * 1.2添加新的业主信息
	 * 
	 */
	public int addOwner(Owner owner) {
		String sql = "insert into 625team.t_Owner(password,name,age,sex,phone) values(?,?,?,?,?)";
		int rows = jdbcTemplate.update(sql, 123, owner.getName(), 20, owner.getSex(), owner.getPhone());
		return rows;

	}

	/*
	 * 2.1显示所有公共设施信息
	 * 
	 */
	public List<PublicProperty> listPublicProperty() {
		String sql = "select property_id as id,property_name as name,property_price as price,"
				+ " number as number,location as location ,description as descrption from 625team.t_public_property order by property_id desc";
		RowMapper<PublicProperty> rowMapper = new BeanPropertyRowMapper<PublicProperty>(PublicProperty.class);
		List<PublicProperty> list = jdbcTemplate.query(sql, rowMapper);
		if (list != null && list.size() > 0) {
			return list;
		} else
			return null;

	}

	/*
	 * 2.2添加新的公共设施信息
	 * 
	 */
	public int addPublicProperty(PublicProperty property) {
		String sql = "insert into 625team.t_public_property(property_name,property_price,number,location,description) values(?,?,?,?,?)";
		int rows = jdbcTemplate.update(sql, property.getName(), property.getPrice(), property.getNumber(),
				property.getLocation(), property.getDescrption());
		return rows;

	}

	/*
	 * 3.1显示所有待审核车位信息
	 * 
	 */

	public List<CarParking> listCarParking() {
		String sql = "select parking_id as id,status as status,location  as location ,"
				+ " name as owner_name,price as price,buy_time as buy_time from 625team.t_car_property c,625team.t_owner o where o.owner_id=c.owner_id order by parking_id desc";
		RowMapper<CarParking> rowMapper = new BeanPropertyRowMapper<CarParking>(CarParking.class);
		List<CarParking> list = jdbcTemplate.query(sql, rowMapper);
		if (list != null && list.size() > 0) {
			return list;
		} else
			return null;
	}

	/*
	 * 3.2添加新的车位信息
	 * 
	 */
	public int addCarParking(CarParking carParking) {

		String sql = "insert into 625team.t_car_property(location,price) values(?,?)";
		int rows = jdbcTemplate.update(sql, carParking.getLocation(), carParking.getPrice());
		return rows;

	}

	/*
	 * 3.3处理业主申请车位请求
	 * 
	 */
	public int handleAudting(int id) {
		String sql = "update 625team.t_car_property set status=0 where parking_id=?";
		int rows = jdbcTemplate.update(sql, id);
		return rows;

	}

	/*
	 * 3.4显示所有车位信息
	 * 
	 */
	public List<Parking> listParking() {
		String sql = "select parking_id as id,status as status,location  as location ,"
				+ " price as price from 625team.t_car_property c order by parking_id desc";
		RowMapper<Parking> rowMapper = new BeanPropertyRowMapper<Parking>(Parking.class);
		List<Parking> list = jdbcTemplate.query(sql, rowMapper);
		if (list != null && list.size() > 0) {
			return list;
		} else
			return null;
	}

	/*
	 * 4.1显示所有房产信息
	 * 
	 */
	public List<HouseProperty> listHouseProperty() {
		String sql = "select house_id as hourse_id,o.name  as owner_name ,address as address,type as type,price as price ,buy_time as buy_time "
				+ "from 625team.t_house_property h,625team.t_owner o where h.owner_id=o.owner_id order by house_id desc";
		RowMapper<HouseProperty> rowMapper = new BeanPropertyRowMapper<HouseProperty>(HouseProperty.class);
		List<HouseProperty> list = jdbcTemplate.query(sql, rowMapper);
		if (list != null && list.size() > 0) {
			return list;
		} else
			return null;

	}

	/*
	 * 4.2添加新的房产信息
	 * 
	 */
	public int addHouseProperty(HouseProperty houseProperty) {
		String sql = "insert into 625team.t_house_Property(owner_id,address,type,price,buy_time) values(?,?,?,?,?)";

		int rows = jdbcTemplate.update(sql, houseProperty.getOwner_id(), houseProperty.getAddress(),
				houseProperty.getType(), houseProperty.getPrice(), TimeConverTools.getCurTime());
		return rows;

	}

	/*
	 * 5.1显示所有费用信息
	 * 
	 */
	public List<Fee> listFee() {
		String sql = "select * from 625team.t_fee_form order by fee_id desc";
		RowMapper<Fee> rowMapper = new BeanPropertyRowMapper<Fee>(Fee.class);
		List<Fee> list = jdbcTemplate.query(sql, rowMapper);
		if (list != null && list.size() > 0) {
			return list;
		} else
			return null;
	}

	/*
	 * 5.2添加新的费用信息
	 * 
	 */
	public int addFee(Fee fee) {

		String sql = "insert into 625team.t_fee_form(owner_id,water_fee,elec_fee,service_fee,parking_fee,fix_fee,total_fee,status) values(?,?,?,?,?,?,?,?)";
		int total = fee.getWater_fee() + fee.getElec_fee() + fee.getService_fee() + fee.getFix_fee()
				+ fee.getParking_fee();
		int rows = jdbcTemplate.update(sql, fee.getOwner_id(), fee.getWater_fee(), fee.getElec_fee(),
				fee.getService_fee(), fee.getParking_fee(), fee.getFix_fee(), total, 0);

		return rows;

	}

	/*
	 * 6.1显示所有催缴费用信息
	 * 
	 */
	public List<FeeNotify> listFeeNotify() {
		String sql = "select * from 625team.t_fee_notify order by owner_id desc";
		RowMapper<FeeNotify> rowMapper = new BeanPropertyRowMapper<FeeNotify>(FeeNotify.class);
		List<FeeNotify> list = jdbcTemplate.query(sql, rowMapper);
		if (list != null && list.size() > 0) {
			return list;
		} else
			return null;
	}

	/*
	 * 5.2添加新的催缴费用信息
	 * 
	 */
	public int addFeeNotify(FeeNotify feeNotify) {

		String sql = "insert into 625team.t_fee_notify(owner_id,title,content,time) values(?,?,?,?)";
		int rows = jdbcTemplate.update(sql, feeNotify.getOwner_id(), feeNotify.getTitle(), feeNotify.getContent(),
				TimeConverTools.getMultiCurTime());

		return rows;

	}

	/*
	 * 6.1审核业主
	 * 
	 */
	public Owner checkOwner(String account, String password) {
		try {
			String sql = "select owner_id as id name as name,sex as sex,age as age,phone as phone from 625team.t_owner where owner_id=? and password=?";
			RowMapper<Owner> rowMapper = new BeanPropertyRowMapper<Owner>(Owner.class);

			Owner owner = jdbcTemplate.queryForObject(sql, rowMapper, account, password);
			if (owner != null)
				return owner;
			else
				return null;

		} catch (DataAccessException e) {
			return null;
		}
	}

	/*
	 * 6.2审核管理员
	 * 
	 */
	public Manager checkManager(String account, String password) {
		try {
			String sql = "select manager_id as manager_id name as name,sex as sex,age as age,phone as phone from 625team.t_manager where manager_id=? and password=?";
			RowMapper<Manager> rowMapper = new BeanPropertyRowMapper<Manager>(Manager.class);
			Manager manager = jdbcTemplate.queryForObject(sql, rowMapper, account, password);
			if (manager != null)
				return manager;
			else
				return null;
		} catch (DataAccessException e) {
			return null;
		}

	}

}
