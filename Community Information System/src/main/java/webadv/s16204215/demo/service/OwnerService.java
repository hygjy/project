package webadv.s16204215.demo.service;

import java.util.List;

import webadv.s16204215.demo.beans.Announcement;
import webadv.s16204215.demo.beans.FeeForm;
import webadv.s16204215.demo.beans.FeeNotify;
import webadv.s16204215.demo.beans.Owner;

/**
 * @author jm
 * @category owner 
 */
public interface OwnerService {
	public Owner findOwnerById(int id);
	public int modifyOwnerById(Owner owner);
	public List<FeeNotify> findFeeNotifyById(int id);
	public List<FeeForm> findFeeFormById(int id);
	public List<Announcement> findAnnouncement();
}
