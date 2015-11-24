package benworks.java.lang.cloneable;

import java.util.Date;

/**
 * Object中默认的实现是一个浅拷贝,也就是表面拷贝,如果需要实现深层次拷贝 的话,必须对类中可变域生成新的实例.
 * @author Ben
 * @date 2015年11月23日下午3:38:47
 */
public class DeepCopy implements Cloneable {
	private Date begin;

	public Date getBegin() {
		return this.begin;
	}

	public void setBegin(Date d) {
		this.begin = d;
	}

	public Object clone() {
		DeepCopy obj = null;
		try {
			obj = (DeepCopy) super.clone();
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}

		// deep 插一个简单使用clone的例子，如果一个对象内部有可变对象实例的话，public API不应该直接返回该对象的引用，
		// 以防调用方的code改变该对象的内部状态。这个时候可以返回该对象的clone。
		obj.setBegin((Date) this.getBegin().clone());
		return obj;
	}
}
