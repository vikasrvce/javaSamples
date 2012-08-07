package com.blogspot.vikkyrk;

public class InnerClassTest {

	/**
	 * @param args
	 */
	public String ss = null;
	
	public String setString() {
		ss = new String("hello");
		return ss;
	}
	public static void main(String[] args) {
		mySequence stringSeq = new mySequence(10);
		
		stringSeq.add("Vikas");
		stringSeq.add("Vinyas");
		stringSeq.add("Shobha");
		stringSeq.add("Ramesh");
		stringSeq.add("Amit");
		
		stringSeq.remove();
		
		mySelectorInterface mIter = stringSeq.getSelector();
		
		while(mIter.hasNext()) {
			System.out.println(mIter.next());
		}
		
		final InnerClassTest ms = new InnerClassTest();
		ms.ss = new String("Vikas");
		mySelectorInterface mIter2 = new mySelectorInterface() {
			public String next() {
				return ms.setString();
			}
			
			public String peek() {
				return new String("Hello");
			}
			
			public boolean hasNext() {
				return true;
			}
		};
		
		System.out.println(mIter2.next());
		
		AnonymousInnerClass an = new AnonymousInnerClass();
		
		String abc = new String("abc");
		
		System.out.println(an.getSelector(abc).next());
		
		an.setString();
	}
}
