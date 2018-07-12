package net.messaging;

import java.io.*;

public class Main {
	private static Writer network;
	private static Writer console;

	/**
	 * Setter for network
	 * @param network -  StringWriter
	 */
	public static void setNetwork(Writer network) {
		Main.network = network;
	}
	
	/**
	 * Setter for console
	 * @param console -  StringWriter
	 */
	public static void setConsole(Writer console) {
		Main.console = console;
	}
	
	/**
	 * Getter for network
	 */
	public static Writer getNetwork() {
		return network;
	}
	
	/**
	 * Getter for Console
	 */
	public static Writer getConsole() {
		return console;
	}

	//TODO: Considering putting these into a Email Class
	/**
	 * This will construct the email that will be written to the StringBuffer
	 * @param emailAddress - String of the emailAddress to be sent to
	 * @param body - String of the message that will be sent in the email
	 * @return String of the email to be sent
	 * @throws IOException - In case of StringWriter not being initialized
	 */
	public static String createEmail(String emailAddress, String body) throws IOException {
		String email = "";
		email += Constants.CONNECTION_HEADER + '\n';
		email += Constants.PREFIX_TO + emailAddress + "\n\n";
		email += body + "\n\n";
		email += Constants.DISCONNECT + '\n';
		return email;
	}
	
	/**
	 * This will construct the message that the console will receive for a invalid email
	 * @param email - String of the emailAddress that is invalid
	 * @return String of the console to be logged
	 */
	public static String invalidEmailAddressMessage(String emailAddress) {
		String errorMessage = "";
		errorMessage += Constants.INVALID_EMAILADDRESS;
		errorMessage += emailAddress + '\n';
		return errorMessage;
	}

	public static void main(String... args) throws IOException {
	    	Utilities util = new Utilities();
	    	setNetwork(new StringWriter());
	    	setConsole(new StringWriter());
	    	
		if (util.checkForValidEmail(args[0])) {
			if(util.checkForValidBody(args[1])) {
				getNetwork().write(createEmail(args[0], args[1]));
				System.out.println(getNetwork());
			}
		} else {
			getConsole().write(invalidEmailAddressMessage(args[0]));
			System.out.println(getConsole());
		}
	}

}