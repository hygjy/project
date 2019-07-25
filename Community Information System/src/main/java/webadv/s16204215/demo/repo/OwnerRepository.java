package webadv.s16204215.demo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import webadv.s16204215.demo.beans.Announcement;
import webadv.s16204215.demo.beans.FeeForm;
import webadv.s16204215.demo.beans.FeeNotify;
import webadv.s16204215.demo.beans.Owner;

/**
 * @author jm
 * @category owner
 */
@Repository
public class OwnerRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 根据业主ID查询业主信息
	 */
	public Owner findOwnerById(int id) {
		String sql = "select owner_id as id,password as password,name as name,sex as sex,age as age,phone as phone from t_owner where owner_id=?";
		RowMapper<Owner> rowMapper = new BeanPropertyRowMapper<Owner>(Owner.class);
		List<Owner> list = jdbcTemplate.query(sql, rowMapper, id);
		return list.get(0);
	}

	/**
	 * 根据业主ID修改业主信息
	 */
	public int modifyOwnerById(Owner owner) {
		String sql = "update 625team.t_owner set password=?,name=?,sex=?,age=?,phone=? where owner_id=?";
		int rows = jdbcTemplate.update(sql, owner.getPassword(), owner.getName(), owner.getSex(), owner.getAge(),
				owner.getPhone(), owner.getId());
		return rows;
	}

	/**
	 * 根据业主ID查询费用通知信息
	 */
	public List<FeeNotify> findFeeNotifyById(int id) {
		String sql = "select notify_id as notify_id,owner_id as owner_id,title as title,content as content,time as time from t_fee_notify where owner_id=? order by time desc limit 5";
		RowMapper<FeeNotify> rowMapper = new BeanPropertyRowMapper<FeeNotify>(FeeNotify.class);
		List<FeeNotify> list = jdbcTemplate.query(sql, rowMapper, id);
		if (list != null && list.size() > 0)
			return list;
		else
			return null;
	}

	/**
	 * 根据业主ID查询历史账单信息
	 */
	public List<FeeForm> findFeeFormById(int id) {
		String sql = "select fee_id as fee_id,owner_id as owner_id,water_fee as water_fee,elec_fee as elec_fee,service_fee as service_fee,parking_fee as parking_fee,fix_fee as fix_fee,total_fee as total_fee,status as status,time as time from t_fee_form where owner_id=? order by time desc limit 15";
		RowMapper<FeeForm> rowMapper = new BeanPropertyRowMapper<FeeForm>(FeeForm.class);
		List<FeeForm> list = jdbcTemplate.query(sql, rowMapper, id);
		if (list != null && list.size() > 0)
			return list;
		else
			return null;
	}

	/**
	 * 查询公告信息
	 */
	public List<Announcement> findAnnouncement() {
		String sql = "select announcement_id as announcement_id,name as name,title as title,content as content,time as time from t_announcement,t_manager where t_announcement.manager_id=t_manager.manager_id order by time desc limit 4";
		RowMapper<Announcement> rowMapper = new BeanPropertyRowMapper<Announcement>(Announcement.class);
		List<Announcement> list = jdbcTemplate.query(sql, rowMapper);
		if (list != null && list.size() > 0)
			return list;
		else
			return null;
	}
	
	/**
	 * 添加报修信息
	 */
	public int addFix(Owner owner) {
		String sql = "update 625team.t_owner set password=?,name=?,sex=?,age=?,phone=? where owner_id=?";
		int rows = jdbcTemplate.update(sql, owner.getPassword(), owner.getName(), owner.getSex(), owner.getAge(),
				owner.getPhone(), owner.getId());
		return rows;
	}
}
