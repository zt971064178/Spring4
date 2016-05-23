package cn.itcast.spring4.generic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class DemoService {

	@Autowired
    private Service<String, Integer> abService;
    @Autowired
    private Service<Long, Object> cdService;

    private List<List<String>> list;

    private Map<String, Map<String, Integer>> map;

    private List<Map<String,String>>[] array;
    
    public DemoService() {
    	
    }
    
    public DemoService(List<List<String>> list, Map<String, Map<String, Integer>> map) {
    	
    }
	
    private HashMap<String, List<String>> method() {
        return null;
    }
}
