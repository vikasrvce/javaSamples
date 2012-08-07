package com.blogspot.vikkyrk;

import java.util.Iterator;

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
			temp = getNode(index);
		}

		temp.next = new iNode(t,temp.next);
		size++;
	}
	
	public T remove(int index) {
		iNode temp = getNode(index);
		T t = temp.next.value;
		temp.next = temp.next.next;
		size--;
		return t;
	}
	
	private iNode getNode(int index) {
		if(index < 0 || index >= size()) {
			throw new IllegalArgumentException();
		}
		int i = 0;
		iNode temp = head;
		
		while(i!=index) {
			temp = temp.next;
			i++;
		}
		return temp;
	}
	
	public void set(T t, int index) {
		getNode(index).next.value = t;
	}
	
	public T get(int index) {
		return(getNode(index).next.value);
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

}
