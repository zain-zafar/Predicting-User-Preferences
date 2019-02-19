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
package exceptions;

public class InvalidNumberOfRows extends Exception {

  /**
   * Exception that is raised when the number of rows entered does not match 
   * the number of rows of the matrix.
   */
  public InvalidNumberOfRows() {
    super("Number of rows entered and the number of rows in "
        + " the matrix do not match.");
  }
}
