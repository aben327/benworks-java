package benworks.java.util.comparator;

/**
 * 运号单流程
 * 
 * @author Administrator
 * 
 */
public class Step {
	/** 处理时间 */
	private String acceptTime = "";
	/** 快件所在地点 */
	private String acceptAddress = "";

	public Step() {
		super();
	}

	public Step(String acceptTime, String acceptAddress) {
		super();
		this.acceptTime = acceptTime;
		this.acceptAddress = acceptAddress;
	}

	public String getAcceptTime() {
		return acceptTime;
	}

	public void setAcceptTime(String acceptTime) {
		this.acceptTime = acceptTime;
	}

	public String getAcceptAddress() {
		return acceptAddress;
	}

	public void setAcceptAddress(String acceptAddress) {
		this.acceptAddress = acceptAddress;
	}

}