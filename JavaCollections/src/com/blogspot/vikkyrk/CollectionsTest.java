package com.blogspot.vikkyrk;
import java.util.*;

public class CollectionsTest {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, Exception {

		List<String> mList = new ArrayList<String>();
		mList.add("Vikas");
		mList.add("Vinyas");
		mList.add("Shobha");
		mList.add("Ramesh");
		
		List<String> mSubList = mList.subList(0, 2);
		
	    Collections.shuffle(mSubList);
	    
	    System.out.println(mSubList);
		System.out.println(mList);
		Class c = null;
		try {
            c = Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			System.out.println("Exception Here");
		}
		
		Integer s = (Integer)c.newInstance();
    }
}
