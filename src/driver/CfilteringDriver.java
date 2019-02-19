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
package driver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import output.OutputToConsole;
import populateMatrix.Cfiltering;
import calculate.CalculateScores;
import exceptions.*;

public class CfilteringDriver {

  /**
   * Reads user movie ratings from a text file, calculates similarity scores
   * and prints a score matrix.
   */
  public static void main(String[] args) throws OutOfRangeException,
      RatingOutOfRangeException, InvalidNumberOfColumns, InvalidNumberOfRows {

    try {
      // open file to read
      String fileName;
      Scanner in = new Scanner(System.in);
      System.out.println("Enter the name of input file? ");
      fileName = in.nextLine();
      FileInputStream fStream = new FileInputStream(fileName);
      BufferedReader br = new BufferedReader(new InputStreamReader(fStream));
      // Read dimensions: number of users and number of movies
      int numberOfUsers = Integer.parseInt(br.readLine());
      int numberOfMovies = Integer.parseInt(br.readLine());

      /*
       * create a new Cfiltering object that contains: a) 2d matrix
       * i.e.userMovieMatrix (#users*#movies) b) 2d matrix i.e. userUserMatrix
       * (#users*#users)
       */
      Cfiltering cfObject =
          new Cfiltering.Builder(numberOfUsers, numberOfMovies).build();
      // this is a blank line being read
      br.readLine();

      // read each line of movie ratings and populate the userMovieMatrix
      String row;
      int rowCounter = 0; // Counts number of rows.
      while ((row = br.readLine()) != null) {
        int columnCounter = 0;
        // allRatings is a list of all String numbers on one row
        String allRatings[] = row.split(" ");
        for (String singleRating : allRatings) {
          // make the String number into an integer
          // populate userMovieMatrix
          int rating = Integer.parseInt(singleRating);
          cfObject.populateUserMovieMatrix(rowCounter, columnCounter,
              rating);
          columnCounter += 1; // Increase column to insert new rating.
        }
        // Make sure number of columns entered are the same as indicated
        if (columnCounter != numberOfMovies)
          throw new InvalidNumberOfColumns();
        rowCounter += 1; // Increase row to allow for insertion of new rating.
      }
      // close the file
      fStream.close();

      /*
       * Check if the number of rows entered matches the number of rows in the
       * matrix.
       */
      if (numberOfUsers != rowCounter)
        throw new InvalidNumberOfRows();

      // CALCULATE THE SIMILARITY SCORE BETWEEN USERS.
      new CalculateScores().calculateSimilarityScore(
          cfObject.getUserUserMatrix(), cfObject.getUserMovieMatrix());

      // Use the OutputToConsole object to print several things to console
      OutputToConsole toConsole =
          new OutputToConsole(cfObject.getUserUserMatrix());

      // PRINT OUT THE userUserMatrix
      toConsole.printUserUserMatrix();
      // Print OUT THE MOST SIMILAR PAIRS OF USER
      toConsole.findAndprintMostSimilarPairOfUsers();
      // PRINT THE MOST DISSIMILAR PAIR OF USERS.
      toConsole.findAndprintMostDissimilarPairOfUsers();

    } catch (FileNotFoundException e) {
      System.err.println("Do you have the input file in the root folder "
          + "of your project?");
      System.err.print(e.getMessage());
    } catch (IOException e) {
      System.err.print(e.getMessage());
    } catch (NumberFormatException e) {
      System.err.println(
          "Exception: Invalid rating entry found. " + "Please try again.");
    }
  }
}
