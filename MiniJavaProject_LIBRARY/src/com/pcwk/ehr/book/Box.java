package com.pcwk.ehr.book;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {

	private List<T> listBox = new ArrayList<T>();
	
	public Box() {}

	public List<T> getListBox() {
		return listBox;
	}

	public void setListBox(List<T> listBox) {
		this.listBox = listBox;
	}
	
	public void add(T item) {
		this.listBox.add(item);
	}
	
	public T get(int index) {
		return this.listBox.get(index);
	}

	@Override
	public String toString() {
		return "Box [listBox=" + listBox + "]";
	}
	
	
	
}
