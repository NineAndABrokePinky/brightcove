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
		String emailAddresses, body;
	   
	    	try {
		    	emailAddresses= args[0];
		    	body= args[1];
		    	Message message;
	    		
	    		if (args[0] == "-im") {
	   	    	 	emailAddresses= args[1];
	   	    	 	body= args[2];
	   	    	 	message = new Chat(body, emailAddresses);
	    		} else {
	    			message = new Email(body, emailAddresses);
	    		}
	    		 getNetwork().write(message.createMessage(message.getEmailAddresses(), message.getBody()));
	    	} catch (Exception e) {
	    		if(e instanceof IOException) {
	    			getConsole().write("Connection error. Please try again." + '\n');
	    		} else {
	    			getConsole().write(e.getMessage());
	    		}
		}
			
	}
}