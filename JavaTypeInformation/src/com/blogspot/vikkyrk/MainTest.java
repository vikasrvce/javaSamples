package com.blogspot.vikkyrk;

public class MainTest {

	/*
	 * Class.newInstance returns an Object, so an explicit cast to the required Class
	 * is needed. At runtime it may throw a ClassCastException.
	 * Class.isIntance(Object obj) is dynamic equivalent of instanceof operator
	 * Class.isAssignableForm(Object obj) is same as Class.inInstance, except it takes another Class ojbect instead of the Actual object.
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Class<TestNewInstance> c = null;
		c = TestNewInstance.class;
		c = (Class<TestNewInstance>)(Class)ExtendTestNewInstance.class;
		
		try {
			ExtendTestNewInstance ded = (ExtendTestNewInstance)c.newInstance();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			c = (Class<TestNewInstance>) Class.forName("com.blogspot.vikkyrk.ExtendTestNewInstance");
		} catch (ClassNotFoundException e) {
			System.out.println("Class TestNewInstance Not Found");
		}
		
		TestNewInstance t = null;
		try {
			System.out.println(c.getName());
			t = (TestNewInstance)c.newInstance();
			System.out.println(t.getClass().getName());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    Class<TestNewInstance> tt = TestNewInstance.class;
	    Class<TestNewInstance> ee = (Class<TestNewInstance>) (Class)(ExtendTestNewInstance.class);
		
	    if(ee.isInstance(t))
	    	System.out.println("Instanceof1");
	    
		if(ee.isAssignableFrom(tt))
	    	System.out.println("Instanceof2");
		
		
	}
}
