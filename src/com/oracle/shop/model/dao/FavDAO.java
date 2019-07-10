package com.oracle.shop.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.oracle.shop.model.javabean.Goods;

@Mapper
public interface FavDAO {

	@Insert("insert into collectors(goodsid,userid,collecttime) values(#{goodsid},#{userid},#{datetime})")
	public int addProductToFav(@Param("goodsid")int goodsid,@Param("userid")int userid,@Param("datetime")String datetime);
	
	@Select("select *  from goods where goodsid in (select goodsid from collectors where userid=#{0})")
	public List<Goods> listAllProductsOfFav(int userid);
	
	@Delete("delete from collectors where goodsid=#{productid} and userid=#{userid}")
	public int deleteProductFromFav(@Param("userid")int userid,@Param("productid")int productid);
	
	@Insert("insert into shopcart(carnumber,userid,goodsid) values(1,#{userid},#{productid})")
	public int moveProductToShopcar(@Param("userid")int userid,@Param("productid")int productid);
	
	
}
