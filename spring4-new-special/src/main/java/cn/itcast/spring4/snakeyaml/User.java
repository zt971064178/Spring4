package cn.itcast.spring4.snakeyaml;

public class User {

	private String name ;
	private Long timeout ;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Long getTimeout() {
		return timeout;
	}

	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}
	
}
