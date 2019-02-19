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
import org.junit.Before;
import org.junit.Test;
import exceptions.OutOfRangeException;
import calculate.CalculateScores;


public class CalculateScoresTest {
  CalculateScores scores;

  @Before
  public void setUp() throws OutOfRangeException {
    // Use the builder to make a 4x3 matrix
    scores = new CalculateScores();
  }

  /**
   * Test for calculating similarity score SAME AS populating the userUser
   * Matrix.
   */
  @Test
  public void testCalculateSimilarityScore() {

    // Empty userUserMatrix
    float[][] userUserMatrixEmpty = new float[4][4];

    // Create the userMovieMatrix
    int userMovieMatrix[][] = new int[4][3];
    for (int i = 0; i < userMovieMatrix.length; i++) {
      for (int j = 0; j < userMovieMatrix[0].length; j++) {
        userMovieMatrix[i][j] = 1;
      }
    }

    // the userUserMatrix
    float[][] userUserMatrix = new float[4][4];
    for (int i = 0; i < userUserMatrix.length; i++) {
      for (int j = 0; j < userUserMatrix[0].length; j++) {
        userUserMatrix[i][j] = 1.0000f;
      }
    }

    // Calculate scores and populate the userUsermatrix
    scores.calculateSimilarityScore(userUserMatrixEmpty, userMovieMatrix);

    // Compares the manually populated matrix to the method populated one
    assertArrayEquals(scores.getPopulatedMatrix(), userUserMatrix);

  }
}
