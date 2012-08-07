package com.blogspot.vikkyrk;

/*
 * Anonymous Inner Class usage
 * Can access all the class variables
 * Cannot access method local variables as they are allocated on the stack unless they are declared FINAL
 */
public class AnonymousInnerClass {

	private int i = 5;
	
	public String s = "Vikas";
	
	public AnonymousInnerClass() {
		s = new String("Vinyas");
		i = 6;
	}
	
	public void setString() {
		s = new String("Shobha");
	}
	
	public mySelectorInterface getSelector(final String ss) {
		
		return new mySelectorInterface() {
			public String next() {
				AnonymousInnerClass.this.i = 7;
				return s;
			}
			
			public String peek() {
				return ss;
			}
			
			public boolean hasNext() {
				return true;
			}
		};
	}
}
