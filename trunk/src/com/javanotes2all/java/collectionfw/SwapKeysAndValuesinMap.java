package com.javanotes2all.java.collectionfw;

import java.util.HashMap;
import java.util.Map;

public class SwapKeysAndValuesinMap {

	public static void main(String[] args) {
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");
		map.put("4", "d");
		map.put("5", "e");
		map.put("6", "f");
		map.put("7", "g");
		System.out.println("before swap"+map);
		map=reverse(map);
		System.out.println("after swap"+map);
	}
	public static <K,V> HashMap<V,K> reverse(Map<K,V> map) {
	    HashMap<V,K> rev = new HashMap<V, K>();
	    for(Map.Entry<K,V> entry : map.entrySet())
	        rev.put(entry.getValue(), entry.getKey());
	    return rev;
	}
}
