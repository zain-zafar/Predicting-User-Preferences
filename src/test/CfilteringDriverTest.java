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

import java.io.ByteArrayInputStream;
import org.junit.Test;
import driver.CfilteringDriver;
import exceptions.InvalidNumberOfColumns;
import exceptions.InvalidNumberOfRows;
import exceptions.OutOfRangeException;
import exceptions.RatingOutOfRangeException;

public class CfilteringDriverTest {

  /*
   * Test to raise RatingOutOfRangeException, I have created a input3.txt file
   * which allows for this.
   * 
   * I FOUND THE WAY TO TEST HERE -----------------------------
   * https://stackoverflow.com/questions/6415728/
   * junit-testing-with-simulated-user-input
   * 
   * I DID KNOW HOW TO TEST USING ByteArrayInputStream --------
   */
  @Test(expected = RatingOutOfRangeException.class)
  public void testMainRaiseException() throws OutOfRangeException,
      RatingOutOfRangeException, InvalidNumberOfColumns, InvalidNumberOfRows {

    // Allows me to use input3.txt as input for the scanner.
    String[] args = null;
    ByteArrayInputStream in = new ByteArrayInputStream
        ("input3.txt".getBytes());
    System.setIn(in);
    CfilteringDriver.main(args);

  }

  /*
   * Test to raise InvalidNumberOfRows exception, I have created a 
   * input4.txt file which allows for this.
   */
  @Test(expected = InvalidNumberOfRows.class)
  public void testRows() throws OutOfRangeException, RatingOutOfRangeException,
      InvalidNumberOfColumns, InvalidNumberOfRows {

    // Allows me to use input4.txt as input for the scanner.
    String[] args = null;
    ByteArrayInputStream in = new ByteArrayInputStream
        ("input4.txt".getBytes());
    System.setIn(in);
    CfilteringDriver.main(args);
  }
  
  /*
   * Test to raise InvalidNumberOfColumns exception, I have created a 
   * input5.txt file which allows for this.
   */
  @Test(expected = InvalidNumberOfColumns.class)
  public void testColumns() throws OutOfRangeException, 
  RatingOutOfRangeException, InvalidNumberOfColumns, InvalidNumberOfRows {

    // Allows me to use input5.txt as input for the scanner.
    String[] args = null;
    ByteArrayInputStream in = new ByteArrayInputStream
        ("input5.txt".getBytes());
    System.setIn(in);
    CfilteringDriver.main(args);
  }
}
