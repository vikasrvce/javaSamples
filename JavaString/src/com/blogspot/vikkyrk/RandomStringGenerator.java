package com.blogspot.vikkyrk;

import java.util.Random;

public class RandomStringGenerator {
    private static final int MIN_LENGTH = 1;
	public static String generateRandomString(int maxLength, int range) {
		Random randGen = new Random();
		
		int length = randGen.nextInt(maxLength+1) + MIN_LENGTH;
		
		char[] buf = new char[length];
		for(int i=0; i<length; i++) {
			buf[i] = (char) (randGen.nextInt(range) + 97);
		}
		return new String(buf);
	}
}
