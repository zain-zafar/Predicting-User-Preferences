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
package populateMatrix;

import exceptions.*;

public class Cfiltering {

  // this is a 2d matrix i.e. user*movie
  private final int userMovieMatrix[][];
  // this is a 2d matrix i.e. user*movie
  private final float userUserMatrix[][];

  public static class Builder {

    // 2 Required parameters and NO optional parameters
    private final int userMovieMatrix[][];
    private final float userUserMatrix[][];

    // Create the builder
    public Builder(int numbOfRows, int numbOfColumns)
        throws OutOfRangeException {
      // Throw exception; matrix cannot be created if requirements are not met.
      if ((numbOfRows < 3 || numbOfRows > 9)
          || (numbOfColumns < 3 || numbOfColumns > 9)) {
        throw new OutOfRangeException();
      }
      // Populate the matrix's
      userMovieMatrix = new int[numbOfRows][numbOfColumns];
      userUserMatrix = new float[numbOfRows][numbOfRows];
    }

    public Cfiltering build() {
      return new Cfiltering(this);
    }
  }

  private Cfiltering(Builder build) {
    this.userMovieMatrix = build.userMovieMatrix;
    this.userUserMatrix = build.userUserMatrix;
  }

  /**
   * The purpose of this method is to populate the UserMovieMatrix. As input
   * parameters it takes in a rowNumber, columnNumber and a rating value. The
   * rating value is then inserted in the UserMovieMatrix at the specified
   * rowNumber and the columnNumber.
   *
   * @param rowNumber    The row number of the userMovieMatrix.
   * @param columnNumber The column number of the userMovieMatrix.
   * @param ratingValue  The ratingValue to be inserted in the userMovieMatrix
   */
  public void populateUserMovieMatrix(int rowNumber, int columnNumber,
      int ratingValue) throws RatingOutOfRangeException {

    // Raise exception if rating value not in [1,5]
    if (!(1 <= ratingValue && ratingValue <= 5)) {
      throw new RatingOutOfRangeException();
    }
    userMovieMatrix[rowNumber][columnNumber] = ratingValue;
  }

  /**
   * Get the user movie matrix.
   *
   * @return The user movie matrix.
   */
  public int[][] getUserMovieMatrix() {
    return this.userMovieMatrix;
  }

  /**
   * Get the user user matrix.
   *
   * @return The user user matrix.
   */
  public float[][] getUserUserMatrix() {
    return this.userUserMatrix;
  }
}
