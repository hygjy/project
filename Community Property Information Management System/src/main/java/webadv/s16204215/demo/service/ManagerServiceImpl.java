package webadv.s16204215.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webadv.s16204215.demo.beans.CarParking;
import webadv.s16204215.demo.beans.Fee;
import webadv.s16204215.demo.beans.FeeNotify;
import webadv.s16204215.demo.beans.HouseProperty;
import webadv.s16204215.demo.beans.Manager;
import webadv.s16204215.demo.beans.Owner;
import webadv.s16204215.demo.beans.Parking;
import webadv.s16204215.demo.beans.PublicProperty;
import webadv.s16204215.demo.beans.announcement_message;
import webadv.s16204215.demo.repo.ManagerRepo;

/**
 * @author Michael 管理员功能服务层的实现类
 */

@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	private ManagerRepo mr;

	public List<announcement_message> list_annAnnouncement_messages() {
		// TODO Auto-generated method stub
		return mr.list_annoucement();
	}

	@Override
	public int addAnnoucement(announcement_message announcement,int id) {
		// TODO Auto-generated method stub
		return mr.addAnnouncement(announcement,id);
	}

	@Override
	public List<Owner> listOwner() {

		return mr.listOwner();
	}

	@Override
	public int addOwner(Owner owner) {

		return mr.addOwner(owner);
	}

	@Override
	public List<PublicProperty> listPublicProperty() {

		return mr.listPublicProperty();
	}

	@Override
	public int addPublicProperty(PublicProperty property) {

		return mr.addPublicProperty(property);
	}

	@Override
	public List<CarParking> listCarParking() {

		return mr.listCarParking();
	}

	@Override
	public int addCarParking(CarParking carParking) {

		return mr.addCarParking(carParking);
	}

	@Override
	public int handleAudting(int id) {

		return mr.handleAudting(id);
	}

	@Override
	public List<HouseProperty> listHouseProperty() {

		return mr.listHouseProperty();
	}

	@Override
	public int addHouseProperty(HouseProperty hsouseProperty) {

		return mr.addHouseProperty(hsouseProperty);
	}

	@Override
	public List<Fee> listFee() {
		// TODO Auto-generated method stub
		return mr.listFee();
	}

	@Override
	public int addFee(Fee fee) {
		// TODO Auto-generated method stub
		return mr.addFee(fee);
	}

	@Override
	public List<Parking> listParking() {
		// TODO Auto-generated method stub
		return mr.listParking();
	}

	@Override
	public List<FeeNotify> listFeeNotify() {
		// TODO Auto-generated method stub
		return mr.listFeeNotify();
	}

	@Override
	public int addFeeNotify(FeeNotify feeNotify) {
		// TODO Auto-generated method stub
		return mr.addFeeNotify(feeNotify);
	}

	public Owner checkOwner(String account, String password) {

		return mr.checkOwner(account, password);
	}

	public Manager checkManager(String account, String password) {
		return mr.checkManager(account, password);
	}
}
