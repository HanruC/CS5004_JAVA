import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import questionnaire.Likert;
import questionnaire.Question;
import questionnaire.ShortAnswer;
import questionnaire.YesNo;

/**
 * Test class for question interface.
 */
public class QuestionTest {
  
  private Question yesNoQuestion;
  private Question shortAnswerQuestion;
  private Question likertQuestion;
  
  /**
   * Set up.
   */
  @Before
  public void setUp() {
    yesNoQuestion = new YesNo("Do you like me?", true);
    shortAnswerQuestion = new ShortAnswer("What is your favorite food?", false);
    likertQuestion = new Likert("you like studying?", true);
  }
  
  /**
   * Test getter prompt.
   */
  @Test
  public void testGetPrompt() {
    assertEquals("Do you like me?", yesNoQuestion.getPrompt());
    assertEquals("What is your favorite food?", shortAnswerQuestion.getPrompt());
    assertEquals("you like studying?", likertQuestion.getPrompt());
  }
  
  /**
   * Test is required method.
   */
  @Test
  public void testIsRequired() {
    assertTrue(yesNoQuestion.isRequired());
    assertFalse(shortAnswerQuestion.isRequired());
    assertTrue(likertQuestion.isRequired());
  }
  
  /**
   * Test null answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAnswerNull() {
    yesNoQuestion.answer(null);
  }
  
  /**
   * Test null short answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testShortAnswer() {
    shortAnswerQuestion.answer(null);
  }
  
  /**
   * Test likert invalid answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testLikertInvalidAnswer() {
    likertQuestion.answer("cool");
  }
  
  /**
   * Test getter answer.
   */
  @Test
  public void testGetAnswer() {
    yesNoQuestion.answer("Yes");
    assertEquals("Yes", yesNoQuestion.getAnswer());
    
    shortAnswerQuestion.answer("I love pizza.");
    assertEquals("I love this one.", shortAnswerQuestion.getAnswer());
    
    likertQuestion.answer("Agree");
    assertEquals("Agree", likertQuestion.getAnswer());
  }
  
  /**
   * Test copy.
   */
  @Test
  public void testCopy() {
    Question q1 = new YesNo("Do you like me?", true);
    q1.answer("yes");
    Question q2 = q1.copy();
    assertEquals(q1.getPrompt(), q2.getPrompt());
    assertEquals(q1.isRequired(), q2.isRequired());
    assertEquals(q1.getAnswer(), q2.getAnswer());
    q2.answer("no");
    assertNotEquals(q1.getAnswer(), q2.getAnswer());
  }
}