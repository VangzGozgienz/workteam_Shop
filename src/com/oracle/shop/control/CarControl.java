package com.oracle.shop.control;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.shop.model.dao.CarDAO;
import com.oracle.shop.model.javabean.Goods;
import com.oracle.shop.model.javabean.Shopcart;
import com.oracle.shop.model.javabean.Users;
/**
 * 购物车模块的后台control
 * @author Administrator
 *
 */

@Controller
@RequestMapping("/car")
public class CarControl {
	
	@RequestMapping("/move")
	public String moveProductfromShopcart(int  pid,HttpSession session) {
		//1.获取用户在网页上要移入收藏夹的商品ID
		//2.调用dao方法将这个ID的商品从购物车表中删除
		//3.从session中获取用户编号
		
		int userid=((Users)session.getAttribute("logineduser")).getUserid();
		System.out.println("删除购物车的方法");
		int result1=dao.deleteGoodsFromShopcar(userid, pid);
		
						
		//4.将商品的信息加入收藏夹中
		int result2=dao.moveProductFromCar(pid, userid,new Date().toLocaleString() );
		
		
		System.out.println(result1>0&&result2>0?"移除成功":"移除失败");
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String deleteProductFormShopcar(int pid,HttpSession session){
		//1.获取用户在网页上要删除的商品id
		//2.调用dao方法将这个id的商品从购物车表中删除
		//从session中获取登录的用户编号
		int userid=((Users)session.getAttribute("logineduser")).getUserid();
		System.out.println("删除购物车的方法");
		int result=dao.deleteGoodsFromShopcar(userid, pid);
		System.out.println(result>0?"删除成功":"删除失败");
		return "redirect:list";
	}
	
	
	@Autowired
	private CarDAO dao;

	@RequestMapping("/add")
	public String addProductToCar(int pid,HttpSession session){
		//判断是否登录，没有登录，直接跳转到登录页面
		if(session.getAttribute("logineduser")==null){
			return "login";
		}else{
	
			//从session中获取登录的用户编号
			int userid=((Users)session.getAttribute("logineduser")).getUserid();
			
			//调用dao方法将当前商品添加到购物车表中
			
			/****
			 * 在添加之前先查询该用户的购物车表里面是否有这个商品，
			 * 如果有应该查处之前的数量，将数量加1然后修改到购物车表
			 * 如果没有，则直接执行添加到购物车表
			 * 
			 * ???
			 */
			
			int result=dao.addProduct(userid, pid);
			System.out.println(result>0?"添加成功":"添加失败");
			
			
		return "redirect:list";
		}
	}
	/**
	 * 这是查询用户下的多有购物车商品信息的方法
	 * @param session
	 * @param m
	 * @return
	 */
	@RequestMapping("/list")
	public String listCars(HttpSession session,Model  m){
		System.out.println("list cars");
		
		if(session.getAttribute("logineduser")==null){
			return "login";
		}else{
	
		//从session中获取登录的用户编号
		int userid=((Users)session.getAttribute("logineduser")).getUserid();
		Map<Goods, Integer> detailCars=new HashMap<>();
		
		
		List<Shopcart> sc=dao.listCartsByUserId(userid);
		
		for(Shopcart s:sc){
			detailCars.put(dao.getGoodsByGoodsId(s.getGoodsid()), s.getCarnumber());
		}
		m.addAttribute("sc", detailCars);
		return "cart";
		}
	}
}
