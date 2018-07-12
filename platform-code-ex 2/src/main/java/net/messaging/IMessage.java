package net.messaging;

import java.util.ArrayList;

/**
 * 
 * @author joseph.edwards
 * interface for the Message abstract class
 */
public interface IMessage {

	String createMessage(ArrayList<String> emailAddresses, String body);
	
}
