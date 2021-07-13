package org.ds.algos.datastructures.linkedlist;

import org.ds.algos.datasructures.node.Node;

public class LinkedList<E> implements LinkInterface<E> {

	private Node<E> head;
	private Node<E> tail;
	private int size;

	public void removeData(E key) {		
		if(this.size == 0) {
			System.out.println("List is empty");
			return;
		}

		if(this.head.getData().equals(key)) {
			Node<E> node = this.head;
			this.head = this.head.getNext();
			node = null;
		} else {

			Node<E> start = this.head;
			while(start != null) {
				if(start.getData().equals(key)) {

					break;
				}
			}
		}
	}

	public void addAtBeginning(E data) {
		if(this.head == null) {
			this.head = new Node<E>(data);
			this.tail = this.head;
		} else {
			Node<E> temp = new Node<E>(data);
			temp.setNext(this.head);
			this.head = temp;
		}
		this.size++;

	}

	public void addAtEnd(E data) {
		if(this.tail == null) {
			this.tail = new Node<E>(data);
			if(this.head == null) {
				this.head = this.tail;
			}
		} else {
			Node<E> temp = new Node<E>(data);
			this.tail.setNext(temp);
			this.tail = temp;
		}
		this.size++;
	}

	public void addAtIndex(E data, int index) {

		if(this.head == null) {
			System.out.println(" List is empty, insert at beginning.");
			addAtBeginning(data);
			return;
		} else if (index > size) {
			System.out.println(" Index is greater than current size of list, insert at end.");
			addAtEnd(data);
			return;
		}

		if(index < 0 ) {
			throw new IllegalArgumentException("Invalid insertion position specified.");
		}

		Node<E> pivot = this.head;
		for(int i = 0; i < index; i++) {
			pivot = pivot.getNext();
		}

		if(pivot != null) {
			Node<E> temp = new Node<E>(data);
			temp.setNext(pivot.getNext());
			pivot.setNext(temp);
		}

		this.size++;
	}

	public void printElements() {
		if(isEmpty()) { return; }

		Node<E> temp = this.head;

		while(temp != null) {
			System.out.println(temp.getData() + " ");
			temp = temp.getNext();
		}
		System.out.println("\n");
	}

	public void removeAtBeginning() {
		if(isEmpty()) { return; }

		Node<E> next = this.head.getNext();

		this.head.setNext(null);//help GC
		this.head.setData(null);

		this.head = next;
		if(next == null) 
			this.tail = null;

		this.size--;
	}

	public void removeAtEnd() {
		if(isEmpty()) { return; }

		Node<E> temp = this.head;
		Node<E> previous = this.head;
		while(temp.getNext() != null) {			
			previous = temp;
			temp = temp.getNext();
		}

		if(previous == this.head && previous.getNext() == null) {
			previous = this.head = this.tail = null;
		} else {
			previous.setNext(null);
			this.tail = previous;
		}
		this.size--;
	}

	public void removeAtIndex(int index) {
		if(isEmpty()) { return; }

		if(index < 0 || index >= this.size) {
			throw new IllegalArgumentException(" Bad index.");
		} else if(index == 0) {
			removeAtBeginning();
			return;
		} else if(index == (size-1)) {
			removeAtEnd();
			return;
		}

		Node<E> temp = this.head;
		Node<E> prev = this.head;
		short counter=0;		
		while(!(counter >= index) || temp.getNext() != null) {
			prev = temp;
			temp = temp.getNext();
			counter++;
		}



		prev.setNext(temp.getNext());		
		if(temp.getNext() == null) {
			this.tail = prev;
		}

		temp.setNext(null);
		temp.setData(null);
		temp = null;

		this.size--;
	}


	public int size() {
		return this.size;
	}


	private boolean isEmpty() {
		if(this.head == null || this.size == 0) {
			System.out.println(" List is empty.");
			return true;
		}
		return false;
	}
}
