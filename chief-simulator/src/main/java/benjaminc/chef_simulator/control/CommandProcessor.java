package benjaminc.chef_simulator.control;

import java.util.HashMap;
import java.util.Map;

import benjaminc.chef_simulator.Game;
import benjaminc.chef_simulator.control.command.Command;

public class CommandProcessor {
	private Map<String, Command> commands;
	
	public CommandProcessor() {
		commands = new HashMap<String, Command>();
	}
	
	public void process(String cmd) {
		String args[] = cmd.split(" ");
		if(commands.containsKey(args[0])) {
			try {
				commands.get(args[0]).execute(args);
			} catch (Exception e) {
				Game.chat("An error occured while executing command " + args[0] + ". Check log for details");
				e.printStackTrace();
			}
		} else {
			Game.chat("Could not execute command " + args[0]);
		}
	}
	
	public void addCommand(Command c) {
		commands.put(c.getName(), c);
	}
	
	public void removeCommand(Command c) {
		commands.remove(c.getName());
	}
}