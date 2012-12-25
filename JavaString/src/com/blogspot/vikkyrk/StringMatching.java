package com.blogspot.vikkyrk;

import java.util.List;
import java.util.LinkedList;

/*
 * Match all occurrences of pattern in the text
 */
public class StringMatching {

	public static List<Integer> bruteForceMatch(String text, String pattern) {
		List<Integer> res = new LinkedList<Integer>();
		
		if(text == null || pattern == null || 
		   text.length() == 0 || pattern.length() == 0 ||
		   pattern.length() > text.length())
			return res;
			
		int nIter = text.length() - pattern.length();

		for(int i=0; i<=nIter; i++) {
			int j = 0;
			while(j<pattern.length() &&
					text.charAt(i+j) == pattern.charAt(j)) {
				j++;
			}
			
			if(j == pattern.length())
				res.add(i);
		}
		return res;
	}
	
	//http://www.inf.fh-flensburg.de/lang/algorithmen/pattern/kmpen.htm
	/*
	 * The above link has a good explanation of KMP
	 * Find maximum suffix that is equal to the prefix, 
	 * for each prefix of the pattern.
	 */
	public static List<Integer> kmpMatch(String text, String pattern) {
		List<Integer> res = new LinkedList<Integer>();
		
		if(text == null || pattern == null || 
		   text.length() == 0 || pattern.length() == 0 ||
		   pattern.length() > text.length())
			return res;
	
		int[] next = new int[pattern.length()+1];
		findNext(next,pattern);
		
		int j=0, i=0;
		while(i<text.length()) {
			while(j>=0 && text.charAt(i) != pattern.charAt(j))
				j = next[j];
			i++;
			j++;
			if(j == pattern.length()) {
				res.add(i-pattern.length());
				j = next[j];
			}
		}
		return res;
	}
	
	private static void findNext(int[] next, String pattern) {
		int j = -1, i=0;
		next[i] = j;
		while(i<pattern.length()) {
			while(j>=0 && pattern.charAt(i) != pattern.charAt(j))
				j = next[j];
			i++;
			j++;
			next[i] = j;
		}
	}
	
	private static void log(String msg) {
		System.out.println(msg);
	}
}
