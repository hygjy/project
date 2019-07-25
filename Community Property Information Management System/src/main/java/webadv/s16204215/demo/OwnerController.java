package webadv.s16204215.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import webadv.s16204215.demo.beans.Owner;
import webadv.s16204215.demo.service.OwnerService;

/**
 * @author jm
 * @category owner
 */
@Controller
public class OwnerController {
	private int owner_id = 2;

	@Autowired
	private OwnerService os;

	/**
	 * 查看业主信息
	 */
	@GetMapping("/ownerInfo")
	public String ownerInfo(Model model) {
		model.addAttribute("ownerInfo", os.findOwnerById(owner_id));
		return "ownerInfo";
	}

	/**
	 * 安全退出
	 */
	@GetMapping("/home")
	public String home(Model model) {
		return "home";
	}

	/**
	 * 修改个人信息
	 */
	@PostMapping("/updateOwnerInfo")
	public String updateOwnerInfo(Model model, int id, String name, String sex, int age, String password,
			String phone) {
		Owner owner = new Owner(id, password, name, sex, age, phone);
		if (os.modifyOwnerById(owner) > 0)
			model.addAttribute("message", "修改成功");
		else
			model.addAttribute("message", "修改失败，请重新修改");
		model.addAttribute("ownerInfo", os.findOwnerById(owner_id));
		return "ownerInfo";
	}

	/**
	 * 在线报修
	 */
	@GetMapping("/addFix")
	public String addFix(Model model) {
		return "addFix";
	}

	/**
	 * 公告
	 */
	@GetMapping("/announcementInfo")
	public String announcementInfo(Model model) {
		model.addAttribute("announcement_list", os.findAnnouncement());
		return "announcementInfo";
	}

	/**
	 * 申请车位
	 */
	@GetMapping("/applyCarParking")
	public String applyCarParking(Model model) {
		return "applyCarParking";
	}

	/**
	 * 历史账单
	 */
	@GetMapping("/feeFormInfo")
	public String feeFormInfo(Model model) {
		model.addAttribute("fee_form_list", os.findFeeFormById(owner_id));
		return "feeFormInfo";
	}

	/**
	 * 缴费通知
	 */
	@GetMapping("/feeNotifyInfo")
	public String feeNotifyInfo(Model model) {
		model.addAttribute("fee_notify_list", os.findFeeNotifyById(owner_id));
		return "feeNotifyInfo";
	}

	/**
	 * 意见投诉
	 */
	@GetMapping("/suggest")
	public String suggest(Model model) {
		return "suggest";
	}
}
