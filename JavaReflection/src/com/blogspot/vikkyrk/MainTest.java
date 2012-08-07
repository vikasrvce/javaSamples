package com.blogspot.vikkyrk;

import java.lang.reflect.*;
public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Class<?> c=null;
		try {
			c = Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
	     
		Method[] m = c.getMethods();
		
		for(int i=0;i<m.length;i++) {
			System.out.println(m[i].toString());
		}
		
	}
	
	public static tempInterface<Integer> generator() {
		return new tempInterface<Integer>() {
			public Integer next() {
				return new Integer(1);
			}
		};
	}
}
