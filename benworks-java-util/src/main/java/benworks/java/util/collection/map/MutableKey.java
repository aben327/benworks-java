package benworks.java.util.collection.map;
/**
 * 
 * @author Roc
 * @date 2016年4月14日下午8:54:44
 */
public class MutableKey {
	private int i;
	private int j;

	public MutableKey(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public final int getI() {
		return i;
	}

	public final void setI(int i) {
		this.i = i;
	}

	public final int getJ() {
		return j;
	}

	public final void setJ(int j) {
		this.j = j;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MutableKey)) {
			return false;
		}
		MutableKey other = (MutableKey) obj;
		if (i != other.i) {
			return false;
		}
		if (j != other.j) {
			return false;
		}
		return true;
	}
}
