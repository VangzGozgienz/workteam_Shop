package com.oracle.shop.model.dao;

import java.util.List;

import javax.enterprise.inject.Alternative;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.oracle.shop.model.javabean.Goods;
import com.oracle.shop.model.javabean.Shopcart;

/**
 * 购物车的dao类
 * @author Administrator
 *
 */
@Mapper
public interface CarDAO {

	@Insert("insert into shopcart(carnumber,userid,goodsid) values(1,#{userid},#{productid})")
	public int addProduct(@Param("userid")int userid,@Param("productid")int productid);
	
	//使用聚拢函数，将购物车中userID和goodsid一致的商品分组存放并显示goodsnumber
	//@Select("select * from shopcart group by userid  ")
	
	
	@Select("select *  from shopcart where userid=#{0}")
	public List<Shopcart> listCartsByUserId(int userid);
	
	
	@Select("select * from goods where goodsid=#{0}")
	public  Goods  getGoodsByGoodsId(int goodsid);
	
	/**
	 * 从购物车表中删除商品的dao方法
	 */
	@Delete("delete from shopcart where goodsid=#{productid} and userid=#{userid}")
	public int deleteGoodsFromShopcar(@Param("userid")int userid,@Param("productid")int productid);
	
	//在收藏夹表中添加移除的商品信息
	@Insert("insert into collectors(goodsid,userid,collecttime) values(#{goodsid},#{userid},#{datetime})")
	public  int moveProductFromCar(@Param("goodsid")int goodsid,@Param("userid")int userid,@Param("datetime")String datetime);
	
	
}
