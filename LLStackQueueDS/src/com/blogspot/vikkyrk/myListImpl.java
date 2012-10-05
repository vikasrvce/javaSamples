package com.blogspot.vikkyrk;

import java.util.Iterator;
import java.util.Random;

public class myListImpl<T> implements myListInterface<T> {
	
	private class iNode {
		private T value;
		private iNode next;
		
		public iNode(T t, iNode n) {
			value = t;
			next = n;
		}
	}
	
	private iNode head = new iNode(null,null);
	private int size = 0;
	
	public void add(T t) {
		add(t,0);
	}
	
	public void add(T t, int index) {
		if(t == null) {
			throw new NullPointerException();
		}
		
		iNode temp = head;
		if(index != 0) {
			temp = getNode(index-1);
		}

		temp.next = new iNode(t,temp.next);
		size++;
	}
	
	public T remove(int index) {
		
		iNode temp = head;
		if(index != 0) {
			temp = getNode(index-1);
		}
		T t = temp.next.value;
		temp.next = temp.next.next;
		size--;
		return t;
	}
	
	private iNode getNode(int index) {
		if(index < 0 || index > size()) {
			throw new IllegalArgumentException();
		}
		int i = -1;
		iNode temp = head;
		
		while(i!=index) {
			temp = temp.next;
			i++;
		}
		return temp;
	}
	
	public void set(T t, int index) {
		getNode(index).value = t;
	}
	
	
	public T get(int index) {
		return(getNode(index).value);
	}
	
	public int size() {
		return size;
	}
	
	public void printList() {
		System.out.println("Size = " + size());
		iNode temp = head.next;
		while(temp != null) {
			System.out.print(temp.value +", ");
			temp = temp.next;
		}
		System.out.println("");
	}
	
	public Iterator<T> iterator() {
		return iterator(0);
	}
	
	public Iterator<T> iterator(int index) {
		return new myListIter(index);
	}
	
	private class myListIter implements Iterator<T> {
		
		iNode current = null;
				
		public myListIter(int index) {
			current = getNode(index);
		}
		
		public boolean hasNext() {
			return(!(current.next == null));
		}
		
		public T next() {
			if(!hasNext()) {
				throw new NullPointerException();
			}
			current = current.next;
			return current.value;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	/*
	 * Miscellaneous List Algorithms 
	 */
	
	public void generateRandomLoop() {
		if(size == 0)
			return;
		
		Random randomGen = new Random();
		int a, b;
		
		a = randomGen.nextInt(size);
		b = randomGen.nextInt(size);

		if(a == size)
			a--;
		if(b == size)
			b--;
		System.out.println("Creating loop between index"+a + ", index"+b);

		iNode NodeA = getNode(a);
		iNode NodeB = getNode(b);
		
		if(a > b)
			NodeA.next = NodeB;
		else
			NodeB.next = NodeA;
		
	}
	
	public boolean hasLoop() {
		
		if(size == 0) 
			throw new NullPointerException();
		
		iNode slowRef = head;
		iNode fastRef = head;
		
		while(true) {
			slowRef = slowRef.next;
			
			if(fastRef.next != null) 
				fastRef = fastRef.next.next;
			else
				return false;
			
			if(slowRef == fastRef)
				return true;
			else if(fastRef == null)
				return false;
		}
	}
	
	public int getLoopStartIndex() {
		if(!hasLoop())
			return -1;

		iNode slowRef = head;
		iNode fastRef = head;
		
		while(true) {
			slowRef = slowRef.next;
			fastRef = fastRef.next.next;
			if(slowRef == fastRef)
				break;
		}

		slowRef = head;
		int cnt = -1;
		while(slowRef != fastRef) {
			cnt++;
			slowRef = slowRef.next;
			fastRef = fastRef.next;
		}
		
		return cnt;
	}
	
	
}
