/**
 * 
 */
package net.messaging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author joseph.edwards
 * Utilities class for validation of email and body
 */
public class Utilities {


	
	/**
	 * This will validate that the emailAddress passed in is valid by using a regular expression
	 * @param emailAddress - String
	 * @return boolean - true if valid email is found and false if not
	 */
	 static boolean checkForValidEmail(String emailAddress) {
		if(emailAddress ==null || emailAddress == "") {
			return false;
		}
		Matcher match  = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(emailAddress);
		if (match.find()) {
			return true;
		} else {
		return false;
		}
	}
	
	/**
	 * This will validate that the message passed in is valid
	 * @param message - string
	 * @return boolean - true if valid message is found and false if not
	 */
	static boolean checkForValidBody(String message) {
		if(message == null || message == "") {
			return false;
		} else {
			return true;
		}
		
	}
	
	/**
	 * Checks the string for multiple email addresses by parsing using a comma delimiter
	 * @param emailAddresses - String of the possible emailAddresses
	 * @return ArrayList of the possible emailAddresses
	 */
	 static ArrayList<String> checkForMultipleEmailAddresses(String emailAddresses) {
		if(emailAddresses == null || emailAddresses == "") {
			return null;
		}
		ArrayList<String> emailAddressesArray = new ArrayList<>(Arrays.asList(emailAddresses.split(",")));
		return emailAddressesArray;
	}
	
}
