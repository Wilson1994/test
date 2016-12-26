package wumpus.wumpus;

import java.util.Scanner;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class StartAgents {

	public static void main(String[] args){
	
		String host = "localhost";
		int port = -1;

		Runtime runtime = Runtime.instance();
	
		Profile profile = new ProfileImpl(host, port, null, true);
		AgentContainer container = runtime.createMainContainer(profile);

		AgentController agent;
		try {
			agent = container.createNewAgent(
	                	Speleo.AGENT_RECEIVER_NAME,
	                    Speleo.class.getName(),
	                    args);
			agent.start();
		} catch(StaleProxyException e) {
			throw new RuntimeException(e);
		}

		AgentController agent2;
		try {
			 agent2 = container.createNewAgent(
	                	Navigator.AGENT_RECEIVER_NAME,
	                    Navigator.class.getName(),
	                    args);
			agent2.start();
	    } catch(StaleProxyException e) {
	        throw new RuntimeException(e);
	    }
		
	}
}
