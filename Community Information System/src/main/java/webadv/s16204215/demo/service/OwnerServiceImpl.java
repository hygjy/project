package webadv.s16204215.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webadv.s16204215.demo.beans.Announcement;
import webadv.s16204215.demo.beans.FeeForm;
import webadv.s16204215.demo.beans.FeeNotify;
import webadv.s16204215.demo.beans.Owner;
import webadv.s16204215.demo.repo.OwnerRepository;

/**
 * @author jm
 * @category owner 
 */
@Service
public class OwnerServiceImpl implements OwnerService{
	@Autowired
	private OwnerRepository or;
	
	@Override
	public Owner findOwnerById(int id) {
		return or.findOwnerById(id);
	}
	
	@Override
	public int modifyOwnerById(Owner owner) {
		return or.modifyOwnerById(owner);
	}
	
	@Override
	public List<FeeNotify> findFeeNotifyById(int id){
		return or.findFeeNotifyById(id);
	}
	
	@Override
	public List<FeeForm> findFeeFormById(int id){
		return or.findFeeFormById(id);
	}
	
	@Override
	public List<Announcement> findAnnouncement(){
		return or.findAnnouncement();
	}
}
