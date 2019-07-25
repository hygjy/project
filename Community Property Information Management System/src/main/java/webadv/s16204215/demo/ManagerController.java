package webadv.s16204215.demo;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import webadv.s16204215.demo.beans.Announcement;
import webadv.s16204215.demo.beans.CarParking;
import webadv.s16204215.demo.beans.Fee;
import webadv.s16204215.demo.beans.FeeNotify;
import webadv.s16204215.demo.beans.HouseProperty;
import webadv.s16204215.demo.beans.Manager;
import webadv.s16204215.demo.beans.Owner;
import webadv.s16204215.demo.beans.Parking;
import webadv.s16204215.demo.beans.PublicProperty;
import webadv.s16204215.demo.beans.announcement_message;
import webadv.s16204215.demo.service.ManagerServiceImpl;

/**
 * @author Michael
 *管理员控制器
 */
@Controller
public class ManagerController {
	@Autowired
	private ManagerServiceImpl msi;

	

@GetMapping("/show_announcement.html")
	public String show_announcement(Model model) {
		// PublicPropertyRepo publicPropertyRepo=new PublicPropertyRepo();
		 List<announcement_message> list=msi.list_annAnnouncement_messages();	  
		 model.addAttribute("annoucement_list",list);
			 
		return "show_announcement";
	}
	
	@GetMapping("/announcement_add.html")
	public String announcemen_add(Model model) {
		announcement_message announcement = new announcement_message();
		model.addAttribute("announcement",announcement);
			 
		return "announcement_add";
	}
	
	@PostMapping("/announcement_add")
	public String announcement_add(Model model,@ModelAttribute(value="announcement") announcement_message announcement,HttpSession session) {
		Manager m=(Manager) session.getAttribute("user");
		int rows=msi.addAnnoucement(announcement,m.getManager_id());
		if(rows<=0) {
			String message="表单填写错误";
			model.addAttribute("message",message);
			return "announcement_add";
		}
		else 			
		return "announcement_add";
		
	}

	/*
	 * url:
	 * method:
	 * 输入：
	 * 输出：
	 * 返回页面：
	
	*/
	@GetMapping("/propertyOwnerManage.html")
	public String propertyOwnerManage(Model model) {
		List<Owner> list=msi.listOwner();
		model.addAttribute("ownerList", list);
		return "propertyOwnerManage";
	}

	
	@GetMapping("/addOwner.html")
	public String addOwner(Model model) {
		model.addAttribute("owner",new Owner());
		return "addOwner";
	}
	
	@PostMapping("/addOwner")
	public String addOwner(Model model,@ModelAttribute(value="owner") Owner owner) {
		int rows=msi.addOwner(owner);
		//int rows=0;
		if(rows<=0) {
			String message="表单填写错误";
			model.addAttribute("message",message);
			return "addOwner";
		}
		else {
			
		return "redirect:propertyOwnerManage.html";
		}
	}
	
	/*
	 * url:
	 * method:
	 * 输入：
	 * 输出：
	 * 返回页面：
	
	*/
	@GetMapping("/hoursePropertyManage.html")
	public String hoursePropertyManage(Model model) {
		List<HouseProperty> list=msi.listHouseProperty();
		model.addAttribute("housePropertyList", list);
		return "hoursePropertyManage";
	}
	

	@GetMapping("/addHouseProperty.html")
	public String addHouseProperty(Model model) {
		model.addAttribute("houseProperty",new HouseProperty());
		return "addHouseProperty";
	}
	/*
	 * url:
	 * method:
	 * 输入：
	 * 输出：
	 * 返回页面：
	
	*/
	@PostMapping("/addHouseProperty")
	public String addHouseProperty(Model model,@ModelAttribute(value="houseProperty") HouseProperty houseProperty) {
		int rows=msi.addHouseProperty(houseProperty);
		//int rows=0;
		if(rows<=0) {
			String message="表单填写错误";
			model.addAttribute("message",message);
			return "addHouseProperty";
		}
		else {
			
		return "redirect:hoursePropertyManage.html";
		}
	}
	/*
	 * url:
	 * method:
	 * 输入：
	 * 输出：
	 * 返回页面：
	
	*/
	@GetMapping("/publicPropertyManage.html")
	public String publicPropertyManage() {

		return "publicPropertyManage";
	}
	/*
	 * url:
	 * method:
	 * 输入：
	 * 输出：
	 * 返回页面：
	
	*/
	@GetMapping("/AddPublicProperty.html")
	public String AddPublicProperty(Model model) {
		model.addAttribute("publicProperty",new PublicProperty());
		return "AddPublicProperty";
	}
	/*
	 * url:
	 * method:
	 * 输入：
	 * 输出：
	 * 返回页面：
	
	*/
	@GetMapping("/ShowAllPublicProperty")
	public String ShowAllPublicProperty(Model model) {
		 List<PublicProperty> list=msi.listPublicProperty();  
			model.addAttribute("publicPropertyList",list);
		return "publicPropertyManage";
	}
	/*
	 * url:
	 * method:
	 * 输入：
	 * 输出：
	 * 返回页面：
	
	*/
	@PostMapping("/addPublicProperty")
	public String addPublicProperty(Model model,@ModelAttribute(value="publicProperty") PublicProperty property) {
		int rows=msi.addPublicProperty(property);
		//int rows=0;
		if(rows<=0) {
			String message="表单填写错误";
			model.addAttribute("message",message);
			return "AddPublicProperty";
		}
		else {
			
		return "publicPropertyManage";
		}
	}
	
	@GetMapping("/showAllparking.html")
	public String showAllparking(Model model) {
		// PublicPropertyRepo publicPropertyRepo=new PublicPropertyRepo();
		 List<Parking> list=msi.listParking();	  
		 model.addAttribute("carParkingList",list);
			 
		return "showAllparking";
	}
	/*
	 * url:
	 * method:
	 * 输入：
	 * 输出：
	 * 返回页面：
	
	*/	
	@GetMapping("/parkingPlaceManage.html")
	public String parkingPlaceManage(Model model) {
		// PublicPropertyRepo publicPropertyRepo=new PublicPropertyRepo();
		 List<CarParking> list=msi.listCarParking();	  
		 model.addAttribute("carParkingList",list);
			 
		return "parkingPlaceManage";
	}
	
	@GetMapping("/addCarParking.html")
	public String addCarParking(Model model) {
		 model.addAttribute("carParking",new  CarParking());
			 
		return "addCarParking";
	}
	/*
	 * url:
	 * method:
	 * 输入：
	 * 输出：
	 * 返回页面：
	
	*/
	@PostMapping("/addCarParking")
	public String addCarParking(Model model,@ModelAttribute(value="carParking") CarParking carParking) {
		int rows=msi.addCarParking(carParking);
		//int rows=0;
		if(rows<=0) {
			String message="表单填写错误";
			model.addAttribute("message",message);
			return "addCarParking";
		}
		else {
			
		return "redirect:showAllparking.html";
		}
	}
	
	/*
	 * url:
	 * method:
	 * 输入：
	 * 输出：
	 * 返回页面：
	
	*/
	@PostMapping("/audting")
    public String task(Model model,String p_id) {
		int id=Integer.parseInt(p_id);
		int num=msi.handleAudting(id);
		if(num<=0) {
			String message="操作失败，请重试";
			model.addAttribute("message", message);
		
		}
		else {
			String message="操作成功，请继续操作";
			model.addAttribute("message", message);
		}
		return "redirect:parkingPlaceManage.html";
    }
	


	@GetMapping("/feeManage.html")
	public String feeManager(Model model) {
		// PublicPropertyRepo publicPropertyRepo=new PublicPropertyRepo();
		 List<Fee> list=msi.listFee();	  
		 model.addAttribute("feeList",list);
			 
		return "feeManage";
	}
	
	@GetMapping("/addFee.html")
	public String addFee(Model model) {
		 model.addAttribute("fee",new  Fee());
			 
		return "addFee";
	}
	/*
	 * url:
	 * method:
	 * 输入：
	 * 输出：
	 * 返回页面：
	
	*/
	@PostMapping("/addFee")
	public String addFee(Model model,@ModelAttribute(value="fee") Fee fee) {
		int rows=msi.addFee(fee);
		//int rows=0;
		if(rows<=0) {
			String message="表单填写错误";
			model.addAttribute("message",message);
			return "addFee";
		}
		else {
			
		return "redirect:feeManage.html";
		}
	}
	
	@GetMapping("/feeNotify.html")
	public String feeNotify(Model model) {
		// PublicPropertyRepo publicPropertyRepo=new PublicPropertyRepo();
		 List<FeeNotify> list=msi.listFeeNotify();	  
		 model.addAttribute("feeNotifyList",list);
			 
		return "feeNotify";
	}
	
	@GetMapping("/addFeeNotify.html")
	public String addFeeNotify(Model model) {
		 model.addAttribute("feeNotify",new  FeeNotify());
			 
		return "addFeeNotify";
	}
	/*
	 * url:
	 * method:
	 * 输入：
	 * 输出：
	 * 返回页面：
	
	*/
	@PostMapping("/addFeeNotify")
	public String addFeeNotify(Model model,@ModelAttribute(value="feeNotify") FeeNotify feeNotify) {
		int rows=msi.addFeeNotify(feeNotify);
		//int rows=0;
		if(rows<=0) {
			String message="表单填写错误";
			model.addAttribute("message",message);
			return "addFeeNotify";
		}
		else {
			
		return "redirect:feeNotify.html";
		}
	}
	
}
