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

	/**
	 * This will construct the email that will be written to the StringBuffer
	 * @param emailAddress - String of the emailAddress to be sent to
	 * @param body - String of the message that will be sent in the email
	 * @return
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

	public static void main(String... args) throws IOException {
	    	Utilities util = new Utilities();
	    	setNetwork(new StringWriter());
	    	
		if (util.checkForValidEmail(args[0]) && util.checkForValidBody(args[1])) {
			getNetwork().write(createEmail(args[0], args[1]));
			System.out.println(getNetwork());
		}
	}

}