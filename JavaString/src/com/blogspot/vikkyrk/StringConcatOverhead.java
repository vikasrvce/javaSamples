package com.blogspot.vikkyrk;

public class StringConcatOverhead {
	@SuppressWarnings("unused")
	public static void testRun () {
		int size = 10000;
		long t1, t2;

		t1 = System.currentTimeMillis();
		String s1 = test1(size);
		t2 = System.currentTimeMillis();
		System.out.println(" Computing time: " + (t2-t1) + " millisec");


		t1 = System.currentTimeMillis();
		String s2 = test2(size);
		t2 = System.currentTimeMillis();
		s2=null;
		System.out.println(" Computing time: " + (t2-t1) + " millisec");
	}

	private static String test1(int size)
	{
		String str = new String();

		for(int i = 0; i < size; i++)
			str = str + i + "a";

		return str;
	}

	private static String test2(int size)
	{
		StringBuffer sb = new StringBuffer();

		for(int i = 0; i < size; i++)
			sb.append(i +"a");

		return new String( sb );
	}
}
