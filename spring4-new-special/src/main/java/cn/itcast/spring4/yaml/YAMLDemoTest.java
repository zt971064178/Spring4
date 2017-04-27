package cn.itcast.spring4.yaml;

import org.ho.yaml.Yaml;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class YAMLDemoTest {
	@Test
	public void testJava2YAML() {
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

		String yaml = Yaml.dump(hero);
		System.out.println(yaml);
	}
	
	@Test
	public void testYAML2Java() throws FileNotFoundException {
		// Hero result = (Hero) Yaml.load(Hero.class.getResourceAsStream("hero.yml"));
		Hero result = Yaml.loadType(Hero.class.getResourceAsStream("hero.yml"), Hero.class); //另一种方法
		System.out.println(result);
	}
}
