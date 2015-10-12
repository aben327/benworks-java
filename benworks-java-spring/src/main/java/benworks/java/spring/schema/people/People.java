package benworks.java.spring.schema.people;

/**
 * 1）设计配置属性和JavaBean <br>
 * 首先当然得设计好配置项，并通过JavaBean来建模，本例中需要配置People实体，配置属性name和age（id是默认需要的）<br>
 * 2) 为上一步设计好的配置项编写XSD文件，XSD是schema的定义文件，配置的输入和解析输出都是以XSD为契约
 * @author Ben
 * @date 2015年9月30日上午10:48:25
 */
public class People {
	/** 编号 **/
	private String id;
	/** 姓名 **/
	private String name;
	/** 年龄 **/
	private Integer age;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
