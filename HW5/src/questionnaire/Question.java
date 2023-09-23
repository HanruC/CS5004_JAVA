package questionnaire;

/**
 * Question interface.
 */
public interface Question {
  
  /**
   * Get prompt of the question.
   * @return prompt
   */
  String getPrompt();
  
  /**
   * Get the requirement.
   * @return true or false
   */
  boolean isRequired();
  
  /**
   * Check the answer ignoring any cases and with some restrictions.
   * @param answer answer.
   */
  void answer(String answer);
  
  /**
   * Get the answer of the question.
   * @return the answer.
   */
  String getAnswer();
  
  /**
   * Copy the constructor.
   * @return copy
   */
  Question copy();
}
