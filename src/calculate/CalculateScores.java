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
package calculate;

import java.text.DecimalFormat;

public class CalculateScores {

  /**
   * This will store the 2D userUserMatrix when it has been populated which
   * will be utilized for testing.
   */
  private float[][] populatedMatrix;

  /**
   * Determines how similar each pair of users is based on their ratings. This
   * similarity value is represented with with a float value between 0 and 1,
   * where 1 is perfect/identical similarity. Stores these values in the
   * userUserMatrix.
   * 
   * @param userUserMatrix  The userUser matrix
   * @param userMovieMatrix The userMovie matrix
   */
  public void calculateSimilarityScore(float[][] userUserMatrix,
      int[][] userMovieMatrix) {

    // Used to achieve 4 decimal places.
    DecimalFormat correctDecimal = new DecimalFormat("#.####");

    // Find number of users.
    int numberOfUsers = userMovieMatrix.length;
    // Find number of movies rated.
    int numberOfMovies = userMovieMatrix[0].length;

    // Iterate through each row's columns and calculate distance
    for (int users = 0; users < numberOfUsers; users++) {
      for (int user = 0; user < numberOfUsers; user++) {
        // For storing the difference of squares between rows
        float colDiffSquared = 0;
        // Stores the sum of the differences of squares
        float sum = 0;
        if (users == user) { // If both row = col, then set it to 1.
          userUserMatrix[users][user] = 1;
        } else {

          /*
           * 1. Calculate distance between 2 rows/users by finding differences
           * of each column the 2 users occupy and then squaring that value and
           * iterating until all the column have passed while adding the square
           * of the differences. 2. Divide that sum + 1 by 1 (the similarity
           * score) and insert it into the userUserMatrix.
           */
          for (int column = 0; column < numberOfMovies; column++) {
            colDiffSquared = (float) Math.pow((userMovieMatrix[user][column]
                - userMovieMatrix[users][column]), 2);
            sum += colDiffSquared;
          }
          // Insert the similarity score into the userUserMatrix.
          userUserMatrix[users][user] = 1 / (float) (Math.sqrt(sum) + 1);
          userUserMatrix[users][user] = Float
              .valueOf(correctDecimal.format(userUserMatrix[users][user]));

        }
      }
    }
    // Set the instance variable as this populated matrix.
    this.populatedMatrix = userUserMatrix;
  }

  /**
   * Get the populated userUserMatrix
   * 
   * @return The populated userUserMatrix
   */
  public float[][] getPopulatedMatrix() {
    return this.populatedMatrix;
  }
}
