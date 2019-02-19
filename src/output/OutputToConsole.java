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
package output;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OutputToConsole implements PrintMatrixAndScores {

  /**
   * This stores the output that is being printed on the console. VERY useful
   * during testing.
   */
  private List<String> storeOutput;

  /**
   * The userUserMatrix
   */
  private float[][] userUserMatrix;

  /**
   * Default constructor.
   */
  public OutputToConsole() {}

  /**
   * Constructor with 2d array.
   */
  public OutputToConsole(float[][] matrixA) {
    userUserMatrix = matrixA;
    storeOutput = new ArrayList<>();
  }

  /**
   * Prints out the similarity scores of the userUserMatrix, with each row and
   * column representing each/single user and the cell position (i,j)
   * representing the similarity score between user i and user j.
   */
  public void printUserUserMatrix() {

    // Create list to hold rows.
    List<String> individualRow = new ArrayList<>();
    // Create variable to hold correct decimal place values.
    String correctDecimals = "";
    // Store the output
    storeOutput.add("userUserMatrix is:");

    // Iterate through each row's columns and format to 4 decimal places.
    for (int row = 0; row < userUserMatrix.length; row++) {
      for (int column = 0; column < userUserMatrix[0].length; column++) {
        // to 4 decimal places
        correctDecimals = String.format("%.4f", userUserMatrix[row][column]);

        // Add each element into the List
        individualRow.add(correctDecimals);
      }
      // Store the output
      storeOutput.add(individualRow.toString());
      // Clear the List to ensure old row is not retained.
      individualRow.clear();
    }
    // Print to console
    toString(storeOutput);
  }

  /**
   * This function finds and prints the most similar pair of users in the
   * userUserMatrix.
   */
  public void findAndprintMostSimilarPairOfUsers() {

    // Clear the list containing input
    storeOutput.clear();

    // Create a list of lists to store the similar user pairs.
    List<List> userList = new ArrayList<>();

    /*
     * Triggers the helper function to find the largest/most similar score and
     * passes the result to another helper to get similar user pairs and store
     * them in a list.
     */
    float value = getHighestOrLowestSimilarityScore("largest");
    userList = findUsers(value);
    Iterator<List> iterator = userList.iterator();
    // Store the output
    storeOutput
        .add("The most similar pairs of users from above userUserMatrix are:");
    // Iterate through the most similar user pair list.
    while (iterator.hasNext()) {
      List pair = iterator.next();
      // Print the user pairs, where the first element is always the first user
      // Add 1 that it starts from 1 and not 0
      int firstPairValue = (int) (pair.get(0)) + 1;
      int secondPairValue = (int) pair.get(1) + 1;
      // Print the desired output.
      if (iterator.hasNext()) {
        storeOutput
            .add("User" + firstPairValue + " and User" + secondPairValue +
                ",");
      } else {
        // Format to 4 decimal places.
        storeOutput
            .add("User" + firstPairValue + " and User" + secondPairValue);
        String strFormat = String.format("%.4f", value);
        storeOutput.add("with similarity score of " + strFormat);
      }
    }
    toString(storeOutput);
  }

  /**
   * This function finds and prints the most dissimilar pair of users in the
   * userUserMatrix.
   */
  public void findAndprintMostDissimilarPairOfUsers() {
    // Clear the list containing input
    storeOutput.clear();

    // Create a list of lists to store the similar user pairs.
    List<List> userList = new ArrayList<>();
    /*
     * Triggers the helper func to find the most dissimilar score and 
     * passes the result to another helper to get least similar user pairs
     *  and store them in a list.
     */
    float value = getHighestOrLowestSimilarityScore("smallest");
    userList = findUsers(value);
    Iterator<List> iterator = userList.iterator();
    // Print the required statement
    storeOutput.add(
        "The most dissimilar pairs of users from above userUserMatrix are:");
    // Iterate through the least similar user pair list.
    while (iterator.hasNext()) {
      List pair = iterator.next();
      // Print the user pairs, where the first element is always the first user
      int firstPairValue = (int) (pair.get(0)) + 1;
      int secondPairValue = (int) pair.get(1) + 1;
      // Print the desired output.
      if (iterator.hasNext()) {
        storeOutput
            .add("User" + firstPairValue + " and User" + secondPairValue +
                ",");
      } else {
        // Format to 4 decimal places.
        storeOutput
            .add("User" + firstPairValue + " and User" + secondPairValue);
        String strFormat = String.format("%.4f", value);
        storeOutput.add("with similarity score of " + strFormat);
      }
    }
    // Call the output method
    toString(storeOutput);
  }

  /**
   * This function finds the pairs of users with the highest/lowest similarity
   * rating and adds that pair into the list of pairs, where each pair is
   * stored as a list inside the pairs list.
   *
   * @param  similarityScore The highest or lowest similarity score from text
   * file.
   * @return The pairs of users as a list in a list of pairs
   * that have that rating. Duplicates are removed.
   */
  private List<List> findUsers(float similarityScore) {
    // List to store user pairs as a list.
    List<List> users = new ArrayList<>();
    // Iterate through the userUserMatrix and find the pair of users with the
    // similarity score required in the parameter.
    for (int row = 0; row < userUserMatrix.length; row++) {
      for (int col = 0; col < userUserMatrix[0].length; col++) {
        // Since users in the pair MUST be different, ignore when row = col.
        if (userUserMatrix[row][col] == similarityScore && row != col) {
          ArrayList<Integer> rowColUser = new ArrayList<>();
          /*
           * Change the inside to become a duplicate IF [0,1] then change the
           * [1,0] list to [0,1] and it won't be added to list of lists.
           */
          if (col > row) {
            rowColUser.add(row);
            rowColUser.add(col);
          } else {
            // Change the pair so that it matches which ever went in
            // the list first; formation of a duplicate.
            rowColUser.add(col);
            rowColUser.add(row);
          }
          // If pair already inside the list, do NOT add it.
          if (!users.contains(rowColUser)) {
            users.add(rowColUser);
          }
        }
      }
    }
    return users;
  }

  /**
   * This function finds the largest or the smallest similarity score based on
   * the test file as required.
   *
   * @param  smallestOrLargest This String controls if smallest similarity 
   * score is to be found or largest.
   * @return The smallest or largest similarity score.
   */
  private float getHighestOrLowestSimilarityScore(String smallestOrLargest) {
    float largest = 0;
    float smallest = 1;
    for (int row = 0; row < userUserMatrix.length; row++) {
      for (int col = 0; col < userUserMatrix[0].length; col++) {
        if (smallestOrLargest.equals("largest")) {
          if (row != col && userUserMatrix[row][col] >= largest) {
            largest = userUserMatrix[row][col];
          }
        } else if (smallestOrLargest.equals("smallest")) {
          if (row != col && userUserMatrix[row][col] <= smallest) {
            smallest = userUserMatrix[row][col];
          }
        }
      }
    }
    // Check if the smallest similarity score is to be returned.
    if (smallestOrLargest.equals("smallest")) {
      return smallest;
    }
    // Otherwise, return largest.
    return largest;
  }

  /**
   * This prints to the console.
   *
   * @param toPrint The stuff to be printed.
   */
  private void toString(List<String> toPrint) {
    System.out.print("\n\n");
    for (String rows : toPrint) {
      System.out.println(rows);
    }
  }

  /**
   * Return the list with the output
   *
   * @return The output list.
   */
  public List<String> getOutputList() {
    return this.storeOutput;
  }

}
