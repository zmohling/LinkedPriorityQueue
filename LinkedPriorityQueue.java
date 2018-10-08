package zachary.mohling.datastructures;

/**
 * A linked list implementation of the priority queue ADT using Comparable 
 * (Figure 1.0)
 * 
 * @author Zachary Mohling
 */
public final class LinkedPriorityQueue < T extends Comparable < ? super T >> {
	private Node firstNode;
	private int size;

	/**
	 * Creates an empty LinkedPriorityQueue that orders its elements according to their natural ordering. Highest priority being the first in the chain.
	 */
	public LinkedPriorityQueue() {
		firstNode = null;
		size = 0;
	}

	/**
	 * Inserts the specified element into this LinkedPriorityQueue.
	 * (Figures 2.0-2.2)
	 * 
	 * @param newElement the element to add
	 */
	public void push(T newElement) {
		/*
		 * If the Linked Priority Queue (PQ) is empty prior to the method call, add its first element (Node).
		 * (Figure 2.0)
		 */
		if (isEmpty()) {
			Node newNode = new Node(newElement, null);
			firstNode = newNode;
		} else {

			/*
			 * Special Case: If newElement has a higher or equal priority than the first node in the Linked PQ,
			 * insert newElement's Node (newNode) before firstNode.
			 * (Figure 2.1)
			 */
			if (newElement.compareTo(firstNode.getElement()) >= 0) {
				Node newNode = new Node(newElement, firstNode);
				firstNode = newNode;
			}

			/*
			 * Insert newElement's Node (newNode) after currentNode, and move down the chain if and only if 
			 * newElement has a lesser priority than the next Node's element.
			 * (Figure 2.2)
			 */
			else {
				Node currentNode = firstNode;
				Node newNode = new Node(newElement, currentNode.getNextNode());
				currentNode.setNextNode(newNode);

				while (true) {
					if (newNode.getNextNode() == null)
						break;
					else if (newNode.getElement().compareTo(newNode.getNextNode().getElement()) > 0)
						break;
					else {
						currentNode.setNextNode(newNode.getNextNode());
						currentNode = currentNode.getNextNode();

						newNode.setNextNode(currentNode.getNextNode());
						currentNode.setNextNode(newNode);
					}
				}
			}
		}

		size++;
	}

	/**
	 * Retrieves and removes the first element of the LinkedPriorityQueue, or returns null if this LinkedPriorityQueue is empty.
	 * (Figure 3.0)
	 * 
	 * @return the first element of this LinkedPriorityQueue, or null if empty
	 */
	public T pop() {
		if (isEmpty())
			return null;

		T result = firstNode.getElement();
		firstNode = firstNode.getNextNode();
		size--;

		return result;
	}

	/**
	 * Retrieves, but does not remove, the first element of the LinkedPriorityQueue, or returns null if this LinkedPriorityQueue is empty.
	 * @return the first element of this LinkedPriorityQueue, or null if empty
	 */
	public T peek() {
		if (isEmpty())
			return null;
		else
			return firstNode.getElement();
	}

	/**
	 * Returns string representation of the LinkedPriorityQueue in nondecreasing order. If the PQ is empty, return empty brackets "[]".
	 * Example - [-7, 1, 1, 2, 3, 4, 5]   
	 */
	@Override
	public String toString() {
		if (isEmpty())
			return "[]";

		String result = "]";

		Node currentNode = firstNode;

		while (currentNode.getNextNode() != null) {
			result = ", " + currentNode.getElement().toString() + result;
			currentNode = currentNode.getNextNode();
		}

		result = currentNode.getElement().toString() + result;

		result = "[" + result;

		return result;
	}

	/**
	 * Returns the number of elements in this LinkedPriorityQueue.
	 * @return number of elements in this LinkedPriorityQueue
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Removes all elements from this LinkedPriorityQueue.
	 */
	public void clear() {
		firstNode = null;
		size = 0;
	}

	/**
	 * Returns true if the LinkedPriorityQueue contains no elements, false otherwise.
	 * @return true if the LinkedPriorityQueue contains no elements, false otherwise
	 */
	private boolean isEmpty() {
		if (size == 0 || firstNode == null)
			return true;
		else
			return false;
	}

	/**
	 * Node is the primary datatype for LinkedPriorityQueue. A Node is a representation of a link in the chain that is LinkedPriortyQueue.
	 * (Figure 1.1)
	 * 
	 * @author Zachary Mohling
	 * @version 1.0
	 */
	private class Node {
		private T element;
		private Node next;

		/**
		 * Instantiates a new node to be added to the priority queue.
		 * @param elementEntry Element to be stored in the node. The element will determine the node's priority
		 * @param nextNodeEntry Reference to the next node in the chain. Pass in null if this is the last node in the chain
		 */
		private Node(T elementEntry, Node nextNodeEntry) {
			element = elementEntry;
			next = nextNodeEntry;
		}

		private T getElement() {
			return element;
		}

		@SuppressWarnings("unused")
		private void setElement(T elementEntry) {
			element = elementEntry;
		}

		private Node getNextNode() {
			return next;
		}

		private void setNextNode(Node nextNodeEntry) {
			next = nextNodeEntry;
		}
	}
}