import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

import org.junit.Before;
import org.junit.Test;
import questionnaire.Likert;
import questionnaire.Question;
import questionnaire.Questionnaire;
import questionnaire.QuestionnaireImpl;
import questionnaire.ShortAnswer;
import questionnaire.YesNo;






/**
 * Questionnaire test.
 */

public class QuestionnaireTest {
  
  private Questionnaire questionnaire;
  
  /**
   * Set up.
   */
  @Before
  public void setUp() {
    questionnaire = new QuestionnaireImpl();
  }
  
  /**
   * Test add question and get.
   */
  @Test
  public void testAddQuestionAndGetQuestion() {
    Question q1 = new YesNo("Question 1", true);
    Question q2 = new ShortAnswer("Question 2", true);
    Question q3 = new Likert("Question 3", false);
    
    questionnaire.addQuestion("q1", q1);
    questionnaire.addQuestion("q2", q2);
    questionnaire.addQuestion("q3", q3);
    
    assertEquals(q1, questionnaire.getQuestion("q1"));
    assertEquals(q2, questionnaire.getQuestion("q2"));
    assertEquals(q3, questionnaire.getQuestion("q3"));
  }
  
  /**
   * Test exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddQuestionWithNullIdentifier() {
    questionnaire.addQuestion(null, new YesNo("Question 1", true));
  }
  
  /**
   * Test exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddQuestionWithEmptyIdentifier() {
    questionnaire.addQuestion("", new YesNo("Question 1", true));
  }
  
  /**
   * Test exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddQuestionWithNullQuestion() {
    questionnaire.addQuestion("q1", null);
  }
  
  /**
   * Test exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddQuestionWithDuplicateIdentifier() {
    Question q1 = new YesNo("Question 1", true);
    questionnaire.addQuestion("q1", q1);
    questionnaire.addQuestion("q1", new ShortAnswer("Question 2", true));
  }
  
  /**
   * Test remove.
   */
  @Test
  public void testRemoveQuestion() {
    Question q1 = new YesNo("Question 1", true);
    Question q2 = new ShortAnswer("Question 2", true);
    Question q3 = new Likert("Question 3", false);
    
    questionnaire.addQuestion("q1", q1);
    questionnaire.addQuestion("q2", q2);
    questionnaire.addQuestion("q3", q3);
    
    assertEquals(q2, questionnaire.getQuestion(2));
    questionnaire.removeQuestion("q2");
    assertEquals(q3, questionnaire.getQuestion(2));
    assertEquals(q1, questionnaire.getQuestion(1));
  }
  
  /**
   * Test exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveQuestionWithNullIdentifier() {
    questionnaire.removeQuestion(null);
  }
  
  
  /**
   * Test exception.
   */
  @Test(expected = NoSuchElementException.class)
  public void testRemoveQuestionWithNonexistentIdentifier() {
    questionnaire.removeQuestion("nonexistent");
  }
  
  /**
   * Test get question.
   */
  @Test
  public void testGetQuestion() {
    Question q1 = new YesNo("Question 1", true);
    Question q2 = new ShortAnswer("Question 2", true);
    Question q3 = new Likert("Question 3", false);
    
    questionnaire.addQuestion("q1", q1);
    questionnaire.addQuestion("q2", q2);
    questionnaire.addQuestion("q3", q3);
    
    assertEquals(q1, questionnaire.getQuestion(1));
    assertEquals(q2, questionnaire.getQuestion(2));
    assertEquals(q3, questionnaire.getQuestion(3));
  }
  
  /**
   * Test filter.
   */
  @Test
  public void testFilteredQuestions() {
    QuestionnaireImpl questionnaire = new QuestionnaireImpl();
    Question q1 = new ShortAnswer("What is your name?", true);
    Question q2 = new ShortAnswer("What is your age?", false);
    Question q3 = new ShortAnswer("What is your favorite color?", true);
    questionnaire.addQuestion("name", q1);
    questionnaire.addQuestion("age", q2);
    questionnaire.addQuestion("color", q3);
  
    // Create a filter that only includes required questions
    Questionnaire filteredQuestionnaire = questionnaire.filter(Question::isRequired);
  
    // Check that the filtered questionnaire contains only required questions
    assertEquals(2, filteredQuestionnaire.getRequiredQuestions().size());
    assertEquals(0, filteredQuestionnaire.getOptionalQuestions().size());
  
    // Check that the original questionnaire was not modified
    assertEquals(1, questionnaire.getOptionalQuestions().size());
    assertEquals(2, questionnaire.getRequiredQuestions().size());
  }
  
  /**
   * Test sort.
   */
  @Test
  public void testSort() {
    QuestionnaireImpl questionnaire = new QuestionnaireImpl();
    Question q1 = new ShortAnswer("What is your name?", true);
    Question q2 = new ShortAnswer("What is your age?", false);
    Question q3 = new ShortAnswer("What is your favorite color?", true);
    questionnaire.addQuestion("name", q1);
    questionnaire.addQuestion("age", q2);
    questionnaire.addQuestion("color", q3);
    
    // Create a comparator
    Comparator<Question> comp = (qA, qB) -> qA.getPrompt().compareTo(qB.getPrompt());
    
    // Sort the questions in the questionnaire using the comparator
    questionnaire.sort(comp);
    
    // Check that the questions are now sorted in reverse alphabetical order by prompt
    assertEquals("What is your age?", questionnaire.getQuestion(1).getPrompt());
    assertEquals("What is your favorite color?",
            questionnaire.getQuestion(2).getPrompt());
    assertEquals("What is your name?", questionnaire.getQuestion(3).getPrompt());
  }
  
  /**
   * Test fold.
   */
  @Test
  public void testFold() {
    QuestionnaireImpl questionnaire = new QuestionnaireImpl();
    Question q1 = new ShortAnswer("What is your eye color?", true);
    Question q2 = new ShortAnswer("What is your sister's name?", false);
    Question q3 = new ShortAnswer("What is your favorite sports?", true);
    questionnaire.addQuestion("name", q1);
    questionnaire.addQuestion("age", q2);
    questionnaire.addQuestion("color", q3);
    
    // Create a folding function that concatenates the prompt and answer of each question
    BiFunction<Question, String, String> bf = (q, s) -> s + q.getPrompt()
            + ": " + q.getAnswer() + "\n";
    
    // Use the folding function
    String result = questionnaire.fold(bf, "");
    
   
    String expected = "What is your eye color?: \nWhat is your sister's name?: \n"
            + "What is your favorite sports?: \n";
    assertEquals(expected, result);
  }
  
  /**
   * Test toString method.
   */
  @Test
  public void testToString() {
    Question q1 = new ShortAnswer("What is your name?", true);
    q1.answer("Luke");
    Question q2 = new ShortAnswer("What is your age?", false);
    q2.answer("25");
    Question q3 = new ShortAnswer("What is your favorite color?", true);
    q3.answer("Black");
    QuestionnaireImpl questionnaire = new QuestionnaireImpl();
    questionnaire.addQuestion("name", q1);
    questionnaire.addQuestion("age", q2);
    questionnaire.addQuestion("color", q3);
    
    // Get the questionnaire as a string
    String result = questionnaire.toString();
    
    // Check that the string includes the prompts and answers of all questions in the questionnaire
    String expected = "Question: What is your name?\n\nAnswer: Luke\n\n"
            + "Question: What is your age?\n\nAnswer: 25\n\n"
            + "Question: What is your favorite color?\n\nAnswer: Black";
    assertEquals(expected, result);
  }
}