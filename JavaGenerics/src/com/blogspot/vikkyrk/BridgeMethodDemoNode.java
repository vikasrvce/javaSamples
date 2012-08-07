package com.blogspot.vikkyrk;

public class BridgeMethodDemoNode<T> {
	private T data;
	
	public BridgeMethodDemoNode(T data) {
		this.data = data;
	}
	
	public void setData(T data) {
		System.out.println("Setting Data");
		this.data = data;
	}
}
