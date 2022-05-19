package study;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ADao {
	
	private static int id = 0;
	
	public void insert(A a) {
		map.put(++id, a);
	}
	
	private Map<Integer, A> map =
			new HashMap<Integer, A>();
	
	public Collection<A> select() {
		return map.values();
	}
}
