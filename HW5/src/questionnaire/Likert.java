package questionnaire;

/**
 * Likert class.
 */
public class Likert implements Question {
  private String prompt;
  private boolean requirements;
  private String answer;
  
  
  /**
   * Constructor of the Likert class.
   * @param prompt prompt of the question
   * @param requirements required or not
   */
  public Likert(String prompt, boolean requirements) {
    if (prompt == null) {
      throw new IllegalArgumentException("Prompt cannot be null");
    }
    this.prompt = prompt;
    this.requirements = requirements;
    this.answer = null; //set to null for default.
  }
  
  /**
   * Getter of the prompt.
   * @return prompt.
   */
  @Override
  public String getPrompt() {
    return this.prompt;
  }
  
  /**
   * Check if required or not.
   * @return true or false.
   */
  @Override
  public boolean isRequired() {
    return this.requirements;
  }
  
  /**
   * Checking the answer ignoring any cases. Also, check the answer in the LikerResponseOption and
   * also use getText method to get text.
   * @param answer answer.
   */
  @Override
  public void answer(String answer) {
    if (answer == null) {
      throw new IllegalArgumentException("Your answer cannot be null");
    }
    boolean match = false;
    for (LikertResponseOption options: LikertResponseOption.values()) {
      if (options.getText().equalsIgnoreCase(answer.trim())) {
        this.answer = answer.trim();
        match = true;
        break; //in order to exit if fulfil the "if" statement.
      }
    }
    if (!match) {
      throw new IllegalArgumentException("Invalid answer!");
    }
  }
  
  /**
   * Getter method for answer.
   * @return answer
   */
  @Override
  public String getAnswer() {
    if (this.answer != null) {
      return answer;
    } else {
      return "";
    }
  }
  
  /**
   * Copy method for copying the question including all data.
   * @return copy of the question.
   */
  @Override
  public Question copy() {
    Likert copy = new Likert(this.prompt, this.requirements);
    if (this.answer != null) {
      copy.answer(getAnswer());
    }
    return copy;
  }
}
