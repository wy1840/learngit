package cn.zaw.tsys.common.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zaw.tsys.common.service.LoginService;
import cn.zaw.tsys.common.web.JsonResult;

@Controller
public class LoginController {
	@Resource
	private LoginService loginService;
	@RequestMapping("/loginUI")
	public String login(){
		return "login";
	}
	/**登录操作*/
	@RequestMapping("/login")
	@ResponseBody
	public JsonResult login(String username,String password,Integer role, HttpSession session){
		System.out.println(username+"/"+password+"/"+role);
	    int choose = loginService.login(username, password, role, session);
		return new JsonResult(choose);
	}
	@RequestMapping("/indexUI")
	public String index() {
		return "index";
	}
	/**退出登录*/
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}
	@RequestMapping("/loginMsg")
	public String loginMsg() {
		return "loginMsg";
	}
	@RequestMapping("/stuQuestionsUI")
	public String toStuQuestionUI() {
		return "/student/index";
	}
}
