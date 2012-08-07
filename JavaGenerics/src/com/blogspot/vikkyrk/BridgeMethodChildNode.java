package com.blogspot.vikkyrk;

public class BridgeMethodChildNode extends BridgeMethodDemoNode<Integer> {
	public BridgeMethodChildNode(Integer data) {
		super(data);
	}
	
	public void setData(Integer data) {
		System.out.println("Child Setting data");
		super.setData(data);
	}

}
