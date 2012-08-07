package com.blogspot.vikkyrk;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class myProcessBuilder {
	public static void command(String s) {
		boolean err = false;
		try {
			Process process = new ProcessBuilder(s.split(" ")).start();
			BufferedReader results = new BufferedReader(
					new InputStreamReader(process.getInputStream()));
			String sStr = null;
			while((sStr = results.readLine()) != null) {
				System.out.println(sStr);
			}
			
			BufferedReader errorResults = new BufferedReader(
					new InputStreamReader(process.getErrorStream()));
			
			while((sStr = errorResults.readLine()) != null) {
				System.out.println(sStr);
				err = true;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		if(err) {
			throw new RuntimeException("OSExecution Error");
		}
	}

}
