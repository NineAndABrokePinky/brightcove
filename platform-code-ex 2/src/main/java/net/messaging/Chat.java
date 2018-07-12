/**
 * 
 */
package net.messaging;

import java.util.ArrayList;

/**
 * @author joseph.edwards
 *
 */
public class Chat extends Message{

	Utilities utils = new Utilities();
	
	@Override
	public String createMessage(ArrayList<String> emailAddresses, String body) {
		String email = "";
		email += Constants.CHAT_CONNECTION_HEADER + '\n';
		for(String emailAddress : emailAddresses) {
			email += '<' + emailAddress+ '>';
			email += '(' + body + ')' + "\n";
		}
		email += Constants.DISCONNECT + '\n';
		return email;
	}
	
	/**
	 * Constructor for the chat object that is thrown to its super (Message)
	 * @param body - String of the emails body
	 * @param emailAddress - String of the emailAddresses
	 * @throws Exception - If there is a validation issue it will throw an exception with the message of the issue
	 */
	public Chat(String body, String emailAddresses) throws Exception {
		super(body, emailAddresses);
	}

}
