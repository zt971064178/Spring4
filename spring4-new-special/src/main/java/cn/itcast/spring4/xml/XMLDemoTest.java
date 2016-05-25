package cn.itcast.spring4.xml;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import cn.itcast.spring4.yaml.Hero;

public class XMLDemoTest {
	@Test
	public void testJava2XML() {
		Hero hero = new Hero();

		hero.setId(1L);
		hero.setName("Tsybius2014");
		hero.setLevel(5);
		hero.setGender(true);
		try {
		    hero.setBirthDate((new SimpleDateFormat("yyyy/MM/dd")).parse("1991/09/20"));
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		hero.setHonors(new String[] {"abcdefg", "hijklmn", "opqrst", "uvwxyz"});
		hero.getLog().addLast("log1");
		hero.getLog().addLast("log2");
		hero.getLog().addLast("log3");

		Hero spouse = new Hero();
		spouse.setId(2L);
		spouse.setName("Galatea");
		spouse.setGender(false);
		spouse.setHonors(new String[] {"Honor1", "Honor2"});
		hero.setSpouse(spouse);

		Hero child1 = new Hero();
		child1.setId(3L);
		child1.setName("Quintus");
		Hero child2 = new Hero();
		child2.setId(4L);
		child2.setName("Gaius");
		hero.setChildren(new Hero[] {child1, child2});

		String xml = XmlParser.parseToXml(hero) ;
		System.out.println(xml);
	}
	
	@Test
	public void testXML2Java() throws IOException {
		
		String xml = IOUtils.toString(Hero.class.getClassLoader().getResourceAsStream("cn/itcast/spring4/xml/xml.xml"), "UTF-8") ;
		Hero result = XmlParser.loadFromXml(xml) ;
		System.out.println(result);
	}
}
