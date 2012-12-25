package com.blogspot.vikkyrk;

import java.util.ArrayList;

public class StringFunctions {
	public static void reverseString(String input) {
		if(input == null || input.length() < 2)
			return;
		
		log("Input: " + input);
		char[] str = input.toCharArray();
		reverseCharacterArray(str,0,str.length-1);
		
		StringBuffer sb = new StringBuffer(input);
		String output = new String(str);
		log("Output: " + output);
		assert sb.reverse().toString().equals(output) : "Strings don't match";
	}
	
	public static void reverseCharacterArray(char[] inputCh, int start, int end) {
		int len = end-start;
		log("ChArray Reverse: st="+start+", end="+end+", len"+len);

		if(inputCh == null)
			return;
		
		if(start < 0 || end >= inputCh.length || (start>end))
			throw new IllegalArgumentException("Invalid start or end index");
		
		for(int i=0; i<(len+1)/2; i++) {
			inputCh[start+i] = (char) (inputCh[start+i] ^ inputCh[start+len-i]);
			inputCh[start+len-i] = (char) (inputCh[start+i] ^ inputCh[start+len-i]);
			inputCh[start+i] = (char) (inputCh[start+i] ^ inputCh[start+len-i]);
		}
	}
	
	/*
	 * The Java way
	 */
	public static void reverseWords(String inputStr) {
		if(inputStr == null || inputStr.isEmpty())
			return;
		
		log("input: " + inputStr);
		String[] res = inputStr.split("\\s+");
		StringBuilder sb = new StringBuilder();

		for(int i=res.length-1; i>=0; i--) {
			sb.append(res[i]);
			if(i!=0)
				sb.append(" ");
		}
		log("Output: " + sb);
	}

	/*
	 * The C way is to reverse the whole string, and then reverse
	 * the individual words
	 */
	
	public static void reverseWordsInPlace(String inputStr) {
		char[] inputCh = inputStr.toCharArray();
		
		reverseCharacterArray(inputCh,0,inputCh.length -1);
		
		log("Input:" + new String(inputCh));
		
		int st = 0, end = 0;
		for(int i=0; i<inputCh.length; i++) {
			if(inputCh[i] == ' ') {
				log("St = " + st + ", End = " + end);
				if(end > st) {
					reverseCharacterArray(inputCh,st,end-1);
					log("Input:" + new String(inputCh));
				}
				while(++i < inputCh.length) {
					if(inputCh[i] == ' ')
						continue;
					
					st = i;
					end = i;
					break;
				}
			}
			end++;
		}
		
		if(inputCh[end-1] != ' ') {
			reverseCharacterArray(inputCh,st,end-1);
		}
		
		log("output:" + new String(inputCh));
	}
	
	public static int strCmp(String iStr1, String iStr2) {

		if(iStr1 == null || iStr2 == null)
			throw new IllegalArgumentException("Null Argument not permitted\n");
		
		if(iStr1.isEmpty() || iStr2.isEmpty())
			return 0;
		
		char[] iCh1 = iStr1.toCharArray();
		char[] iCh2 = iStr2.toCharArray();
		int i = 0;
		
		while( (i < iCh1.length) && (i < iCh2.length) &&
			   (iCh1[i] == iCh2[i++]) );
		
		return ((iCh1[i-1] == iCh2[i-1]) ? 0 : (iCh1[i-1] > iCh2[i-1] ? 1 : -1));
	}
	
	
	public static void printAllPermutations(String str) {
		if(str == null)
			return;
		printAllPermutations(str,"");
	}
	
	private static void printAllPermutations(String str, String print) {
		if(str.length() == 0) {
			log("v" + print);
			return;
		}
		for(int i=0; i<str.length(); i++) {
			printAllPermutations(str.substring(0,i) + str.substring(i+1,str.length()), print + str.charAt(i));
		}
	}
	
	public static void printAllInterleavings(String str1, String str2) {
		if(str1 == null && str2 == null)
			return;
		if(str1 == null) {
			log("" + str2);
			return;
		} else if(str2 == null) {
			log("" + str1);
			return;
		}
		
		printAllInterleavings(str1,str2,"");
	}
	
	private static void printAllInterleavings(String str1, String str2, String print) {
		if(str1.length()==0 && str2.length()==0) {
			log("" + print);
			return;
		}
		
		if(str1.length() != 0) {
			printAllInterleavings(str1.substring(1), str2, print + str1.charAt(0));
		}
		
		if(str2.length() != 0) {
			printAllInterleavings(str1, str2.substring(1), print + str2.charAt(0));
		}
	}
	
	public static String encodeString(String s) {
		if(s == null)
			throw new RuntimeException("Null String not allowed");
		
		if(s.length() <= 2)
			return s;
		
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		char last = s.charAt(0);
		for(int i=1; i<s.length(); i++) {
			if(last == s.charAt(i)) 
				cnt++;
			else {
				sb.append(last);
				if(cnt > 1)
					sb.append(cnt);
				cnt = 1;
				last = s.charAt(i);
			}
		}
		
		sb.append(last);
		if(cnt > 1)
			sb.append(cnt);
		
		if(sb.length() < s.length())
			return new String(sb);
		else
			return s;
	}
 	
	private static void log(String msg) {
		System.out.println(msg);
	}
}
