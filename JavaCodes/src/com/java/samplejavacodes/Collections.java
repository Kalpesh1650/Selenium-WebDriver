package com.java.samplejavacodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> names = new ArrayList<String>();
		Map<String,String> names_Map = new HashMap<String,String>();
		Set<String> s = new HashSet<String>();
		
		s.add("B");
		s.add("A");
		s.add("D");
		s.add("B");
		s.add("B");
		
		
		names.add("Ram");
		names.add("Sam");
		names.add("Patel");
		
		names_Map.put("r", "Ram");
		names_Map.put("k", "Krishna");
		
//		System.out.println(names.get(0));
		//System.out.println(names_Map.get("r"));
		java.util.Collections.sort(names);
		
		Iterator<String> it = names.iterator();
		while(it.hasNext())
		{
			String name = it.next();
			System.out.println(name);
		}
		
		System.out.println(s);
		
		

	}

}
