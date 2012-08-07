package com.blogspot.vikkyrk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.*;
public class MainTest {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) throws Exception{

	/*	GenericDynamicAllocation gd = new GenericDynamicAllocation();
		
		gd.addType("String", String.class);
		gd.addType("Integer",Integer.class);
		gd.addType("Byte",Byte.class);
		
		Integer s = gd.createType("String");
		System.out.println("Vikas" + s);
		System.out.println(new String("f")); */
		String s = null;
		s = GenericNewInstance.createInstance(String.class);
		Integer i = null;
		i = GenericNewInstance.createInstanceUsingRelection(Integer.class, 1);
		System.out.println(s + i);
        System.out.println();
        
        Integer ii = new Integer(1);
        int a = (int)ii;
        
        System.out.println(a);
        
        String str = (String) ConstructorUtils.invokeConstructor(String.class, "String");
        System.out.println(str);
        GenericDynamicAllocation dd = (GenericDynamicAllocation) ConstructorUtils.invokeConstructor(GenericDynamicAllocation.class, 234);
       
        /*
         * Type Inference in Java. Serializable is a parent of all the three parameters
         */
        Serializable sde = pick("d", new ArrayList<String>());
        System.out.println(sde);
        
        List<Number> ll = new ArrayList<Number>();
        List<Integer> il = new ArrayList<Integer>();
        
        ll.add(new Integer(1));
        ll.add(new Double(2.3));
        
        ll.set(0, ll.get(1));
        
        sList(ll,new Integer(1));
        
        sList(il, new Double(12.0));
        
        sListA(ll,new Integer(1));
        /*
         * sListA(il,new Double(12.0)); Error since compiler can 
         * easily detect the List<Integer>, Double
         */
        Number[] n = new Number[3];
        n[0] = new Integer(22);
        n[1] = new Double(2.3);
        n[2] = new Integer(33);
        
        ll.addAll(Arrays.asList(n));
        il.addAll(Arrays.asList(1,2,3));
        gPrint(ll);
        gPrint(il);
        gPrintA(ll);
        gPrintA(il);
        
        gPrintB(il);
        //Cannot convert List<Integer> to List<Object>. So wildcard is necessary in this case.
        //gPrintC((List<Object>il);
        gPrintD((List)il);
        gPrintM(il);
        gPrintM(ll);
        
        /*
         * BridgeMethodDemo
         */
        
        BridgeMethodDemoNode<Integer> bm = new BridgeMethodChildNode(3);
        bm.setData(5);
        
        List<Integer> la = Arrays.asList(new Integer[]{1,2,3});
        la.add(1);
	}
	
	static <T> T pick(T a1, T a2) { return a2;}
	
	/*
	 * The wildcard can be used in a variety of situations: as the type of a parameter, 
	 * field, or local variable; sometimes as a return type
	 * The wildcard is never used as a type argument for a generic method invocation,
	 *  a generic class instance creation, or a supertype.
	 */
	
	/*
	 * In this case the compiler is fine, but it won't allow List<? extends Number> 
	 * to add anything, since at compile time it does not know anything about 
	 * what '?' is 
	 */
    
	static <T extends Number> void sList(List<? extends Number> l, T t) {
		
		//l.add(t);
		//l.add(new Integer(1));
	}
	
	static <T extends Number> void sListA(List<T> l, T t) {
		l.add(t);
	    //This is not allowed again as compiler cannot take any risk adding any type that extends Number
		//For example, l may be a List<Double> and you are trying to add Integer which is wrong.
		//But sad part is even if you pass List<Number>  you cannot add an Integer.
		//l.add(new Integer(1));
	}
	
	/*
	 * The following function shows there is no need for Wildcard as such, just that
	 * its a cleaner way of handling things sometimes (ie less verbose).
	 */
	static void gPrint(List<? extends Number> l) {
		
		for(Number n : l) {
			System.out.println(n);
		}
	}
	
	static <T extends Number> void gPrintA(List<T> l) {
		for(Number n: l) {
			System.out.println(n);
		}
	}
   
	/*
	 * Note that List<Object> and List<?> are not the same.
	 * You can add any object to List<Object>
	 * but for List<?> you can only add 'null' :). Surprisingly true
	 */
	static void gPrintB(List<?>l) {
		for(Object o : l) {
			System.out.println(o);
		}
	}
	
	static <T> void gPrintM(List<T> l) {
		for(T t : l) {
			System.out.println(t);
		}
	}
	
	static void gPrintC(List<Object> l) {
		for(Object o : l) {
			System.out.println(o);
		}
	}		
	
	static void gPrintD(List l) {
		for(Object o : l) {
			System.out.println(o);
		}
	}
	
	static void getSetList(List<?> l) {
		/*
		 * This statement below won't work because you are trying to assign a 
		 * List<?> element to another List<?> element. Compiler has no way of 
		 * differentiating between the 2 types. But using the helper method
		 * this can be fixed, as seen below.
		 */
		//l.set(0, l.get(1));
		helper1(l);
	}
	
	static <T> void helper1(List<T> l) {
		l.set(0,l.get(1));
	}
	
	static void getSetList2(List<? extends Number> l, List<? extends Number> m) {
		/*
		 * The same is not possible here as we did it above. Helper method won't
		 * work in this case because what I am trying to do is wrong. Compiler
		 * does a good job preventing it.
		 */
		//l.set(0, m.get(0));
		//helper2(l,l);
	}
	static <T> void helper2(List<T> l, List<T> m) {
		
	}
	
	static void tempList(List<? extends Number> l) {
		helper3(l);
	}
	
	static <T> void helper3(List<T> l) {
		T t = l.get(0);
		l.set(1, t);
	}
}
