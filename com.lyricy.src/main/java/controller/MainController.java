package controller;

import com.alibaba.fastjson.JSON;
import dao.DaoInf;
import model.Functions;
import model.Test1;
import model.Users;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.shiro.subject.Subject;
import service.MenuService;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mainkind")
public class MainController {
	private static Logger logger = Logger.getLogger(MainController.class);
	@Autowired
	private MenuService menuService;

	@RequestMapping("/to_main")
	public String getTest(String user_id,String password,Map<String, Object> map){
		Subject current = SecurityUtils.getSubject();
		String returnMsg = "";
		if (!current.isAuthenticated()){
			UsernamePasswordToken token = new UsernamePasswordToken(user_id,password);
			try {
				current.login(token);
			}catch (UnknownAccountException e){
				returnMsg = "登陆失败，用户不存在!";
				map.put("returnMsg",returnMsg);
				return "login";
			}catch (IncorrectCredentialsException e){
				returnMsg = "登陆失败，账户或密码错误！";
				map.put("returnMsg",returnMsg);
				return "login";
			}catch (AuthenticationException e){
				returnMsg = "登陆失败！";
				map.put("returnMsg",returnMsg);
				return "login";
			}
			returnMsg = "登陆成功！";
		}else {
			returnMsg = "已登录用户...";
		}
		getMenu(map);
		logger.info(returnMsg );
		return "main";
	}
	
	public void getMenu(Map<String, Object> map) {
		Subject sub = SecurityUtils.getSubject();
		Users user = (Users)sub.getPrincipal();
		List<Functions> menuList = menuService.getMenuByName(user.getUsername());
		map.put("menuList",menuList);
		logger.info("菜单：" + JSON.toJSONString(menuList));
	}
	@RequestMapping(value = "/to_login")
	public String to_login() {
		logger.info("跳转到登陆页面...");
		return "login";
	}
	@RequestMapping(value = "/loginout")
	public String loginout() {
		logger.info("登出...");
		Subject current = SecurityUtils.getSubject();
		current.logout();
		return "login";
	}
	@RequestMapping(value = "/personInfo")
	public String personInfo(Map<String, Object> map) {
		Subject sub = SecurityUtils.getSubject();
		Users user = (Users) sub.getPrincipal();
		map.put("username",user.getUsername());
		map.put("password",user.getPassword());
		return "personInfoPage";
	}
	@RequestMapping(value = "/to_manager")
	public String manager(Map<String, Object> map) {
		Subject sub = SecurityUtils.getSubject();
		Users user = (Users) sub.getPrincipal();
		return "system";
	}
}
