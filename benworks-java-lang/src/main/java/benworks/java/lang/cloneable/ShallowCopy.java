package benworks.java.lang.cloneable;

import java.util.Date;

/**
 * clone方法是在Object种定义的,而且是protected型的,只有实现了这个接口,才 可以在该类的实例上调用clone方法,<br>
 * 否则会抛出CloneNotSupportException.
 * @author Roc
 * @date 2015年11月23日下午3:38:01
 */
public class ShallowCopy implements Cloneable {
	private Date begin;

	public Date getBegin() {
		return this.begin;
	}

	public void setBegin(Date d) {
		this.begin = d;
	}

	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
		return obj;
	}
}
