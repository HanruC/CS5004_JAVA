package cs5004.collections;

import java.util.Objects;

public class ListPriorityQueue implements PriorityQueue {
  private PriorityQueueNode head;
  
  public ListPriorityQueue() {
    this.head = new EmptyNode();
  }
  
  private ListPriorityQueue(PriorityQueueNode head) {
    this.head = head;
  }
  // Creates an empty priority queue.
  // insert an empty node to the head of the list.
  // Returns a new empty priority queue.
  public static PriorityQueue createEmpty() {
    return new ListPriorityQueue();
  }
  
  // Checks if the priority queue is empty. Returns true if the PQ is empty, false otherwise.
  @Override
  public Boolean isEmpty() {
    return this.head instanceof EmptyNode;
  }
  
  @Override
  public PriorityQueue add(Integer priority, String value) throws IllegalArgumentException {
    if (priority < 1 || priority > 10) {
      throw new IllegalArgumentException("Priority should be in the range of 1-10.");
    }
    if (isEmpty()) {
      return new ListPriorityQueue(new ElementNode(priority, value, new EmptyNode().copy()));
    }
    return new ListPriorityQueue(this.head.add_Node(priority, value).copy());
  }
  
  
  @Override
  public String peek() throws EmptyPriorityQueueException {
    if (isEmpty()) throw new EmptyPriorityQueueException();
    return this.head.getValue();
  }
  
  @Override
  public PriorityQueue pop() throws EmptyPriorityQueueException {
    if (isEmpty()) throw new EmptyPriorityQueueException();
    return new ListPriorityQueue(this.head.getNext().copy());
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    PriorityQueueNode current = this.head;
    while (current instanceof ElementNode) {
      ElementNode currentNode = (ElementNode) current;
      sb.append("(").append(currentNode.getPriority())
              .append(", ").append(currentNode.getValue()).append(") ");
      current = currentNode.getNext();
    }
    return sb.toString();
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    ListPriorityQueue other = (ListPriorityQueue) obj;
    PriorityQueueNode thisNode = this.head;
    PriorityQueueNode otherNode = other.head;
    while (thisNode != null && otherNode != null) {
      if (!thisNode.getPriority().equals(otherNode.getPriority()) || !thisNode.getValue().equals(otherNode.getValue())) {
        return false;
      }
      thisNode = thisNode.getNext();
      otherNode = otherNode.getNext();
    }
    return thisNode == null && otherNode == null;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(head);
  }
}
