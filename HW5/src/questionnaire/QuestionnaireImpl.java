package questionnaire;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * QuestionnaireImpl class which implements Questionnaire interface.
 */
public class QuestionnaireImpl implements Questionnaire {
  private List<Question> questions;
  private Map<String, Question> questionMap;
  
  /**
   * Constructor of the class which creating two new things: Array list and hashmap.
   */
  public QuestionnaireImpl() {
    this.questions = new ArrayList<>();
    this.questionMap = new HashMap<>(); // store identifier and question.
  }
  
  /**
   * Adding question to hashmap and array list.
   * @param identifier a name for the question <b>unique</b> within this questionnaire. Not null
   *                   or empty.
   * @param q the {@link Question} to be added to the questionnaire
   */
  @Override
  public void addQuestion(String identifier, Question q) throws IllegalArgumentException {
    if (identifier == null || identifier.isEmpty()) {
      throw new IllegalArgumentException("Identifier should not be null or empty");
    }
    if (q == null) {
      throw new IllegalArgumentException("Question cannot be null");
    }
    if (questionMap.containsKey(identifier)) {
      throw new IllegalArgumentException("Identifier is not unique");
    }
    questionMap.put(identifier, q);
    questions.add(q);
  }
  
  /**
   * Remove question from hashmap and array list.
   * @param identifier the identifier of the question to be removed.
   */
  @Override
  public void removeQuestion(String identifier) throws IllegalArgumentException,
          NoSuchElementException {
    if (identifier == null) {
      throw new IllegalArgumentException("Identifier cannot be null");
    }
    Question q = questionMap.remove(identifier);
    if (q == null) {
      throw new NoSuchElementException("Nothing corresponding to this identifier " + identifier);
    }
    questions.remove(q);
  }
  
  /**
   * Get question by having the question number.
   * @param num the number of the question, counting from 1
   * @return the question targeted.
   */
  @Override
  public Question getQuestion(int num) throws IndexOutOfBoundsException {
    if (num < 1 || num > this.questions.size()) {
      throw new IndexOutOfBoundsException("Invalid question number.");
    }
    return this.questions.get(num - 1);
  }
  
  /**
   * Get question with given identifier.
   * @param identifier the identifier of the question
   * @return question targeted.
   */
  @Override
  public Question getQuestion(String identifier) throws IllegalArgumentException,
          NoSuchElementException {
    if (identifier == null) {
      throw new IllegalArgumentException("Identifier cannot be null");
    }
    if (!questionMap.containsKey(identifier)) {
      throw new NoSuchElementException("No question with this identifier " + identifier);
    }
    return questionMap.get(identifier);
  }
  
  //helper function for getRequiredQuestions and getOptionalQuestions.
  private List<Question> filteredQuestions(Predicate<Question> predicate) {
    return this.questions.stream().filter(predicate).collect(Collectors.toList());
  }
  
  /**
   * Get list of required questions.
   * @return list of question
   */
  @Override
  public List<Question> getRequiredQuestions() {
    return filteredQuestions(Question::isRequired);
  }
  
  /**
   * Get list of optional questions.
   * @return list of question
   */
  @Override
  public List<Question> getOptionalQuestions() {
    return filteredQuestions(q -> !q.isRequired());
  }
  
  /**
   * Check if the question that is required is completed.
   * @return true or false
   */
  @Override
  public boolean isComplete() {
    return this.questions.stream().filter(Question::isRequired)
            .noneMatch(q -> q.getAnswer().isEmpty());
  }
  
  /**
   * Get response from the questions collections.
   * @return list of question
   */
  @Override
  public List<String> getResponses() {
    return this.questions.stream().map(Question::getAnswer).collect(Collectors.toList());
    // use toList method in collect in order to create an unmodifiable list.
  }
  
  /**
   * Filter questionnaire with given predicate.
   * @param pq the predicate
   * @return filtered questionnaire copy.
   */
  @Override
  public Questionnaire filter(Predicate<Question> pq) throws IllegalArgumentException {
    if (pq == null) {
      throw new IllegalArgumentException("Predicate is null");
    }
    //create a copy of questions and store into an unmodifiable list.
    List<Question> filterQ = this.questions.stream().filter(pq)
            .map(Question::copy).collect(Collectors.toList());
    
    QuestionnaireImpl filteredQuestionnaire = new QuestionnaireImpl();
    //create a new instance of QuestionnaireImpl to contain filter questions which fit in the
    // predicate pq.
    for (Question q : filterQ) {
      if (q == null) {
        throw new IllegalArgumentException("Question cannot be null");
      }
      filteredQuestionnaire.addQuestion(q.getPrompt(), q); //store all prompt identifier and the
      // questions that fit in the filter(pq).
    }
    return filteredQuestionnaire; //for returning a copy.
  }
  
  /**
   * Sort the question list.
   * @param comp a comparator for Question
   */
  @Override
  public void sort(Comparator<Question> comp) throws IllegalArgumentException {
    if (comp == null) {
      throw new IllegalArgumentException("Comparator is null");
    }
    List<Question> sortedQ = this.questions.stream().sorted(comp).collect(Collectors.toList());
    this.questions = sortedQ;
  }
  
  /**
   * fold the function by given biFunction.
   * @param bf the folding function
   * @param seed the seed value
   * @param <R> any type
   * @return result.
   */
  @Override
  public <R> R fold(BiFunction<Question, R, R> bf, R seed) throws IllegalArgumentException {
    if (bf == null) {
      throw new IllegalArgumentException("BiFunction cannot be null.");
    }
    R result = seed;
    for (Question q: this.questions) {
      if (q == null) {
        throw new IllegalArgumentException("Question cannot be null.");
      }
      result = bf.apply(q, result);
    }
    return result;
  }
  
  /**
   * Override toString method.
   * @return string.
   */
  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < this.questions.size(); i++) {
      Question q = this.questions.get(i);
      s.append("Question: ").append(q.getPrompt()).append("\n\n")
              .append("Answer: ").append(q.getAnswer());
      if (i < this.questions.size() - 1) {
        s.append("\n\n");
      }
    }
    return s.toString();
  }
  
}
