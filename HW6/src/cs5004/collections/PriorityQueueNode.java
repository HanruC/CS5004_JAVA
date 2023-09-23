package cs5004.collections;

public interface PriorityQueueNode {
  
  public Integer getPriority();
  public String getValue();
  public PriorityQueueNode getNext();
  public PriorityQueueNode add_Node(Integer priority, String value) throws IllegalArgumentException;
  public PriorityQueueNode copy();
  
}
