package com.javanotes2all.java.collectionfw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeSet;

public class SortHashmapWithValues 
{
	public HashMap getSortedMap(HashMap hmap)
	{
	HashMap map = new LinkedHashMap();
	List mapKeys = new ArrayList(hmap.keySet());
	List mapValues = new ArrayList(hmap.values());
	hmap.clear();
	TreeSet sortedSet = new TreeSet(mapValues);
	Object[] sortedArray = sortedSet.toArray();
	int size = sortedArray.length;
	// a) Ascending sort
	for (int i=0; i<size; i++)
	{

	map.put(mapKeys.get(mapValues.indexOf(sortedArray[i])), sortedArray[i]);

	}
	return map;
	} 
}
