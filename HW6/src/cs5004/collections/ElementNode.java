package cs5004.collections;

public class ElementNode implements PriorityQueueNode {
  private Integer priority;
  private  String value;
  private  PriorityQueueNode next;
  
  
  public ElementNode(Integer priority, String value, PriorityQueueNode next) {
    if (priority < 1 || priority > 10) {
      throw new IllegalArgumentException("Priority should be in the range of 1-10.");
    }
    if (next == null) throw new IllegalArgumentException("Next of list cannot be null");
    if (value == null) throw new IllegalArgumentException("Value cannot be null");
    this.priority = priority;
    this.value = value;
    this.next = next;
  }
  
  @Override
  public Integer getPriority() {
    return this.priority;
  }
  
  @Override
  public String getValue() {
    return this.value;
  }
  
  @Override
  public PriorityQueueNode getNext() {
    return this.next;
  }
  
  /**
   * Adds an element to the PQ.
   *
   * @param priority The element's (non-negative) priority.
   * @param value    The element's value.
   * @return A copy of the priority queue containing the new element.
   */
  @Override
  public PriorityQueueNode add_Node(Integer priority, String value) throws IllegalArgumentException {
    if (priority < 1 || priority > 10) {
      throw new IllegalArgumentException("Priority should be in the range of 1-10.");
    }
    if (priority > this.priority) {
      return new ElementNode(priority, value, this);
    } else {
      return new ElementNode(this.priority, this.value, this.next.add_Node(priority, value));
    }
  }
  
  @Override
  public PriorityQueueNode copy() {
    return new ElementNode(this.priority, this.value, this.next.copy());
  }
}

