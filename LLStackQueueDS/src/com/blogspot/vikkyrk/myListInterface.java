package com.blogspot.vikkyrk;

import java.util.Iterator;

public interface myListInterface<T> {
	public void add(T t);
	public void add(T t, int index);
    public T remove(int index);
    public int size();
    public void set(T t, int index);
    public T get(int index);
    public Iterator<T> iterator();
    public Iterator<T> iterator(int index);
}
