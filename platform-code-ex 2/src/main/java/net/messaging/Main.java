package net.messaging;

import java.io.*;

public class Main {
	private static Writer network;
	private static Writer console;

	/**
	 * Setter for network
	 * 
	 * @param network
	 *            - StringWriter
	 */
	public static void setNetwork(Writer network) {
		Main.network = network;
	}

	/**
	 * Setter for console
	 * 
	 * @param console
	 *            - StringWriter
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

	public static void main(String... args) throws IOException {
	    	
	    	setNetwork(new StringWriter());
	    	setConsole(new StringWriter());
	    	
	    	try {
	    		Email email = new Email(args[1], args[0]);
	    		getNetwork().write(email.createEmail(email.getEmailAddresses(), email.getBody()));
	    	} catch (Exception e) {
			getConsole().write(e.getMessage());
		}
			
}
}