package com.xmlparsers;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {
	List<Goods> goodsList = new ArrayList<>();
	Goods goods = null;
	String content = null;

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		switch (qName) {
		case "goods":
			goods = new Goods();
			goods.setId(Integer.valueOf(attributes.getValue("id")));
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		switch (qName) {
		case "goods":
			goodsList.add(goods);
			break;
		case "name":
			goods.setName(content);
			break;
		case "price":
			goods.setPrice(Double.valueOf(content));
			break;
		case "category":
			goods.setCategory(content);
			break;
		case "description":
			goods.setDescription(content);
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		content = String.copyValueOf(ch, start, length).trim();
	}
}