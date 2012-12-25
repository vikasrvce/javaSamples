package com.blogspot.vikkyrk;

import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

//@SuppressWarnings("unused")
public class mainTest {
	public static void main(String[] args) {
		
		//StringCreateOverhead.testRun();
		//StringConcatOverhead.testRun();
		
		/*for(int i=0; i<10; i++) {
			StringFunctions.reverseString(RandomStringGenerator.generateRandomString(10,26));
		}*/
		
		//StringFunctions.reverseWordsInPlace(" HaWJva ");
		//log("StrCmp:" + StringFunctions.strCmp("abcdefg", "abcdef"));
		
		
		/* ***************  String Matching ***************************/
	    
		/*	
	    log("StrMatch:" + StringMatching.kmpMatch("babbabb", "babb"));
		log("StrMatch:" + StringMatching.kmpMatch("abbacccaaabcaa", "b"));
		log("StrMatch:" + StringMatching.kmpMatch("bbaaabbbbbabbbabbba", "bbabbb"));
		stringMatchTest();*/
		
		//StringFunctions.printAllPermutations("abcde");
		//StringFunctions.printAllInterleavings("abc", "def");
		
		String s = RandomStringGenerator.generateRandomString(11, 3);
		log("Act:" + s + ", StrEncode : " + StringFunctions.encodeString(s));
	}
	
	private static void stringMatchTest() {
		String text = null;
		String pattern = null;
		List<Integer> strMatchBruteForce = null;
        List<Integer> strMatchKMP = null;
        
		for(int i=0; i<10000; i++) {
			text = RandomStringGenerator.generateRandomString(20, 2);
			pattern = RandomStringGenerator.generateRandomString(5, 2);
			
			if(pattern.length() > text.length())
				continue;
			log("Text: " + text);
			log("Pattern: " + pattern);
			
			strMatchBruteForce = StringMatching.bruteForceMatch(text, pattern);
			strMatchKMP = StringMatching.kmpMatch(text, pattern);
			log("StrMatch: " + strMatchBruteForce );
			log("StrMatchKMP: " + strMatchKMP);
			
			Iterator<Integer> bfIter = strMatchBruteForce.iterator();
			
			if(strMatchBruteForce.size() != strMatchKMP.size())
				throw new RuntimeException("Lengths did not match");
			
			for(Integer k: strMatchKMP) {
				if(!k.equals(bfIter.next()))
					throw new RuntimeException("Results did not match");
			}
		}
	}
	
	private static void log(String msg) {
		System.out.println(msg);
	}
}
