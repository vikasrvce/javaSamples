package com.blogspot.vikkyrk;

public class StringCreateOverhead {
	
	public static void testRun() {
		
		int size = 200000;
		long t1, t2;

		t1 = System.currentTimeMillis();
		test1(size);
		t2 = System.currentTimeMillis();
		System.out.println(" Computing time: " + (t2-t1) + " millisec");


		t1 = System.currentTimeMillis();
		test2(size);
		t2 = System.currentTimeMillis();
		System.out.println(" Computing time: " + (t2-t1) + " millisec");
	}
	
	private static void test1(int size)
	{
		String[] str = new String[size];;

		for(int k = 0; k < size; k++)
			str[k] = new String("a");
	}

	private static void test2(int size)
	{
		String[] str = new String[size];;

		for(int k = 0; k < size; k++)
			str[k] = "a";
	}
}
