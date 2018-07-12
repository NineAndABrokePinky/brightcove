package net.messaging;

import java.util.ArrayList;

/**
 * 
 * @author joseph.edwards
 * Abstract class for the shared functionality
 */
public abstract class Message implements IMessage {
	private String body;
	private ArrayList<String> emailAddresses;

	/**
	 * Constructor for the Message object that does the validation
	 * @param body - String of the emails body
	 * @param emailAddress - String of the emailAddresses
	 * @throws Exception - If there is a validation issue it will throw an exception with the message of the issue
	 */
	Message(String body, String emailAddresses) throws Exception {
		ArrayList<String> validEmailAddressesList = new ArrayList<String>();
		ArrayList<String> invalidEmailAddressesList = new ArrayList<String>();
		
		if(Utilities.checkForValidBody(body)) {
			this.setBody(body);
		} else {
			throw new Exception(invalidBodyMessage(body));
		}
		
		ArrayList<String> emailAddressList = Utilities.checkForMultipleEmailAddresses(emailAddresses);
		if(emailAddressList.size() > 0) {
			for(String emailAddress : emailAddressList) {
				if (Utilities.checkForValidEmail(emailAddress)) {
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
	
	/**
	 * This will construct the message that the console will receive for a invalid email
	 * @param email - String of the emailAddress that is invalid
	 * @return String of the console to be logged
	 */

	public String invalidEmailAddressMessage(ArrayList<String> emailAddresses) {
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
	public String invalidBodyMessage(String body) {
		String errorMessage = "";
		errorMessage += Constants.INVALID_BODY + '\n';
		return errorMessage;
	}
	
	/**
	 * Getter/Setters for class properties
	 * @return
	 */

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
