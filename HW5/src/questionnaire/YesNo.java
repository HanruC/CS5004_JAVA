package questionnaire;

/**
 * Yes or No class implements Question interface.
 */
public class YesNo implements Question {
  private String prompt;
  private boolean requirements;
  private String answer;
  
  /**
   * Constructor of the class.
   * @param prompt prompt of the question
   * @param requirements required or not
   */
  public YesNo(String prompt, boolean requirements) {
    if (prompt == null) {
      throw new IllegalArgumentException("Prompt cannot be null.");
    }
    this.prompt = prompt;
    this.requirements = requirements;
    this.answer = "";
  }
  
  
  /**
   * Getter method for prompt.
   * @return prompt
   */
  @Override
  public String getPrompt() {
    return this.prompt;
  }
  
  /**
   * Getter for requirement.
   * @return true or false
   */
  @Override
  public boolean isRequired() {
    return this.requirements;
  }
  
  /**
   * Check the answer ignoring any different cases.
   * @param answer answer of input.
   */
  @Override
  public void answer(String answer) {
    if (answer == null) {
      throw new IllegalArgumentException("Answer cannot be null.");
    }
    if (answer.trim().equalsIgnoreCase("yes")
            || answer.trim().equalsIgnoreCase("no")) {
      this.answer = answer.trim();
      // trim() for deleting the spaces.
    } else {
      throw new IllegalArgumentException("Invalid answer");
    }
  }
  
  /**
   * Getter method for the answer.
   * @return the answer.
   */
  @Override
  public String getAnswer() {
    return this.answer;
  }
  
  /**
   * Get a copy of constructor of all data.
   * @return copy.
   */
  @Override
  public Question copy() {
    YesNo copy = new YesNo(this.prompt, this.requirements);
    copy.answer(getAnswer());
    return copy;
  }
}
