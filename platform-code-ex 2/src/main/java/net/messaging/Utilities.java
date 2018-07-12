/**
 * 
 */
package net.messaging;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author joseph.edwards
 *
 */
public class Utilities {

	
	public Utilities() {
		
	}
	
	public boolean checkForValidEmail(String message) {
		if(message ==null || message == "") {
			return false;
		}
		Matcher match  = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(message);
		if (match.find()) {
			return true;
		} else {
		return false;
		}
	}
	
	public boolean checkForValidBody(String message) {
		if(message == null || message == "") {
			return false;
		} else {
			return true;
		}
		
	}
	
}
