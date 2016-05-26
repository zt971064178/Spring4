package cn.itcast.spring4.snakeyaml;

public class Dev {

	private Boolean enabled ;
	private User inn ;
	private Long port ;
	private String type ;

	public Long getPort() {
		return port;
	}

	public void setPort(Long port) {
		this.port = port;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public User getInn() {
		return inn;
	}

	public void setInn(User inn) {
		this.inn = inn;
	}
}
