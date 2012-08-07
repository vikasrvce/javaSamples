package com.blogspot.vikkyrk;

public interface myStack<T> {
	public int size();
	public void push(T t);
	public T pop();
	public boolean isEmpty();
	public T peek();
	public void clear();
}
