/**
 * 
 */
package net.messaging;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author joseph.edwards
 *
 */
public class Email {
	Utilities utils = new Utilities();
	private String body;
	private ArrayList<String> emailAddresses;
	/**
	 * Empty Constructor
	 */
	private Email() {
	}
	
	/**
	 * This will construct the email that will be written to the StringBuffer
	 * @param emailAddress - String of the emailAddress to be sent to
	 * @param body - String of the message that will be sent in the email
	 * @return String of the email to be sent
	 * @throws IOException - In case of StringWriter not being initialized
	 */
	public String createEmail(ArrayList<String> emailAddresses, String body) throws IOException {
		String email = "";
		email += Constants.CONNECTION_HEADER + '\n';
		for(String emailAddress : emailAddresses) {
		email += Constants.PREFIX_TO + emailAddress + "\n";
		}
		email += '\n';
		email += body + "\n\n";
		email += Constants.DISCONNECT + '\n';
		return email;
	}
	
	/**
	 * This will construct the message that the console will receive for a invalid email
	 * @param email - String of the emailAddress that is invalid
	 * @return String of the console to be logged
	 */
	private static String invalidEmailAddressMessage(ArrayList<String> emailAddresses) {
		String errorMessage = "";
		if (emailAddresses.size() > 1) {
			errorMessage += Constants.INVALID_EMAILADDRESSES;
			for(int i = 0; i <  emailAddresses.size(); i++) {
				errorMessage += emailAddresses.get(i);
				if ((i+1) != emailAddresses.size()) {
					errorMessage += ", ";
				}
			}
		} else {
		errorMessage += Constants.INVALID_EMAILADDRESS;
		errorMessage += emailAddresses.get(0);
		}
		errorMessage += '\n';
		return errorMessage;
	}
	
	/**
	 * This will construct the message that the console will receive for a invalid body
	 * @param body - String of the body that is invalid
	 * @return String of the console to be logged
	 */
	private static String invalidBodyMessage(String body) {
		String errorMessage = "";
		errorMessage += Constants.INVALID_BODY + '\n';
		return errorMessage;
	}
	
	/**
	 * Constructor for the email object that does the validation
	 * @param body - String of the emails body
	 * @param emailAddress - String of the emailAddresses
	 * @throws Exception - If there is a validation issue it will throw an exception with the message of the issue
	 */
	public Email(String body, String emailAddresses) throws Exception {
		ArrayList<String> validEmailAddressesList = new ArrayList<String>();
		ArrayList<String> invalidEmailAddressesList = new ArrayList<String>();
		if(utils.checkForValidBody(body)) {
			this.setBody(body);
		} else {
			throw new Exception(invalidBodyMessage(body));
		}
		ArrayList<String> emailAddressList = utils.checkForMultipleEmailAddresses(emailAddresses);
		if(emailAddressList.size() > 0) {
			for(String emailAddress : emailAddressList) {
				if (utils.checkForValidEmail(emailAddress)) {
					validEmailAddressesList.add(emailAddress);
				} else {
					invalidEmailAddressesList.add(emailAddress);
				}
			}
			if(invalidEmailAddressesList.size() > 0) {
				throw new Exception(invalidEmailAddressMessage(invalidEmailAddressesList));
			} else {
			this.setEmailAddresses(emailAddressList);
			}
		}
	}

	public ArrayList<String> getEmailAddresses() {
		return emailAddresses;
	}

	public void setEmailAddresses(ArrayList<String> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
}
