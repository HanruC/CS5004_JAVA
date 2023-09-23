package questionnaire;

/**
 * Short answer class which implements the Question interface.
 */
public class ShortAnswer implements Question {
  private String prompt;
  private boolean requirements;
  private String answer;
  
  /**
   * Default constructor.
   * @param prompt prompt of the question.
   * @param requirements require or not.
   */
  public ShortAnswer(String prompt, boolean requirements) {
    if (prompt == null) {
      throw new IllegalArgumentException("Prompt cannot be null.");
    }
    this.prompt = prompt;
    this.requirements = requirements;
    this.answer = "";
  }
  
  /**
   * Getter prompt method.
   * @return this.prompt.
   */
  @Override
  public String getPrompt() {
    return this.prompt;
  }
  
  /**
   * Get if it is required.
   * @return true or false.
   */
  @Override
  public boolean isRequired() {
    return this.requirements;
  }
  
  /**
   * Check the answer ignoring cases. Also having restriction to answer length.
   * @param answer input answer
   */
  @Override
  public void answer(String answer) {
    if (answer == null) {
      throw new IllegalArgumentException("Answer cannot be null");
    }
    if (answer.trim().equalsIgnoreCase(answer)) {
      this.answer = answer;
    }
    if (answer.trim().length() <= 280) {
      this.answer = answer.trim();
    } else {
      throw new IllegalArgumentException("Answer is too long. Please shorten it!");
    }
  }
  
  /**
   * Getter method for answer.
   * @return answer
   */
  @Override
  public String getAnswer() {
    return this.answer;
  }
  
  /**
   * Copy a new question including all data.
   * @return the copy.
   */
  @Override
  public Question copy() {
    ShortAnswer copy = new ShortAnswer(this.prompt, this.requirements);
    if (this.answer != null) {
      copy.answer(getAnswer());
    }
    return copy;
  }
}
