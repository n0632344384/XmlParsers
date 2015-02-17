package com.xmlparsers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// –аспарсить следующий xml при помощи DOM, SAX, StAX и провести marshalling и unmarshalling (JAXB)
public class XmlParsersTest {

	private static final String SHOP = "shop.xml";

	public static void main(String[] arg) throws Exception {
		marshalling(createShopGoods());
		unmarshalling();
		domParser();
		saxParser();
		staxParser();
	}

	public static Shop createShopGoods() {
		Shop shop = new Shop();
		ArrayList<Goods> goods = new ArrayList<Goods>();
		Goods good1 = new Goods("Good1", 100.00, "category1", "description1");
		goods.add(good1);
		Goods good2 = new Goods("Good2", 200.00, "category2", "description2");
		goods.add(good2);
		Goods good3 = new Goods("Good3", 300.00, "category3", "description3");
		goods.add(good3);
		shop.setGoods(goods);
		System.out.println("Created Shop object:");
		return shop;
	}

	public static void marshalling(Shop shop) {
		System.out.println("Marshalling " + SHOP + ":");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Shop.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					Boolean.TRUE);
			File XMLfile = new File("src\\main\\resources\\shop.xml");

			jaxbMarshaller.marshal(shop, XMLfile);
			jaxbMarshaller.marshal(shop, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void unmarshalling() {
		System.out.println("\nUnmarshalling " + SHOP + ":");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Shop.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			File XMLfile = new File(SHOP);
			Shop shop = (Shop) jaxbUnmarshaller.unmarshal(XMLfile);
			ArrayList<Goods> goods = shop.getGoods();
			for (Goods good : goods) {
				System.out.println("Name: " + good.getName() + " Price: "
						+ good.getPrice() + " Category: " + good.getCategory()
						+ " Description: " + good.getDescription());
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void domParser() throws Exception {
		System.out.println("\nDOM Paser " + SHOP + ":");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(ClassLoader
				.getSystemResourceAsStream(SHOP));

		List<Goods> goodsList = new ArrayList<Goods>();
		NodeList nodeList = document.getDocumentElement().getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node instanceof Element) {
				Goods goods = new Goods();
				goods.setId(Integer.valueOf(node.getAttributes()
						.getNamedItem("id").getNodeValue()));
				NodeList childNodes = node.getChildNodes();
				for (int j = 0; j < childNodes.getLength(); j++) {
					Node cNode = childNodes.item(j);
					if (cNode instanceof Element) {
						String content = cNode.getLastChild().getTextContent()
								.trim();
						switch (cNode.getNodeName()) {
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
				}
				goodsList.add(goods);
			}
		}
		for (Goods goods : goodsList) {
			System.out.println(goods);
		}
	}

	public static void saxParser() throws Exception {
		System.out.println("\nSAX Parser " + SHOP + ":");
		SAXParserFactory parserFactor = SAXParserFactory.newInstance();
		SAXParser parser = parserFactor.newSAXParser();
		SAXHandler handler = new SAXHandler();
		parser.parse(ClassLoader.getSystemResourceAsStream(SHOP), handler);

		for (Goods goods : handler.goodsList) {
			System.out.println(goods);
		}
	}

	public static void staxParser() throws XMLStreamException {
		System.out.println("\nStAX Parser " + SHOP + ":");
		List<Goods> goodsList = null;
		Goods goods = null;
		String tagContent = null;
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(ClassLoader
				.getSystemResourceAsStream(SHOP));

		while (reader.hasNext()) {
			int event = reader.next();

			switch (event) {
			case XMLStreamConstants.START_ELEMENT:
				if ("goods".equals(reader.getLocalName())) {
					goods = new Goods();
					goods.setId(Integer.valueOf(reader.getAttributeValue(0)));
				}
				if ("shop".equals(reader.getLocalName())) {
					goodsList = new ArrayList<>();
				}
				break;

			case XMLStreamConstants.CHARACTERS:
				tagContent = reader.getText().trim();
				break;

			case XMLStreamConstants.END_ELEMENT:
				switch (reader.getLocalName()) {
				case "goods":
					goodsList.add(goods);
					break;
				case "name":
					goods.setName(tagContent);
					break;
				case "price":
					goods.setPrice(Double.valueOf(tagContent));
					break;
				case "category":
					goods.setCategory(tagContent);
					break;
				case "description":
					goods.setDescription(tagContent);
					break;
				}
				break;

			case XMLStreamConstants.START_DOCUMENT:
				goodsList = new ArrayList<>();
				break;
			}
		}

		for (Goods good : goodsList) {
			System.out.println(good);
		}
	}
}