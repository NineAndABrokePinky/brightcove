package net.messaging;

import java.io.*;
import java.util.Scanner;

public class Main {
	private static Writer network;
	private static Writer console;

	public static void setNetwork(Writer network) {
		Main.network = network;
	}

	public static void setConsole(Writer console) {
		Main.console = console;
	}
	
	public static Writer getNetwork() {
		return network;
	}
	
	public static Writer getConsole() {
		return console;
	}

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