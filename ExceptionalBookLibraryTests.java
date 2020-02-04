
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           ExceptionalLibraryTests
// Files:           None.
// Course:          Comp Sci 300, LEC-005, Spring 2019
//
// Author:          Shihan Cheng
// Email:           scheng93@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Ruoxi Shen
// Partner Email:   rshen27@wisc.edu
// Partner Lecturer's Name: LEC-005
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;

/**
 * Check if the methods in Class ExceptionalLibrary work. All the tests in this
 * class should return a boolean type
 * 
 * @author Shihan.Cheng Ruoxi.Shen
 *
 */
public class ExceptionalBookLibraryTests {

	/**
	 * Check if the LibraryParseCardBarCode work in the Class ExceptionalLibrary
	 * 
	 * @return true if the method throws exceptions correctly
	 */
	public static boolean testLibraryParseCardBarCode() {
		boolean check = false;
		// Create a new library object
		ExceptionalLibrary madison = new ExceptionalLibrary("Madison", "Shihan", "1233");
		// Initialize two strings as the arguments
		String num = "2019000003"; // Correct one
		String code = "2aaa19000001"; // Incorrect one

		try { // Call the method
			try { // Call the method with the correct card bar code
				System.out.println(madison.parseCardBarCode(num, 1));
			} catch (ParseException e) {
				check = true;
				System.out.println(e.getMessage());
			}
			// Call the method with the incorrect card bar code
			madison.parseCardBarCode(code, 2);
		} catch (ParseException e) {
			check = true;
			System.out.println(e.getMessage());
		}

		return check;
	}

	/**
	 * Check if the ParseRunLibrarianCheckoutBookCommand method work in the Class
	 * ExceptionalLibrary
	 * 
	 * @return true if the method throws exceptions correctly
	 */
	public static boolean testLibraryParseRunLibrarianCheckoutBookCommand() {
		boolean check = false;
		// Create a new library object
		ExceptionalLibrary madison = new ExceptionalLibrary("Madison", "Shihan", "1233");
		// Commands
		String commands[] = { "3", "Ruoxi", "10005", "Madison", "7633561" };
		try {
			// Try to add a new subscriber with incorrect commands
			madison.parseRunLibrarianAddSubscriberCommand(commands);
		} catch (ParseException e) {
			check = true;
			System.out.println(e.getMessage());
		} catch (InstantiationException e) {
			check = true;
			System.out.println(e.getMessage());
		}

		return check;
	}

	/**
	 * Check when the commands of book ID typed in incorrectly by the librarian, if
	 * the method throws exception
	 *
	 * @return true if works well
	 */
	public static boolean testLibraryParseRunSubscriberReturnBookCommand() {
		boolean check = false;
		// Create a new library object
		ExceptionalLibrary madison = new ExceptionalLibrary("Madison", "Shihan", "1233");
		// Create 4 new commands 
		String commands1[] = { "2", "Ruoxi", "1015", "Madison", "7633561" };
		String commands2[] = { "1", "java", "cheng" };
		String commands3[] = { "3", "2019000001", "1" };
		String commands4[] = { "4", "2019000001", "2" };
		try {
			// Add new subscriber
			madison.parseRunLibrarianAddSubscriberCommand(commands1);
			// Add new book
			madison.parseRunLibrarianAddBookCommand(commands2);
			// Check out the book
			madison.parseRunLibrarianCheckoutBookCommand(commands3);
			// Try the incorrect commands to return the book
			madison.parseRunLibrarianReturnBookCommand(commands4);
		} catch (ParseException e) {
			check = true;
			System.out.println(e.getMessage());
		} catch (InstantiationException e) {
			check = true;
			System.out.println(e.getMessage());
		}

		return check;
	}

	/**
	 * Check if the loadBook method works correctly when the file is either good or bad.
	 * When the file has problem, method should throw exceptions
	 * 
	 * @return true if test runs well
	 */
	public static boolean testParseRunLibrarianLoadBooksCommand() {
		boolean check = false;
		String commands[] = { "L", "books3.txt" };
		// Create a new library object
		ExceptionalLibrary madison = new ExceptionalLibrary("Madison", "Shihan", "1233");
		try {
			// try to load a book with some problems
			madison.parseRunLibrarianLoadBooksCommand(commands);
		} catch (ParseException e) {
			check = true;
			System.out.println(e.getMessage());
		}
		return check;
	}
	
	/**
	 * Check if the parse pin code method works well
	 * 
	 * @return true if it works correctly
	 */
	public static boolean testParsePinCode() {
		boolean check = false;
		// Initialize a string
		String s = "10550";
		// Create a new library object
		ExceptionalLibrary madison = new ExceptionalLibrary("Madison", "Shihan", "1233");
		try {
			madison.parsePinCode(s, 1);
		} catch (ParseException e) {
			check = true;
			System.out.println(e.getMessage());
		}
		return check;
		
	}
	/**
	 * The main method is to run the tests above. Call the methods within the print
	 * method to display the message. If the massage after the test method is true,
	 * then the method works. If false, the method has bugs
	 * 
	 * @param arg any String
	 */
	public static void main(String arg[]) {
		System.out.println("testLibraryParseCardBarCode(): " + testLibraryParseCardBarCode());
		System.out.println("testLibraryParseRunLibrarianCheckoutBookCommand(): "
				+ testLibraryParseRunLibrarianCheckoutBookCommand());
		System.out.println("testParseRunLibrarianLoadBooksCommand(): " + testParseRunLibrarianLoadBooksCommand());
		System.out.println("testLibraryParseRunSubscriberReturnBookCommand(): "
				+ testLibraryParseRunSubscriberReturnBookCommand());
		System.out.println("testParsePinCode(): " + testParsePinCode());
	}
}
