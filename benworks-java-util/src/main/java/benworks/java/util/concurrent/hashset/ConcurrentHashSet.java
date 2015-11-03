package benworks.java.util.concurrent.hashset;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashSet<E> extends AbstractSet<E> implements Serializable {

	private static final long serialVersionUID = 2894194625323761272L;

	protected final ConcurrentHashMap<E, Boolean> map;

	public ConcurrentHashSet() {
		this.map = new ConcurrentHashMap<E, Boolean>();
	}

	public ConcurrentHashSet(int initialCapacity) {
		this.map = new ConcurrentHashMap<E, Boolean>(initialCapacity);
	}

	public ConcurrentHashSet(int initialCapacity, float loadFactor) {
		this.map = new ConcurrentHashMap<E, Boolean>(initialCapacity, loadFactor);
	}

	public ConcurrentHashSet(int initialCapacity, float loadFactor, int concurrencyLevel) {
		this.map = new ConcurrentHashMap<E, Boolean>(initialCapacity, loadFactor, concurrencyLevel);
	}

	public ConcurrentHashSet(Collection<E> collection) {
		this(collection.size());
		addAll(collection);
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean contains(Object o) {
		return map.containsKey(o);
	}

	@Override
	public Iterator<E> iterator() {
		return map.keySet().iterator();
	}

	@Override
	public boolean add(E o) {
		return map.put(o, Boolean.TRUE) == null;
	}

	@Override
	public boolean remove(Object o) {
		return map.remove(o) != null;
	}

	@Override
	public void clear() {
		map.clear();
	}

}
