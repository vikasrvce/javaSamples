package com.blogspot.vikkyrk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		File file = new File("/home/vikasrk/Desktop/Sample.txt");
		FileInputStream fileInputStream = null;
		FileReader fileReader = null;
		InputStreamReader inputStreamReader = null;
	    System.out.println(file.exists());

	    try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	    
	    byte[] b = new byte[10];
	    try {
			fileInputStream.read(b);
		} catch (IOException e1) {
			System.out.println("fileInputStream read exception");
		}
	    
	    try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	    
	    inputStreamReader = new InputStreamReader(fileInputStream);
	    
	    myProcessBuilder.command("pwd");
	    
	}

}
