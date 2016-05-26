package cn.itcast.spring4.snakeyaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

public class SnakeYamlDemo {
	@SuppressWarnings("unchecked")
	@Test
	public void testLoadMap() throws IOException {
		Yaml yaml = new Yaml() ;
		Map<String, Object> map = null ;
		
		InputStream is = SnakeYamlDemo.class.getResourceAsStream("snake.yml") ;
		if (is != null) {
		    map = yaml.loadAs(is, Map.class) ;
		    is.close();
		}
		System.out.println(map);
	}
	
	@Test
	public void testLoadObject() throws IOException {
		Yaml yaml = new Yaml();
		List<Object> list = null;
		InputStream is = SnakeYamlDemo.class.getResourceAsStream("obj.yml");
		
		if (is != null) {
		    list = new ArrayList<Object>();
		    for (Object obj : yaml.loadAll(is)) {
		      list.add(obj);
		    }
		    is.close();
		}
		System.out.println(list);
	}
}
