package webadv.s16204215.demo;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import webadv.s16204215.demo.beans.Manager;
import webadv.s16204215.demo.beans.Owner;
import webadv.s16204215.demo.service.ManagerServiceImpl;


@Controller
public class HomeController {
	@Autowired
	private ManagerServiceImpl msi;

//	@GetMapping("/")
//	public String login(Model model) {
//		model.addAttribute("user", new User());
//		return "login";
//	}
	@GetMapping("/")
	public String login() {
		return "login";
	}

	@GetMapping("/logout")
	public String logout() {
		return "login";
	}

	@GetMapping("/index.html")
	public String index(Model model, HttpSession session) {
		model.addAttribute("manager", session.getAttribute("user"));
		return "index";
	}
	
	

	@RequestMapping("/checkName/{account}/{password}/{identify}")
	@ResponseBody
	public String checkUser(@PathVariable(value = "account") String account,
			@PathVariable(value = "password") String password, @PathVariable(value = "identify") String identify,HttpSession session) {
		if (identify.equals("manager")) {
			Manager manager = msi.checkManager(account, password);
			if (manager == null) {
				return "failure";
			} else {
				session.setAttribute("user", manager);
				return "successM";
			}
		} else {
			Owner owner = msi.checkOwner(account, password);
			if (owner == null) {
				return "failure";
			} else {
				session.setAttribute("user", owner);
				return "successU";
			}
		}
	}
	
	//	@Autowired
//	private ManagerServiceImpl msi;
//	
//	@GetMapping("/")
//	public String login() {
//		return "login";
//	}
//	
//	@GetMapping("/logout")
//	public String logout() {
//		return "login";
//	}
//	
//	@GetMapping("/index.html")
//	public String index(Model model,HttpSession session) {
//		model.addAttribute("manager", session.getAttribute("user"));
//		return "index";
//	}
//	
//	@PostMapping("/login")
//	public String login(Model model,String account, String password) {
//		if ("abc".equals(account) && "123".equals(password)) {
//			return "home";
//		}else
//			return "login";
//	}
	
//	@PostMapping("/login")
//	public String checkUser(Model model,HttpSession session, String account, String password, String identify) {
//		if (identify == null) {
//			model.addAttribute("message", "请先选择用户角色");
//			return "login";
//		} else if (identify.equals("manager")) {
//			Manager manager = msi.checkManager(account, password);
//			if (manager == null) {
//				model.addAttribute("message", "用户名或密码错误");
//				return "login";
//			} else {
//				model.addAttribute("manager", manager);
//				session.setAttribute("user", manager);
//				return "index";
//			}
//		} else {
//			Owner owner = msi.checkOwner(account, password);
//			if (owner == null) {
//				model.addAttribute("message", "用户名或密码错误");
//				return "login";
//			} else {
//				model.addAttribute("owner", owner);
//				session.setAttribute("user", owner);
//				return "home";
//			}
//
//		}
//
//	}
}