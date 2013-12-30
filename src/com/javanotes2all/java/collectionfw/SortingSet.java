package com.javanotes2all.java.collectionfw;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SortingSet 
{
	public TreeSet<String> sortSet(Set<String> s)
	{
		TreeSet<String> tset=new TreeSet<String>();
		Iterator<String> it = s.iterator();
		String doc;
		while(it.hasNext())
		{
			doc=it.next().toString();
			tset.add(doc);
		}
		return tset;
	}
}
