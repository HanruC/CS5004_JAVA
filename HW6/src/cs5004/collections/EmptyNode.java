package cs5004.collections;

public class EmptyNode implements PriorityQueueNode {
  
  @Override
  public PriorityQueueNode add_Node(Integer priority, String value) throws IllegalArgumentException {
    if (priority < 1 || priority > 10) {
      throw new IllegalArgumentException("Priority should be in the range of 1-10.");
    }
    return new ElementNode(priority, value, this);
  }
  
  @Override
  public Integer getPriority() {
    return 0;
  }
  
  @Override
  public String getValue() {
    return null;
  }
  
  @Override
  public PriorityQueueNode getNext() {
    return null;
  }
  
  @Override
  public PriorityQueueNode copy() {
    return new EmptyNode();
  }
}
