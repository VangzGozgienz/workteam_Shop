package com.oracle.shop.model.javabean;

import java.io.Serializable;

/**
 * 购物车 儌僨儖僋儔僗.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Shopcart implements Serializable {

	@Override
	public String toString() {
		return "Shopcart [carid=" + carid + ", carnumber=" + carnumber
				+ ", userid=" + userid + ", goodsid=" + goodsid + "]";
	}

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 购物车编号. */
	private Integer carid;

	/** 购物车数量. */
	private Integer carnumber;

	/** 用户编号. */
	private Integer userid;

	/** 商品编号. */
	private Integer goodsid;

	/**
	 * 僐儞僗僩儔僋僞.
	 */
	public Shopcart() {
	}

	/**
	 * 购物车编号 傪愝掕偟傑偡.
	 * 
	 * @param carid
	 *            购物车编号
	 */
	public void setCarid(Integer carid) {
		this.carid = carid;
	}

	/**
	 * 购物车编号 傪庢摼偟傑偡.
	 * 
	 * @return 购物车编号
	 */
	public Integer getCarid() {
		return this.carid;
	}

	/**
	 * 购物车数量 傪愝掕偟傑偡.
	 * 
	 * @param carnumber
	 *            购物车数量
	 */
	public void setCarnumber(Integer carnumber) {
		this.carnumber = carnumber;
	}

	/**
	 * 购物车数量 傪庢摼偟傑偡.
	 * 
	 * @return 购物车数量
	 */
	public Integer getCarnumber() {
		return this.carnumber;
	}

	/**
	 * 用户编号 傪愝掕偟傑偡.
	 * 
	 * @param userid
	 *            用户编号
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/**
	 * 用户编号 傪庢摼偟傑偡.
	 * 
	 * @return 用户编号
	 */
	public Integer getUserid() {
		return this.userid;
	}

	/**
	 * 商品编号 傪愝掕偟傑偡.
	 * 
	 * @param goodsid
	 *            商品编号
	 */
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	/**
	 * 商品编号 傪庢摼偟傑偡.
	 * 
	 * @return 商品编号
	 */
	public Integer getGoodsid() {
		return this.goodsid;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carid == null) ? 0 : carid.hashCode());

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Shopcart other = (Shopcart) obj;
		if (carid == null) {
			if (other.carid != null) {
				return false;
			}
		} else if (!carid.equals(other.carid)) {
			return false;
		}

		return true;
	}

}
