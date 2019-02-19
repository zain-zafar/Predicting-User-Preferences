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
import exceptions.RatingOutOfRangeException;
import populateMatrix.Cfiltering;

public class CfilteringTest {

  Cfiltering cfilter;

  @Before
  public void setUp() throws OutOfRangeException {
    cfilter = new Cfiltering.Builder(3, 3).build();
  }

  /*
   * Testing to check if matrix is being populated
   */
  @Test
  public void testPopulateUserMovieMatrixWithOneRating()
      throws RatingOutOfRangeException {

    int[][] matrix = cfilter.getUserMovieMatrix();

    // Populate 3,3 with 5
    matrix[2][2] = 5;

    // Populate the matrix with rating of 5
    cfilter.populateUserMovieMatrix(2, 2, 5);

    // Check if they match
    assertEquals(cfilter.getUserMovieMatrix()[2][2], matrix[2][2]);
  }

  /*
   * Test to raise exception; this exception is only raised when rating is not
   * in between 1 and 5
   */
  @Test(expected = RatingOutOfRangeException.class)
  public void testPopulateUserMovieMatrixWithException()
      throws RatingOutOfRangeException {

    // Populate the matrix with rating of 5
    cfilter.populateUserMovieMatrix(2, 2, 7);
  }

  /*
   * Test to raise exception; this exception is only raised when rating is not
   * in between 1 and 5
   */
  @Test(expected = RatingOutOfRangeException.class)
  public void testPopulateUserMovieMatrixWithException2()
      throws RatingOutOfRangeException {

    // Populate the matrix with rating of 5
    cfilter.populateUserMovieMatrix(2, 2, 0);
  }

  /*
   * Test the getUserMovieMatrix method
   */
  @Test
  public void testGetUserMovieMatrix() throws RatingOutOfRangeException {

    int[][] matrix = new int[3][3];
    int[][] expected = cfilter.getUserMovieMatrix();
    assertArrayEquals(matrix, expected);

  }
}
