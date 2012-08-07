package com.blogspot.vikkyrk;

import java.util.HashMap;
import java.util.Map;

public class GenericDynamicAllocation {
	
	private Map<String,Class<?>> mMap;
	
	public GenericDynamicAllocation() {
		mMap = new HashMap<String,Class<?>>();
	}
	
	public GenericDynamicAllocation(int a) {
		System.out.println(a);
	}
	
	public void addType(String s, Class<?> cObj) {
		mMap.put(s, cObj);
	}
	
	public <T> T createType(String s) throws Exception{
		
		Class<?> cObj = mMap.get(s);
		System.out.println(cObj.getName());
		T t = null;
		    t = (T)cObj.newInstance();
		return t;
	}

}
