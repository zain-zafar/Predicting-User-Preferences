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

public interface PrintMatrixAndScores {
  /**
   * This interface is responsible for providing methods that will call helper
   * function to print their needs to the console.
   */
  public void printUserUserMatrix();

  public void findAndprintMostDissimilarPairOfUsers();

  public void findAndprintMostSimilarPairOfUsers();

}
