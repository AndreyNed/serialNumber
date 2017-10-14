package by.serialnumber.web.command;

import by.serialnumber.web.command.impl.ActionAnalyseSerialNumber;
import by.serialnumber.web.command.impl.ActionInputSerialNumber;

public class CommandChooser {
	
	public static BasicAction createAction( CommandType command ) {
		
		BasicAction action = null;
		
		switch( command ) {
		case INPUT:
			action = new ActionInputSerialNumber();
			break;
		case ANALYZE:
			action = new ActionAnalyseSerialNumber();
			break;
		default:
			System.out.println("Watning: command is unknown...");
		}
		
		return action;	
	}
	
}
