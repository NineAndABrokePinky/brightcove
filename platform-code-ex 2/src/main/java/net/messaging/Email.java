/**
 * 
 */
package net.messaging;
import java.util.ArrayList;

/**
 * @author joseph.edwards
 *
 */
public class Email extends Message {
	Utilities utils = new Utilities();
	
	/**
	 * This will construct the email that will be written to the StringBuffer
	 * @param emailAddress - String of the emailAddress to be sent to
	 * @param body - String of the message that will be sent in the email
	 * @param chatFormat - boolean value to change the format from email to chat
	 * @return String of the email to be sent
	 */
	public String createMessage(ArrayList<String> emailAddresses, String body) {
		String email = "";
			email += Constants.EMAIL_CONNECTION_HEADER + '\n';
			for(String emailAddress : emailAddresses) {
			email += Constants.PREFIX_TO + emailAddress + "\n";
			}
			email += '\n';
			email += body + "\n\n";
			email += Constants.DISCONNECT + '\n';
			return email;
	}
	
	/**
	 * Constructor for the email object that is thrown to its super (Message)
	 * @param body - String of the emails body
	 * @param emailAddress - String of the emailAddresses
	 * @throws Exception - If there is a validation issue it will throw an exception with the message of the issue
	 */
	public Email(String body, String emailAddresses) throws Exception {
		super(body, emailAddresses);
	}
	
}
