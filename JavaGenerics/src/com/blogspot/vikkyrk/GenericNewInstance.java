package com.blogspot.vikkyrk;
import java.lang.reflect.*;

/* This code will be used to simulate 'T t = new T();'
 * However it won't work for the following cases:
 * primitive arguments
 * Polymorphic Class Objects
 * Refer to https://github.com/clojure/clojure/blob/master/src/jvm/clojure/lang/Reflector.java#L150
 * for more details
 */ 
public class GenericNewInstance {
	
	public static <T> T createInstance(Class<T> cObj) {
        try {
			return cObj.newInstance();
		} catch (InstantiationException e) {
			System.out.println("Instantiation Exception");
			return null;
		} catch (IllegalAccessException e) {
			System.out.println("Illegal Access Exception");
			return null;
		}
    }
	
	public static <T> T createInstanceUsingRelection(Class<T> c, Object... initArgs) {
		Constructor<T> cTor = null;
		Class<?>[] cObjs = new Class<?>[initArgs.length];
		int i = 0;
        Class<?> cTemp = null;
		for(Object o : initArgs) {
			cTemp = o.getClass();
			if(cTemp.equals(Integer.TYPE)) {
				System.out.println("True");
			}
			else {
				System.out.println("False");
			}
			cObjs[i++] = o.getClass();
		}
		
		try {
		    cTor = c.getConstructor(cObjs);
		} catch (SecurityException e) {
			System.out.println("security exception. Cannot get Constructor");
			return null;
		} catch (NoSuchMethodException e) {
            System.out.println("NoSuchMethodException Cannot get constructor");
            return null;
		}
		
		try {
			return cTor.newInstance(initArgs);
		} catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument Exception");
            return null;
		} catch (InstantiationException e) {
            System.out.println("Instantiation Exception");
            return null;
		} catch (IllegalAccessException e) {
            System.out.println("Illegal Access Exception");
            return null;
		} catch (InvocationTargetException e) {
            System.out.println("Invocation Target Exception");
            return null;
		}
	}
}
