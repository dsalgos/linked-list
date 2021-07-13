package org.ds.algos.datastructures.linkedlist;

public interface LinkInterface<T> {	
	
	void addAtBeginning(T data);
	
	void addAtEnd(T data);
	
	void addAtIndex(T data, int index);

	
	void removeAtBeginning();
	
	void removeAtEnd();
	
	void removeAtIndex(int index);
}
