package com.oracle.shop.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.shop.model.dao.UserDAO;
import com.oracle.shop.model.javabean.Users;

@Controller
@RequestMapping("/user")
public class UserControl {
	
	@Autowired
	private UserDAO dao;
	

	@RequestMapping("/login")
	public String login(String username,String password,HttpSession  session) {
		System.out.println("user -login");
		
		//1.获取用户在表单上填写的账户资料
		System.out.println(username+"\t"+password);
		
		//2.查询数据库是否存在这个对应的账户和密码
		Users  u=dao.login(username, password);
		
		System.out.println(u);
		
		//3.判断，如果存在则跳转到首页，否则跳回到登录
		if(u==null){
			System.out.println("login fail");
			return "login";
		}else{
			System.out.println("login success");
			//应该讲登录成功的用户资料存储在session，这样页面可以访问登陆后的用户信息
			session.setAttribute("logineduser", u);
			return "index";
		}
		
	}
	
	//	退出登录
		@RequestMapping("/logout") 	
		public String loginout(HttpSession session) {
			session.removeAttribute("logineduser");
			System.out.println("清空session");
			return "index";
		}

//		注册
		@RequestMapping("/register")
		public String register(String username, String nickname, String password) {
			System.out.println("user -register");
//			1.获取用户注册信息

//			2.DAO连接
			int result =0;
			try {
				 result = dao.addUser(username, nickname, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(result>0) {
				return "login";
				
			}else {
				return "register";
				
			}
			
		}
	
	
	@RequestMapping("/updatePassword")
	public String updatePassword(){
		return "";
	}
}
