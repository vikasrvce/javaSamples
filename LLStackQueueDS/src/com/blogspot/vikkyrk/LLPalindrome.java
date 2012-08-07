package com.blogspot.vikkyrk;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LLPalindrome implements myRun {

	private List<Integer> ll = new LinkedList<Integer>();
	@Override
	public void run() {
		generateManualInput();
		System.out.println(isPalindrome1());
		System.out.println(isPalindrome2(ll));
	}
	
	public void generateManualInput() {
		//ll = Arrays.asList(1,2,3,4,5,5,4,3,2,1);
		ll = Arrays.asList();
	}
	public boolean isPalindrome1() {
		Integer[] tempArr = (Integer[]) ll.toArray();
		int l = 0, r = tempArr.length-1;
		
		while(l<r) {
			if(!tempArr[l++].equals(tempArr[r--]))
				return false;
		}
		return true;
	}
	
	//This is for a doubly LL. See below for Singly LL
	public static <T> boolean isPalindrome2(List<T> ll) {
		ListIterator<T> fIter = ll.listIterator();
		ListIterator<T> bIter = ll.listIterator(ll.size());
		
		for(int i=0,mid = (ll.size() >> 1);i<mid;i++) {
			if(!fIter.next().equals(bIter.previous())) {
				return false;
			}
		}
		return true;
	}
	
	/*For a Singly LL
	 * 1. Find the mid of LL by using fast/slow pointers
	 * 2. Reverse the second half of the list
	 * 3. Compare the first half with the second half
	 * 4. Correct the reversed part
	 */
}
