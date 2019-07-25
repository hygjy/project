package webadv.s16204215.demo.service;

import java.util.List;

import webadv.s16204215.demo.beans.CarParking;
import webadv.s16204215.demo.beans.Fee;
import webadv.s16204215.demo.beans.FeeNotify;
import webadv.s16204215.demo.beans.HouseProperty;
import webadv.s16204215.demo.beans.Manager;
import webadv.s16204215.demo.beans.Owner;
import webadv.s16204215.demo.beans.Parking;
import webadv.s16204215.demo.beans.PublicProperty;
import webadv.s16204215.demo.beans.announcement_message;

/**
 * @author Michael 管理员功能服务接口
 */
public interface ManagerService {
	public List<Owner> listOwner();

	public int addOwner(Owner owner);

	public List<PublicProperty> listPublicProperty();

	public int addPublicProperty(PublicProperty property);

	public List<CarParking> listCarParking();

	public int addCarParking(CarParking arParking);

	public List<Parking> listParking();

	public int handleAudting(int id);

	public List<HouseProperty> listHouseProperty();

	public int addHouseProperty(HouseProperty houseProperty);

	public List<Fee> listFee();

	public int addFee(Fee fee);

	public List<FeeNotify> listFeeNotify();

	public int addFeeNotify(FeeNotify feeNotify);

	// public User checkUser(User user);
	public Owner checkOwner(String account, String password);

	public Manager checkManager(String account, String password);

	public List<announcement_message> list_annAnnouncement_messages();

	public int addAnnoucement(announcement_message announcement,int id);
}
