package test;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Test1 {
	
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		Map<Integer, Integer> map = new TreeMap<>();
		map.put(1, 3);
		map.put(3, 5);
		map.put(2, 1);
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			System.out.println(e.getKey() + ":" + e.getValue());
		}
		for (Integer i : map.keySet()) {
			System.out.println(i);
		}
		for (Integer j : map.values()) {
			System.out.println(j);
		}
		Collection<Integer> values = map.values();
		Iterator<Integer> iterator = values.iterator();
		
	}

}
