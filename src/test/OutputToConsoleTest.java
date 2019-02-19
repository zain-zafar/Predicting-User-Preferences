// **********************************************************
// Assignment3: Cfiltering
// UTORID: zafarsy4
// UT Student #: 1002534705
// Author: Syed Zain Zafar
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences. In this semester
// we will select any three of your assignments from total of 5 and run it
// for plagiarism check.
// *********************************************************
package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import output.OutputToConsole;
import org.junit.Before;
import org.junit.Test;

public class OutputToConsoleTest {

  OutputToConsole output;
  int[][] userMovieMatrix;
  float[][] userUserMatrix;
  List<String> actual;

  @Before
  public void setUp() {
    // Fill the userMovieMatrix
    userMovieMatrix = new int[4][3];
    for (int i = 0; i < userMovieMatrix.length; i++) {
      for (int j = 0; j < userMovieMatrix[0].length; j++) {
        userMovieMatrix[i][j] = 1;
      }
    }

    // Fill the userUserMatrix
    userUserMatrix = new float[4][4];
    for (int i = 0; i < userUserMatrix.length; i++) {
      for (int j = 0; j < userUserMatrix[0].length; j++) {
        userUserMatrix[i][j] = 1.0000f;
      }
    }
    output = new OutputToConsole(userUserMatrix);
    actual = new ArrayList<>();
  }

  /**
   * Tests the printUserUserMatrix method.
   */
  @Test
  public void testPrintUserUserMatrix() {

    // Run the printUserUserMatrix command
    output.printUserUserMatrix();
    // Now get the output list
    List<String> expected = output.getOutputList();

    List<String> actual = new ArrayList<>();

    actual.add("userUserMatrix is:");
    actual.add("[1.0000, 1.0000, 1.0000, 1.0000]");
    actual.add("[1.0000, 1.0000, 1.0000, 1.0000]");
    actual.add("[1.0000, 1.0000, 1.0000, 1.0000]");
    actual.add("[1.0000, 1.0000, 1.0000, 1.0000]");

    // Compare
    assertEquals(actual, expected);
  }

  /**
   * Tests the findAndPrintMostSimilarPairOfUsers method
   */
  @Test
  public void testFindAndprintMostSimilarPairOfUsers() {
    // Run the findAndprintMostSimilarPairOfUsers method
    output.findAndprintMostSimilarPairOfUsers();

    List<String> expected = output.getOutputList();

    actual
        .add("The most similar pairs of users from above userUserMatrix are:");
    actual.add("User1 and User2,");
    actual.add("User1 and User3,");
    actual.add("User1 and User4,");
    actual.add("User2 and User3,");
    actual.add("User2 and User4,");
    actual.add("User3 and User4");
    actual.add("with similarity score of 1.0000");

    assertEquals(actual, expected);
  }

  /**
   * Tests the findAndPrintMostDissimilarPairOfUsers method
   */
  @Test
  public void testFindAndprintMostDissimilarPairOfUsers() {
    // Run the findAndprintMostDissimilarPairOfUsers method
    output.findAndprintMostDissimilarPairOfUsers();

    List<String> expected = output.getOutputList();

    actual.add(
        "The most dissimilar pairs of users from above userUserMatrix are:");
    actual.add("User1 and User2,");
    actual.add("User1 and User3,");
    actual.add("User1 and User4,");
    actual.add("User2 and User3,");
    actual.add("User2 and User4,");
    actual.add("User3 and User4");
    actual.add("with similarity score of 1.0000");

    assertEquals(actual, expected);
  }
}

