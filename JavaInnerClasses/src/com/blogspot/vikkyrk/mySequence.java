package com.blogspot.vikkyrk;
/*
 * Test Inner Class Usage
 * Inner Class has access to all Outer Class Fields
 * You cannot instantiate Inner Class without Outer Class Instantiation
 * OuterClass.this gives the object of outer class from inner class
 * To instantiate an Inner Class, OuterClass ot = new OuterClass(); InnerClass it = ot.new InnerClass();
 * Note that Inner Class that is private or protected, can be exposed to public only through the implementation of an interface,
 * that way we can access public methods without compilation error.
 * Note: Only Inner Classes can be private or protected :)
 * 
 * Major Advantages of Inner Classes
 * -> Helps implement multiple inheritance in Java
 * -> A class can implement an interface in multiple ways by using multiple inner classes implementing the same interface in a different way
 * -> They also help to switch between interface implementation dynamically (might be specifically useful to dynamically switch callback Implementation)
 * -> They help achieve CLOSURES in Java.
 */ 
public class mySequence {
    private String[] mObj = null;
    private int size;
    private int current = -1;
    
    public mySequence(int size) {
    	this.size = size;
    	mObj = new String[size];
    }
    
    public void add (String s) {
    	if (current <= size)
    	    mObj[++current] = s;
    }
    
    public void remove() {
    	if (current !=0)  
    	    mObj[current--] = null;
    }
    
    public mySequenceSelector getSelector() {
    	return new mySequenceSelector();
    }
    
    private class mySequenceSelector implements mySelectorInterface {
    
    	int index = 0;

    	public String next() {
    		if (hasNext())
        		return mObj[index++];
    		else
    			return null;
    	}
    	
    	public String peek() {
    		if (hasNext()) {
    			return mObj[index];
    		}
    		
    		return null;
    	}
    	
    	public boolean hasNext() {
    		if (index > current)
    			return false;
    		else
    			return true;
    	}
    }
}
