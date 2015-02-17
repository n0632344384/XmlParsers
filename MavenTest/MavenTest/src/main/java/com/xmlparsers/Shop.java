package com.xmlparsers;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Shop {

	private ArrayList<Goods> goods;

	public Shop() {
	}

	public ArrayList<Goods> getGoods() {
		return goods;
	}

	@XmlElement
	public void setGoods(ArrayList<Goods> goods) {
		this.goods = goods;
	}
}